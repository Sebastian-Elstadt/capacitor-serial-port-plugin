export interface IOpenPortOptions {
    port: string;
    baudRate: number;
}
export interface IClosePortOptions {
    port: string;
}
export interface IGetSerialPortsOptions {
    getPaths: boolean;
}
export interface IWriteToSerialOptions {
    port: string;
    data: string;
}
export declare type CallbackID = string;
export declare type SerialPortReadCallback = (data: {
    data: string;
}, err?: any) => void;
export interface SerialPortPlugin {
    OpenPort(options: IOpenPortOptions, callback: SerialPortReadCallback): Promise<CallbackID>;
    ClosePort(options: IClosePortOptions): Promise<void>;
    GetSerialPorts(options: IGetSerialPortsOptions): Promise<{
        ports: string[];
    }>;
    WriteToPort(options: IWriteToSerialOptions): Promise<void>;
}
