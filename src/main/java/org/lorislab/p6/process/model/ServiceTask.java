package org.lorislab.p6.process.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ServiceTask extends Node {

    public ServiceTask() {
        type = Type.SERVICE_TASK;
    }
}
