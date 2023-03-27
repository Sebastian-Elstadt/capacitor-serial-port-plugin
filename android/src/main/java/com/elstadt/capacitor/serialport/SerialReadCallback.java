package com.elstadt.capacitor.serialport;

public interface SerialReadCallback {
    void OnRead(String result);
    void Error(String err);
}
