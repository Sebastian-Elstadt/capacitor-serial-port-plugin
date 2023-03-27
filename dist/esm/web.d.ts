import { WebPlugin } from '@capacitor/core';
import type { CallbackID, IClosePortOptions, IGetSerialPortsOptions, IOpenPortOptions, IWriteToSerialOptions, SerialPortPlugin, SerialPortReadCallback } from './definitions';
export declare class SerialPortWeb extends WebPlugin implements SerialPortPlugin {
    OpenPort(options: IOpenPortOptions, callback: SerialPortReadCallback): Promise<CallbackID>;
    ClosePort(options: IClosePortOptions): Promise<void>;
    GetSerialPorts(options: IGetSerialPortsOptions): Promise<void>;
    WriteToSerial(options: IWriteToSerialOptions): Promise<void>;
}
