# capacitor-serial-port

A Capacitor compatible serial port plugin

## Install

```bash
npm install capacitor-serial-port
npx cap sync
```

## API

<docgen-index>

* [`OpenPort(...)`](#openport)
* [`ClosePort(...)`](#closeport)
* [`GetSerialPorts(...)`](#getserialports)
* [`WriteToSerial(...)`](#writetoserial)
* [Interfaces](#interfaces)
* [Type Aliases](#type-aliases)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### OpenPort(...)

```typescript
OpenPort(options: IOpenPortOptions, callback: SerialPortReadCallback) => Promise<CallbackID>
```

| Param          | Type                                                                      |
| -------------- | ------------------------------------------------------------------------- |
| **`options`**  | <code><a href="#iopenportoptions">IOpenPortOptions</a></code>             |
| **`callback`** | <code><a href="#serialportreadcallback">SerialPortReadCallback</a></code> |

**Returns:** <code>Promise&lt;string&gt;</code>

--------------------


### ClosePort(...)

```typescript
ClosePort(options: IClosePortOptions) => Promise<void>
```

| Param         | Type                                                            |
| ------------- | --------------------------------------------------------------- |
| **`options`** | <code><a href="#icloseportoptions">IClosePortOptions</a></code> |

--------------------


### GetSerialPorts(...)

```typescript
GetSerialPorts(options: IGetSerialPortsOptions) => Promise<{ ports: string[]; }>
```

| Param         | Type                                                                      |
| ------------- | ------------------------------------------------------------------------- |
| **`options`** | <code><a href="#igetserialportsoptions">IGetSerialPortsOptions</a></code> |

**Returns:** <code>Promise&lt;{ ports: string[]; }&gt;</code>

--------------------


### WriteToSerial(...)

```typescript
WriteToSerial(options: IWriteToSerialOptions) => Promise<void>
```

| Param         | Type                                                                    |
| ------------- | ----------------------------------------------------------------------- |
| **`options`** | <code><a href="#iwritetoserialoptions">IWriteToSerialOptions</a></code> |

--------------------


### Interfaces


#### IOpenPortOptions

| Prop           | Type                |
| -------------- | ------------------- |
| **`port`**     | <code>string</code> |
| **`baudRate`** | <code>number</code> |


#### IClosePortOptions

| Prop       | Type                |
| ---------- | ------------------- |
| **`port`** | <code>string</code> |


#### IGetSerialPortsOptions

| Prop           | Type                 |
| -------------- | -------------------- |
| **`getPaths`** | <code>boolean</code> |


#### IWriteToSerialOptions

| Prop       | Type                |
| ---------- | ------------------- |
| **`port`** | <code>string</code> |
| **`data`** | <code>string</code> |


### Type Aliases


#### SerialPortReadCallback

<code>(data: { data: string; }, err?: any): void</code>


#### CallbackID

<code>string</code>

</docgen-api>
