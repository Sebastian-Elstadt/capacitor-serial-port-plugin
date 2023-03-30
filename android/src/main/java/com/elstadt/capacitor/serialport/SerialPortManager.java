package com.elstadt.capacitor.serialport;

import android_serialport_api.SerialPort;
import android_serialport_api.SerialPortFinder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SerialPortManager {
    private SerialPortFinder serialPortFinder = new SerialPortFinder();
    private Map<String, ActiveSerialPort> activePorts = new HashMap();

    public void OpenPort(String port, int baudRate, SerialReadCallback readCallback) {
        try{
            if (activePorts.containsKey(port)) {
                this.ClosePort(port);
            }

            SerialPort serialPort = new SerialPort(new File(port), baudRate, 0);
            ActiveSerialPort activePort = new ActiveSerialPort(
                    serialPort,
                    new SerialReadThread(serialPort.getInputStream(), readCallback)
            );

            activePort.readThread.setName("serialReadThread-" + port);
            activePort.readThread.run();

            activePorts.put(port, activePort);
        }
        catch (Throwable e)
        {
            readCallback.Error(e.getMessage());
        }
    }

    public void ClosePort(String port) throws IOException {
        ActiveSerialPort removedSerialPort =  activePorts.remove(port);
        removedSerialPort.readThread.interrupt();
        removedSerialPort.serialPort.close();
    }

    public String[] GetSerialPorts(boolean getPaths){
        if (getPaths) {
            return serialPortFinder.getAllDevicesPath();
        }

        return serialPortFinder.getAllDevices();
    }

    public void WriteToPort(String port, String data) throws IOException {
        if (!activePorts.containsKey(port)) {
            return;
        }

        ActiveSerialPort activePort = activePorts.get(port);
        activePort.serialPort.getOutputStream().write(data.getBytes());
    }
}
