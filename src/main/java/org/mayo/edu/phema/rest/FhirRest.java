package org.mayo.edu.phema.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.mayo.edu.phema.helper.FhirStmt;

/**
 * This class contains the REST service calls pertaining to FHIR data elements.
 */
@Path("/fhir")
public class FhirRest extends ElementRest {
    
   /**
    * Returns all FHIR Categories
    * @return  JSON Response
    */
   @GET
   @Path("/categories")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getCategories() {
       return queryRepository(FhirStmt.FHIR_CATEGORIES);
   }
   
   /**
    * Returns a specified FHIR Category
    * @param category is the name of the Category
    * @return JSON Response
    */
   @GET
   @Path("/category/{category}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getCategory(@PathParam("category") String category) {
       return queryRepository(FhirStmt.getFhirCategoryStatement(category));
   }
   
   /**
    * Returns all FHIR Datatypes
    * @return JSON Response
    */
   @GET
   @Path("/datatypes")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getDatatypes( ) {
       return queryRepository(FhirStmt.FHIR_DATATYPES);
   }
   
   /**
    * Returns a specified FHIR Datatype
    * @param datatype is the name of the datatype
    * @return JSON Response
    */
   @GET
   @Path("/datatype/{datatype}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getDatatype(@PathParam("datatype") String datatype) {
       return queryRepository(FhirStmt.getFhirDatatypeStatement(datatype));
   }
   
   /**
    * Returns all FHIR Datatypes based on a specific FHRI Category
    * @param category is the name of the Category
    * @return JSON Response
    */
   @GET
   @Path("/category/{category}/datatypes")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getCategoryDatatypes(@PathParam("category") String category) {
       return queryRepository(FhirStmt.getFhirDatatypesForCategoryStatement(category));
   }
   
   /**
    * Returns a specified FHIR Datatype for a specific FHIR Category
    * @param category is the name of the category
    * @param datatype is the name of the datatype
    * @return JSON Response
    */
   @GET
   @Path("category/{category}/datatype/{datatype}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getCategoryDatatype(@PathParam("category") String category, @PathParam("datatype") String datatype) {
       return queryRepository(FhirStmt.getFhirDatatypeForCategoryStatement(category, datatype));
   }
   
   /**
    * Returns all FHIR Attributes
    * @return JSON Response
    */
   @GET
   @Path("/attributes")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getAttributes() {
       return queryRepository(FhirStmt.FHIR_ATTRIBUTES);
   }
   
   /**
    * Returns all FHIR attributes based on the name of the datatype
    * @param datatype is the name of the datatype
    * @return JSON Response
    */
   @GET
   @Path("/datatype/{datatype}/attributes")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getDatatypeAttributes(@PathParam("datatype") String datatype) {
       return queryRepository(FhirStmt.getFhirAttributesForDatatypeStatement(datatype));
   }
   
   /**
    * Returns a specified FHIR Attribute for a specific FHIR Datatype
    * @param datatype is the name of the datatype
    * @param attribute is the name of the attribute
    * @return JSON Response
    */
   @GET
   @Path("/datatype/{datatype}/attribute/{attribute}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getDatatypeAttribute(@PathParam("datatype") String datatype, @PathParam("attribute") String attribute) {
       return queryRepository(FhirStmt.getFhirAttributeForDatatypeStatement(datatype, attribute));
   }
   
   /**
    * Returns a specified FHIR Attribute
    * @param attribute is the name of the attribute
    * @return JSON Response
    */
   @GET
   @Path("/attribute/{attribute}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getAttributes(@PathParam("attribute") String attribute) {
       return queryRepository(FhirStmt.getFhirAttributesStatement(attribute));
   }


}