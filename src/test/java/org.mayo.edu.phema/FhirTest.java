package org.mayo.edu.phema;


import org.mayo.edu.phema.rest.FhirRest;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FhirTest extends SparqlTest {

    @Test
    void testCategories() {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getCategories();
        assertEquals(146, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategory() {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getCategory("AllergyIntolerance");
        assertEquals(1, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypes( ) {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getDatatypes();
        assertEquals(146, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatype() {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getDatatype("AllergyIntolerance");
        assertEquals(1, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategoryDatatypes() {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getCategoryDatatypes("AllergyIntolerance");
        assertEquals(1, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategoryDatatype() {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getCategoryDatatype("AllergyIntolerance", "AllergyIntolerance");
        assertEquals(1, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testAttributes() {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getAttributes();
        assertEquals(7972, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypeAttributes(  ) {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getDatatypeAttributes("AllergyIntolerance");
        assertEquals(39, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypeAttribute() {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getDatatypeAttribute("AllergyIntolerance", "Asserter");
        assertEquals(1, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }

    @Test
    void testAttributesAttribute() {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getAttributes("AllergyIntolerance.asserter");
        assertEquals(1, getResponseCount(response));
        assertEquals(200, response.getStatus());
    }
}