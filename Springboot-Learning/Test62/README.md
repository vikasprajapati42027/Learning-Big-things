# Test 62: Protocol Buffers (Proto3)

The language of gRPC.

## What is a .proto file?
It's where you define your data structure.

```protobuf
syntax = "proto3";

message UserRequest {
  string name = 1;
  int32 id = 2;
  bool active = 3;
}

message UserResponse {
  string message = 1;
}

service HelloService {
  rpc sayHello (UserRequest) returns (UserResponse);
}
```

## Why the numbers? ( = 1, = 2 )
In JSON, the key name "name" is repeated for every object. In Protobuf, only the number `1` is sent. This is why it's so small and fast!
