package org.lorislab.p6.process.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class InclusiveGateway extends Gateway {

    public InclusiveGateway() {
        type = Type.INCLUSIVE_GATEWAY;
    }
}
