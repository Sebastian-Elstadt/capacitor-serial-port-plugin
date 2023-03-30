package com.elstadt.capacitor.serialport;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class SerialReadThread extends Thread{
    private InputStream inputStream;
    private SerialReadCallback readCallback;

    public SerialReadThread(final InputStream inputStream, final SerialReadCallback readCallback){
        this.inputStream = inputStream;
        this.readCallback = readCallback;
    }

    @Override
    public void run(){
        super.run();

        while (!this.isInterrupted()) {
            try {
                if(inputStream == null) return;

                byte[] buffer = new byte[1024];
                int size = inputStream.read(buffer);
                if (size > 0) {
                    readCallback.OnRead(new String(buffer, StandardCharsets.UTF_8));
                }
            }
            catch (Throwable e) {
                readCallback.Error(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
