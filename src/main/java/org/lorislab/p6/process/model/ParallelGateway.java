package org.lorislab.p6.process.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ParallelGateway extends Gateway {

    public ParallelGateway() {
        type = Type.PARALLEL_GATEWAY;
    }

}
