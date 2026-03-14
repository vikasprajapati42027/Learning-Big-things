package com.example.graph;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Node
class Person {
    @Id private String name;
    
    @Relationship(type = "FRIEND_OF")
    private List<Person> friends;
    
    // Getters and Setters
}

@Repository
public interface PersonRepository extends Neo4jRepository<Person, String> {
    // Cypher query: Find friends of friends
    List<Person> findByFriendsFriendsName(String name);
}
