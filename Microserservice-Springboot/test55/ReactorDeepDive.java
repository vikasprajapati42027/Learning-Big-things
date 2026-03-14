package com.example.reactive;

import reactor.core.publisher.Flux;
import java.util.List;

public class ReactorDeepDive {

    public void fluxTransformation() {
        Flux<String> names = Flux.just("vikas", "rahul", "anjali")
                .map(String::toUpperCase)
                .filter(name -> name.startsWith("V"));

        // Nothing happens until subscribe!
        names.subscribe(System.out::println);
    }
}
