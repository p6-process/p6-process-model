/*
 * Copyright 2019 lorislab.org.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lorislab.p6.process.model.runtime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.ToString;
import org.lorislab.p6.process.model.Node;
import org.lorislab.p6.process.model.ProcessDefinition;

import java.util.HashMap;
import java.util.Map;

@ToString(callSuper = true)
@JsonDeserialize(converter = ProcessDefinitionRuntimeDeserializer.class)
public class ProcessDefinitionRuntime extends ProcessDefinition {

    public Map<String, Node> startNodes = new HashMap<>();

}
