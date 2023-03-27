import { registerPlugin } from '@capacitor/core';
const SerialPort = registerPlugin('SerialPort', {
    web: () => import('./web').then(m => new m.SerialPortWeb()),
});
export * from './definitions';
export { SerialPort };
//# sourceMappingURL=index.js.map