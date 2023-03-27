import { WebPlugin } from '@capacitor/core';

import type { CallbackID, IClosePortOptions, IGetSerialPortsOptions, IOpenPortOptions, IWriteToSerialOptions, SerialPortPlugin, SerialPortReadCallback } from './definitions';

export class SerialPortWeb extends WebPlugin implements SerialPortPlugin {
  // @ts-ignore
  async OpenPort(options: IOpenPortOptions, callback: SerialPortReadCallback): Promise<CallbackID> {
    throw 'serial port plugin is not supported for web';
  }

  // @ts-ignore
  async ClosePort(options: IClosePortOptions): Promise<void> {
    throw 'serial port plugin is not supported for web';
  }

  // @ts-ignore
  async GetSerialPorts(options: IGetSerialPortsOptions): Promise<void> {
    throw 'serial port plugin is not supported for web';
  }

  // @ts-ignore
  async WriteToSerial(options: IWriteToSerialOptions): Promise<void> {
    throw 'serial port plugin is not supported for web';
  }
}
