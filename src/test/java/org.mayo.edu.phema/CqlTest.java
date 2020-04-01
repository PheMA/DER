package org.mayo.edu.phema;

import org.mayo.edu.phema.rest.CqlRest;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CqlTest extends SparqlTest {

    @Test
    void testCategories() {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getCategories();
        assertEquals(14, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategory() {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getCategory("CQL Logical Operators");
        assertEquals(1, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypes( ) {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getDatatypes();
        assertEquals(14, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatype() {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getDatatype("CQL Logical Operators");
        assertEquals(1, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategoryDatatypes() {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getCategoryDatatypes("CQL_00003");
        assertEquals(1, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategoryDatatype() {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getCategoryDatatype("CQL_00003", "CQL Logical Operators");
        assertEquals(1, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testAttributes() {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getAttributes();
        assertEquals(348, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypeAttributes(  ) {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getDatatypeAttributes("CQL_10003");
        assertEquals(5, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypeAttribute() {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getDatatypeAttribute("CQL_10003", "And");
        assertEquals(1, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testAttributesAttribute() {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getAttributes("And");
        assertEquals(1, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

}