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

import com.fasterxml.jackson.databind.util.StdConverter;
import org.lorislab.p6.process.model.Type;

public class ProcessDefinitionRuntimeDeserializer extends StdConverter<ProcessDefinitionRuntime, ProcessDefinitionRuntime> {

    @Override
    public ProcessDefinitionRuntime convert(ProcessDefinitionRuntime value) {
        if (value.nodes != null) {
            value.nodes.forEach((name,node) -> {

                // previous
                for (String n : node.next) {
                    value.nodes.get(n).previous.add(name);
                }

                // start event
                if (node.type == Type.START_EVENT) {
                    value.startNodes.put(name, node);
                }
            });
        }
        return value;
    }
}
