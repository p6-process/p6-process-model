package org.lorislab.p6.process.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@RegisterForReflection
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProcessDefinition {

    public String id;

    public String version;

    public Map<String, String> labels = new HashMap<>();

    public Map<String, Object> metadata = new HashMap<>();

    public Map<String, Node> nodes = new HashMap<>();

    @Override
    public String toString() {
        return "ProcessDefinition:" + id + ":"  + version;
    }
}
