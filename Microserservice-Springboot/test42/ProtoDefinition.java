/*
 syntax = "proto3";
 package com.example.grpc;

 service HelloService {
   rpc sayHello (HelloRequest) returns (HelloResponse);
 }

 message HelloRequest {
   string name = 1;
 }

 message HelloResponse {
   string message = 1;
 }
*/
package com.example.grpc;

import org.springframework.stereotype.Service;

@Service
public class ProtoStorage {
    public String getProtoDefinition() {
        return "This service uses Protocol Buffers for fast binary communication.";
    }
}
