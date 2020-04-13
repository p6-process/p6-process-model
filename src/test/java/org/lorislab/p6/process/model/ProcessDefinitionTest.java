package org.lorislab.p6.process.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.lorislab.p6.process.model.runtime.ProcessDefinitionLoader;

import java.io.File;

@DisplayName("Process definition tests")
public class ProcessDefinitionTest {

    @Test
    @DisplayName("Load start-end process test")
    public void startEndProcessTest() {
        ProcessDefinition pd = ProcessDefinitionLoader.load(new File("src/test/resources/startEndProcess.yaml"));
        Assertions.assertNotNull(pd);
        Assertions.assertEquals("startEndProcess", pd.id);
        Assertions.assertEquals("1.2.3", pd.version);
        Assertions.assertNotNull(pd.labels);
        Assertions.assertEquals(2, pd.labels.size());
        Assertions.assertEquals("test", pd.labels.get("application"));
        Assertions.assertEquals("module", pd.labels.get("module"));
        Assertions.assertNotNull(pd.metadata);
        Assertions.assertEquals(1, pd.metadata.size());
        Assertions.assertEquals(true, pd.metadata.get("ALL_PARAMETERS"));
        Assertions.assertNotNull(pd.nodes);
        Assertions.assertEquals(2, pd.nodes.size());
        StartEvent se = (StartEvent) pd.nodes.get("start");
        Assertions.assertNotNull(se);
        Assertions.assertEquals("start", se.name);
        Assertions.assertEquals(Type.START_EVENT, se.type);
        Assertions.assertNotNull(se.next);
        Assertions.assertEquals(1, se.next.size());
        Assertions.assertEquals("end", se.next.get(0));
        EndEvent ee = (EndEvent) pd.nodes.get("end");
        Assertions.assertNotNull(ee);
        Assertions.assertEquals("end", ee.name);
        Assertions.assertEquals(Type.END_EVENT, ee.type);
        Assertions.assertNotNull(ee.next);
        Assertions.assertEquals(0, ee.next.size());
    }

    @Test
    @DisplayName("Load service-task process test")
    public void serviceTaskProcessTest() {
        ProcessDefinition pd = ProcessDefinitionLoader.load(new File("src/test/resources/serviceTaskProcess.yaml"));
        Assertions.assertNotNull(pd);
        Assertions.assertNotNull(pd.nodes);
        Assertions.assertEquals(3, pd.nodes.size());
    }

    @Test
    @DisplayName("Load parallel-gateway process test")
    public void parallelGatewayProcessTest() {
        ProcessDefinition pd = ProcessDefinitionLoader.load(new File("src/test/resources/parallelGatewayProcess.yaml"));
        Assertions.assertNotNull(pd);
        Assertions.assertNotNull(pd.nodes);
        Assertions.assertEquals(8, pd.nodes.size());
    }

    @Test
    @DisplayName("Load inclusive-gateway process test")
    public void inclusiveGatewayProcessTest() {
        ProcessDefinition pd = ProcessDefinitionLoader.load(new File("src/test/resources/inclusiveGatewayProcess.yaml"));
        Assertions.assertNotNull(pd);
        Assertions.assertNotNull(pd.nodes);
        Assertions.assertEquals(7, pd.nodes.size());
    }

    @Test
    @DisplayName("Load exclusive-gateway process test")
    public void exclusiveGatewayProcessTest() {
        ProcessDefinition pd = ProcessDefinitionLoader.load(new File("src/test/resources/exclusiveGatewayProcess.yaml"));
        Assertions.assertNotNull(pd);
        Assertions.assertNotNull(pd.nodes);
        Assertions.assertEquals(6, pd.nodes.size());
    }
}
