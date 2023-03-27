package com.elstadt.capacitor.serialport;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.util.JSONUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CapacitorPlugin(name = "SerialPort")
public class SerialPortPlugin extends Plugin {
    public Map<String, PluginCall> portCallbacks = new HashMap();
    public SerialPortManager serialPortManager = new SerialPortManager();

    @PluginMethod(returnType = PluginMethod.RETURN_CALLBACK)
    public void OpenPort(PluginCall call) {
        try{
            String port = call.getString("port");
            int baudRate = call.getInt("baudRate");

            if (portCallbacks.containsKey(port)) {
                portCallbacks.remove(port).release(bridge);
            }

            call.setKeepAlive(true);
            serialPortManager.OpenPort(port, baudRate, new SerialReadCallback() {
                @Override
                public void OnRead(String result) {
                    JSObject objResult = new JSObject();
                    objResult.put("data", result);
                    call.resolve(objResult);
                }

                @Override
                public void Error(String err) {
                    call.reject(err);
                }
            });

            portCallbacks.put(port, call);
        }
        catch(Throwable err){
            call.reject(err.getMessage());
        }
    }

    @PluginMethod
    public void ClosePort(PluginCall call) {
        try {
            String port = call.getString("port");
            if(portCallbacks.containsKey(port)){
                portCallbacks.remove(port).release(bridge);
            }

            serialPortManager.ClosePort(port);
            call.resolve();
        }
        catch(Throwable err){
            call.reject(err.getMessage());
        }
    }

    @PluginMethod
    public void GetSerialPorts(PluginCall call){
        JSObject result = new JSObject();
        JSArray portsArray = new JSArray();
        for (String port : serialPortManager.GetSerialPorts(call.getBoolean("getPaths"))) {
            portsArray.put(port);
        }
        result.put("ports", portsArray);
        call.resolve(result);
    }

    @PluginMethod
    public void WriteToPort(PluginCall call){
        try{
            String port = call.getString("port");
            String data = call.getString("data");

            serialPortManager.WriteToPort(port, data);
            call.resolve();
        }
        catch(Throwable e){
            call.reject(e.getMessage());
        }
    }
}
