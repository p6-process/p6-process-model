package org.lorislab.p6.process.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public enum Sequence {

  UNSPECIFIED,

  MIX,

  CONVERGING,

  DIVERGING;
}
