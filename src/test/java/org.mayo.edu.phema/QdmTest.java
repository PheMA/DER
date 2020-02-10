package org.mayo.edu.phema;

import org.mayo.edu.phema.rest.QDM_REST;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QdmTest {

    @Test
    void testCategories() {
        QDM_REST qdm_rest = new QDM_REST();
        Response response = qdm_rest.getCategories();
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategory() {
        QDM_REST qdm_rest = new QDM_REST();
        Response response = qdm_rest.getCategory("AdverseEvent");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypes( ) {
        QDM_REST qdm_rest = new QDM_REST();
        Response response = qdm_rest.getDatatypes();
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatype() {
        QDM_REST qdm_rest = new QDM_REST();
        Response response = qdm_rest.getDatatype("AdverseEvent");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategoryDatatypes() {
        QDM_REST qdm_rest = new QDM_REST();
        Response response = qdm_rest.getCategoryDatatypes("AdverseEvent");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategoryDatatype() {
        QDM_REST qdm_rest = new QDM_REST();
        Response response = qdm_rest.getCategoryDatatype("AdverseEvent", "AdverseEvent");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testAttributes() {
        QDM_REST qdm_rest = new QDM_REST();
        Response response = qdm_rest.getAttributes();
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypeAttributes(  ) {
        QDM_REST qdm_rest = new QDM_REST();
        Response response = qdm_rest.getDatatypeAttributes("AdverseEvent");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypeAttribute() {
        QDM_REST qdm_rest = new QDM_REST();
        Response response = qdm_rest.getDatatypeAttribute("AdverseEvent", "RelevantPeriod");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testAttributesAttribute() {
        QDM_REST qdm_rest = new QDM_REST();
        Response response = qdm_rest.getAttributes("RelevantPeriod");
        assertEquals(200, response.getStatus());
    }

}