package org.lorislab.p6.process.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ScriptTask extends Node {

  public ScriptTask() {
    type = Type.SCRIPT_TASK;
  }

  public String script = null;
}
