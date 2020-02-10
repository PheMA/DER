package org.mayo.edu.phema;

import org.mayo.edu.phema.rest.CQL_REST;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CqlTest {

    @Test
    void testCategories() {
        CQL_REST cql_rest = new CQL_REST();
        Response response = cql_rest.getCategories();
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategory() {
        CQL_REST cql_rest = new CQL_REST();
        Response response = cql_rest.getCategory("CQLLogicalOperators");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypes( ) {
        CQL_REST cql_rest = new CQL_REST();
        Response response = cql_rest.getDatatypes();
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatype() {
        CQL_REST cql_rest = new CQL_REST();
        Response response = cql_rest.getDatatype("CQLLogicalOperators");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategoryDatatypes() {
        CQL_REST cql_rest = new CQL_REST();
        Response response = cql_rest.getCategoryDatatypes("CQLLogicalOperators");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategoryDatatype() {
        CQL_REST cql_rest = new CQL_REST();
        Response response = cql_rest.getCategoryDatatype("CQLLogicalOperators", "CQLLogicalOperators");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testAttributes() {
        CQL_REST cql_rest = new CQL_REST();
        Response response = cql_rest.getAttributes();
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypeAttributes(  ) {
        CQL_REST cql_rest = new CQL_REST();
        Response response = cql_rest.getDatatypeAttributes("CQLLogicalOperators");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypeAttribute() {
        CQL_REST cql_rest = new CQL_REST();
        Response response = cql_rest.getDatatypeAttribute("CQLLogicalOperators", "And");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testAttributesAttribute() {
        CQL_REST cql_rest = new CQL_REST();
        Response response = cql_rest.getAttributes("And");
        assertEquals(200, response.getStatus());
    }

}