import { WebPlugin } from '@capacitor/core';
export class SerialPortWeb extends WebPlugin {
    // @ts-ignore
    async OpenPort(options, callback) {
        throw 'serial port plugin is not supported for web';
    }
    // @ts-ignore
    async ClosePort(options) {
        throw 'serial port plugin is not supported for web';
    }
    // @ts-ignore
    async GetSerialPorts(options) {
        throw 'serial port plugin is not supported for web';
    }
    // @ts-ignore
    async WriteToSerial(options) {
        throw 'serial port plugin is not supported for web';
    }
}
//# sourceMappingURL=web.js.map