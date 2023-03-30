package com.elstadt.capacitor.serialport;

import android_serialport_api.SerialPort;

public class ActiveSerialPort {
    public SerialPort serialPort;
    public SerialReadThread readThread;

    public ActiveSerialPort(final SerialPort serialPort, final SerialReadThread readThread){
        this.serialPort = serialPort;
        this.readThread = readThread;
    }
}
