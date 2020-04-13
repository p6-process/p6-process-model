package org.lorislab.p6.process.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.DelegatingDeserializer;

import java.io.IOException;

public class NodeNameDeserializer extends DelegatingDeserializer {

    private static final long serialVersionUID = 1L;

    private transient BeanDescription description;

    public NodeNameDeserializer(JsonDeserializer<?> delegate, BeanDescription description) {
        super(delegate);
        this.description = description;
    }

    @Override
    protected JsonDeserializer<?> newDelegatingInstance(JsonDeserializer<?> delegate) {
        return new NodeNameDeserializer(delegate, description);
    }

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
        Object tmp = super.deserialize(p, ctx);
        if (tmp instanceof Node) {
            Node node = (Node) tmp;
            node.name = p.getParsingContext().getCurrentName();
        }
        return tmp;
    }
}
