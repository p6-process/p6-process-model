package org.lorislab.p6.process.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public enum Type {

    @JsonProperty(Type.TYPE_SCRIPT_TASK)
    SCRIPT_TASK,

    @JsonProperty(Type.TYPE_END_EVENT)
    END_EVENT,

    @JsonProperty(Type.TYPE_START_EVENT)
    START_EVENT,

    @JsonProperty(Type.TYPE_SERVICE_TASK)
    SERVICE_TASK,

    @JsonProperty(Type.TYPE_EXCLUSIVE_GATEWAY)
    EXCLUSIVE_GATEWAY,

    @JsonProperty(Type.TYPE_INCLUSIVE_GATEWAY)
    INCLUSIVE_GATEWAY,

    @JsonProperty(Type.TYPE_PARALLEL_GATEWAY)
    PARALLEL_GATEWAY,

    @JsonProperty(Type.TYPE_CALL_ACTIVITY)
    CALL_ACTIVITY;

    public static final String TYPE_SCRIPT_TASK = "SCRIPT_TASK";

    public static final String TYPE_END_EVENT = "END_EVENT";

    public static final String TYPE_START_EVENT = "START_EVENT";

    public static final String TYPE_SERVICE_TASK = "SERVICE_TASK";

    public static final String TYPE_EXCLUSIVE_GATEWAY = "EXCLUSIVE_GATEWAY";

    public static final String TYPE_INCLUSIVE_GATEWAY = "INCLUSIVE_GATEWAY";

    public static final String TYPE_PARALLEL_GATEWAY = "PARALLEL_GATEWAY";

    public static final String TYPE_CALL_ACTIVITY = "CALL_ACTIVITY";
}
