package org.mayo.edu.phema;


import org.mayo.edu.phema.rest.FHIR_REST;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FhirTest {

    @Test
    void testCategories() {
        FHIR_REST fhir_rest = new FHIR_REST();
        Response response = fhir_rest.getCategories();
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategory() {
        FHIR_REST fhir_rest = new FHIR_REST();
        Response response = fhir_rest.getCategory("AllergyIntolerance");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypes( ) {
        FHIR_REST fhir_rest = new FHIR_REST();
        Response response = fhir_rest.getDatatypes();
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatype() {
        FHIR_REST fhir_rest = new FHIR_REST();
        Response response = fhir_rest.getDatatype("AllergyIntolerance");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategoryDatatypes() {
        FHIR_REST fhir_rest = new FHIR_REST();
        Response response = fhir_rest.getCategoryDatatypes("AllergyIntolerance");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategoryDatatype() {
        FHIR_REST fhir_rest = new FHIR_REST();
        Response response = fhir_rest.getCategoryDatatype("AllergyIntolerance", "AllergyIntolerance");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testAttributes() {
        FHIR_REST fhir_rest = new FHIR_REST();
        Response response = fhir_rest.getAttributes();
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypeAttributes(  ) {
        FHIR_REST fhir_rest = new FHIR_REST();
        Response response = fhir_rest.getDatatypeAttributes("AllergyIntolerance");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypeAttribute() {
        FHIR_REST fhir_rest = new FHIR_REST();
        Response response = fhir_rest.getDatatypeAttribute("AllergyIntolerance", "Asserter");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testAttributesAttribute() {
        FHIR_REST fhir_rest = new FHIR_REST();
        Response response = fhir_rest.getAttributes("Asserter");
        assertEquals(200, response.getStatus());
    }
}