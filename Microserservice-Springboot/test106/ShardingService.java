package com.example.sharding;

import org.springframework.stereotype.Service;

@Service
public class ShardingService {

    public String getShardForUser(int userId) {
        // Horizontal Scaling Strategy (Sharding)
        // userId % 2 decides which database to use
        if (userId % 2 == 0) {
            return "Routing to Database_SHARD_A";
        } else {
            return "Routing to Database_SHARD_B";
        }
    }
}
