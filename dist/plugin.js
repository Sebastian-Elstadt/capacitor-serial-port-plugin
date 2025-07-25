var CapacitorSerialPort = (function (exports, core) {
    'use strict';

    const SerialPort = core.registerPlugin('SerialPort', {
        web: () => Promise.resolve().then(function () { return web; }).then(m => new m.SerialPortWeb()),
    });

    class SerialPortWeb extends core.WebPlugin {
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
        async WriteToPort(options) {
            throw 'serial port plugin is not supported for web';
        }
    }

    var web = /*#__PURE__*/Object.freeze({
        __proto__: null,
        SerialPortWeb: SerialPortWeb
    });

    exports.SerialPort = SerialPort;

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
