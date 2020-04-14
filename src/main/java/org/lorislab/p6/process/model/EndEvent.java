package org.lorislab.p6.process.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class EndEvent extends Node {

    public EndEvent() {
        type = Type.END_EVENT;
    }
}
