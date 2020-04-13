package org.lorislab.p6.process.model;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString(callSuper = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        visible = false)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ServiceTask.class, name = Type.TYPE_SERVICE_TASK),
        @JsonSubTypes.Type(value = ExclusiveGateway.class, name = Type.TYPE_EXCLUSIVE_GATEWAY),
        @JsonSubTypes.Type(value = ScriptTask.class, name = Type.TYPE_SCRIPT_TASK),
        @JsonSubTypes.Type(value = InclusiveGateway.class, name = Type.TYPE_INCLUSIVE_GATEWAY),
        @JsonSubTypes.Type(value = ParallelGateway.class, name = Type.TYPE_PARALLEL_GATEWAY),
        @JsonSubTypes.Type(value = StartEvent.class, name = Type.TYPE_START_EVENT),
        @JsonSubTypes.Type(value = EndEvent.class, name = Type.TYPE_END_EVENT),
})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class Node {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Type type;

    public List<String> next = new ArrayList<>();

    public Map<String, String> labels = new HashMap<>();

    public Map<String, Object> metadata = new HashMap<>();

    @JsonIgnore
    public List<String> previous = new ArrayList<>();
}
