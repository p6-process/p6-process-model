package org.lorislab.p6.process.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ExclusiveGateway extends Gateway {

    public ExclusiveGateway() {
        type = Type.EXCLUSIVE_GATEWAY;
    }
}
