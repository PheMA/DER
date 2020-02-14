package org.mayo.edu.phema;

import org.mayo.edu.phema.rest.CqlRest;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CqlTest {

    @Test
    void testCategories() {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getCategories();
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategory() {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getCategory("CQLLogicalOperators");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypes( ) {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getDatatypes();
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatype() {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getDatatype("CQLLogicalOperators");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategoryDatatypes() {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getCategoryDatatypes("CQLLogicalOperators");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategoryDatatype() {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getCategoryDatatype("CQLLogicalOperators", "CQLLogicalOperators");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testAttributes() {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getAttributes();
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypeAttributes(  ) {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getDatatypeAttributes("CQLLogicalOperators");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypeAttribute() {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getDatatypeAttribute("CQLLogicalOperators", "And");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testAttributesAttribute() {
        CqlRest cqlRest = new CqlRest();
        Response response = cqlRest.getAttributes("And");
        assertEquals(200, response.getStatus());
    }

}