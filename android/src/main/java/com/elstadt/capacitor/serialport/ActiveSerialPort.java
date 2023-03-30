package com.elstadt.capacitor.serialport;

import android_serialport_api.SerialPort;
import java.io.File;
import java.io.IOException;

public class ActiveSerialPort {
    public SerialPort serialPort;
    public SerialReadThread readThread;

    public ActiveSerialPort(String port, int baudRate, final SerialReadCallback readCallback) throws IOException {
        this.serialPort = new SerialPort(new File(port), baudRate, 0);
        readThread = new SerialReadThread(this.serialPort.getInputStream(), readCallback);

        readThread.setName("serialReadThread-" + port);
        readThread.start();
    }
}
