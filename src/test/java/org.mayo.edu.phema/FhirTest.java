package org.mayo.edu.phema;


import org.mayo.edu.phema.rest.FhirRest;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FhirTest {

    @Test
    void testCategories() {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getCategories();
        System.out.println(response.getEntity().toString());
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategory() {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getCategory("AllergyIntolerance");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypes( ) {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getDatatypes();
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatype() {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getDatatype("AllergyIntolerance");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategoryDatatypes() {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getCategoryDatatypes("AllergyIntolerance");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testCategoryDatatype() {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getCategoryDatatype("AllergyIntolerance", "AllergyIntolerance");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testAttributes() {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getAttributes();
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypeAttributes(  ) {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getDatatypeAttributes("AllergyIntolerance");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testDatatypeAttribute() {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getDatatypeAttribute("AllergyIntolerance", "Asserter");
        assertEquals(200, response.getStatus());
    }

    @Test
    void testAttributesAttribute() {
        FhirRest fhirRest = new FhirRest();
        Response response = fhirRest.getAttributes("Asserter");
        assertEquals(200, response.getStatus());
    }
}