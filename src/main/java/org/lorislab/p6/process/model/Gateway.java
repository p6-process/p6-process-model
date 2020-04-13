package org.lorislab.p6.process.model;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString(callSuper = true)
public class Gateway extends Node {

  public Sequence sequence = null;

  public String defaultNext = null;

  public Map<String, String> condition = new HashMap<>();
}
