  package de.solovyov.spring.apiexample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;
import java.util.UUID;

/**
 *
 * @author yuriysolovyov
 */
public class Person {
    
    private final UUID id;
    @NotNull
    private final String name;

    public Person(@JsonProperty("id") UUID id, 
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
    
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    
}
