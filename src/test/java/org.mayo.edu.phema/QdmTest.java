package org.mayo.edu.phema;

import org.mayo.edu.phema.rest.QdmRest;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QdmTest extends SparqlTest {

    @Test
    void testCategories() {
        QdmRest qdmRest = new QdmRest();
        Response response = qdmRest.getCategories();
        assertEquals(21, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategory() {
        QdmRest qdmRest = new QdmRest();
        Response response = qdmRest.getCategory("AdverseEvent");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypes( ) {
        QdmRest qdmRest = new QdmRest();
        Response response = qdmRest.getDatatypes();
        assertEquals(53, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatype() {
        QdmRest qdmRest = new QdmRest();
        Response response = qdmRest.getDatatype("AdverseEvent");
        assertEquals(1, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategoryDatatypes() {
        QdmRest qdmRest = new QdmRest();
        Response response = qdmRest.getCategoryDatatypes("AdverseEvent");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategoryDatatype() {
        QdmRest qdmRest = new QdmRest();
        Response response = qdmRest.getCategoryDatatype("AdverseEvent", "AdverseEvent");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testAttributes() {
        QdmRest qdmRest = new QdmRest();
        Response response = qdmRest.getAttributes();
        assertEquals(349, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypeAttributes(  ) {
        QdmRest qdmRest = new QdmRest();
        Response response = qdmRest.getDatatypeAttributes("AdverseEvent");
        assertEquals(7, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypeAttribute() {
        QdmRest qdmRest = new QdmRest();
        Response response = qdmRest.getDatatypeAttribute("AdverseEvent", "RelevantPeriod");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testAttributesAttribute() {
        QdmRest qdmRest = new QdmRest();
        Response response = qdmRest.getAttributes("RelevantPeriod");
        assertEquals(200, response.getStatus());
    }

}