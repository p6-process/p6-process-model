package org.lorislab.p6.process.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class StartEvent extends Node {

    public StartEvent() {
        type = Type.START_EVENT;
    }
}
