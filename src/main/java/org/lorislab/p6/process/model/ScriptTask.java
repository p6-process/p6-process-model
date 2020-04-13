package org.lorislab.p6.process.model;


public class ScriptTask extends Node {

  public ScriptTask() {
    type = Type.SCRIPT_TASK;
  }

  public String script = null;
}
