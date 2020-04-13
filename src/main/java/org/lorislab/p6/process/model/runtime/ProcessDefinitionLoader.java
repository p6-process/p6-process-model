package org.lorislab.p6.process.model.runtime;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import org.lorislab.p6.process.model.ProcessDefinition;
import org.lorislab.p6.process.model.NodeNameDeserializer;

import java.io.File;

import static com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature.*;

public class ProcessDefinitionLoader {

    private static final ObjectReader PROCESS_DEF_READER;

    private static final ObjectWriter PROCESS_DEF_WRITER;

    private static final ObjectReader PROCESS_DEF_RUNTIME_READER;

    static {
        ObjectMapper mapper = new ObjectMapper(
                new YAMLFactory()
                        .enable(YAMLGenerator.Feature.MINIMIZE_QUOTES)
                        .disable(USE_NATIVE_OBJECT_ID)
                        .disable(USE_NATIVE_TYPE_ID)
                        .disable(WRITE_DOC_START_MARKER)
        );
        registerJsonMapKeyAnnotation(mapper);
        PROCESS_DEF_READER = mapper.readerFor(ProcessDefinition.class);
        PROCESS_DEF_WRITER = mapper.writerFor(ProcessDefinition.class);
        PROCESS_DEF_RUNTIME_READER = mapper.readerFor(ProcessDefinitionRuntime.class);
    }

    public static void registerJsonMapKeyAnnotation(ObjectMapper objectMapper) {
        SimpleModule module = new SimpleModule();
        module.setDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config,
                                                          BeanDescription beanDescription, JsonDeserializer<?> originalDeserializer) {
                return new NodeNameDeserializer(originalDeserializer, beanDescription);
            }
        });
        objectMapper.registerModule(module);
    }

    public static  ProcessDefinitionRuntime loadRuntime(File file) {
        try {
            return PROCESS_DEF_RUNTIME_READER.readValue(file);
        } catch (Exception ex) {
            throw new IllegalStateException("Error read process runtime definition from file", ex);
        }
    }

    public static  ProcessDefinitionRuntime loadRuntime(String data) {
        try {
            return PROCESS_DEF_RUNTIME_READER.readValue(data);
        } catch (Exception ex) {
            throw new IllegalStateException("Error read process runtime definition", ex);
        }
    }

    public static  ProcessDefinition load(File file) {
        try {
            return PROCESS_DEF_READER.readValue(file);
        } catch (Exception ex) {
            throw new IllegalStateException("Error read process definition from file", ex);
        }
    }

    public static  ProcessDefinition load(String data) {
        try {
            return PROCESS_DEF_READER.readValue(data);
        } catch (Exception ex) {
            throw new IllegalStateException("Error read process definition", ex);
        }
    }

    public static  String toString(ProcessDefinition pd) {
        try {
            return PROCESS_DEF_WRITER.writeValueAsString(pd);
        } catch (Exception ex) {
            throw new IllegalStateException("Error write the process definition", ex);
        }
    }

    public static void toFile(File file, ProcessDefinition pd) {
        try {
            PROCESS_DEF_WRITER.writeValue(file, pd);
        } catch (Exception ex) {
            throw new IllegalStateException("Error write the process definition to file", ex);
        }
    }

    private ProcessDefinitionLoader() {}
}
