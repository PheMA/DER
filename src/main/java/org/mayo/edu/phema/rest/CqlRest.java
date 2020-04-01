package org.mayo.edu.phema.rest;

import org.mayo.edu.phema.helper.CqlStmt;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * This class contains the REST service calls pertaining to CQL data elements.
 */
@Path("/cql")
public class CqlRest extends ElementRest {

   /**
    * Returns all CQL Categories
    * @return  JSON Response
    */
   @GET
   @Path("/categories")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getCategories() {
       return queryRepository(CqlStmt.CQL_CATEGORIES);
   }
   
   /**
    * Returns a specified CQL Category
    * @param category is the name of the Category
    * @return JSON Response
    */
   @GET
   @Path("/category/{category}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getCategory(@PathParam("category") String category) {
       return queryRepository(CqlStmt.getCqlCategoryStatement(category));
   }
   
   /**
    * Returns all CQL Datatypes
    * @return JSON Response
    */
   @GET
   @Path("/datatypes")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getDatatypes( ) {
       return queryRepository(CqlStmt.CQL_DATATYPES);
   }
   
   /**
    * Returns a specified CQL Datatype
    * @param datatype is the name of the datatype
    * @return JSON Response
    */
   @GET
   @Path("/datatype/{datatype}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getDatatype(@PathParam("datatype") String datatype) {
       return queryRepository(CqlStmt.getCqlDatatypeStatement(datatype));
   }
   
   /**
    * Returns all CQL Datatypes based on a specific CQL Category
    * @param category is the name of the Category
    * @return JSON Response
    */
   @GET
   @Path("/category/{category}/datatypes")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getCategoryDatatypes(@PathParam("category") String category) {
       return queryRepository(CqlStmt.getCqlDatatypesForCategoryStatement(category));
   }
   
   /**
    * Returns a specified CQL Datatype for a specific CQL Category
    * @param category is the name of the category
    * @param datatype is the name of the datatype
    * @return JSON Response
    */
   @GET
   @Path("category/{category}/datatype/{datatype}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getCategoryDatatype(@PathParam("category") String category, @PathParam("datatype") String datatype) {
       return queryRepository(CqlStmt.getCqlDatatypeForCategoryStatement(category, datatype));
   }
   
   /**
    * Returns all CQL Attributes
    * @return JSON Response
    */
   @GET
   @Path("/attributes")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getAttributes() {
       return queryRepository(CqlStmt.CQL_ATTRIBUTES);
   }
   
   /**
    * Returns all CQL attributes based on the name of the datatype
    * @param datatype is the name of the datatype
    * @return JSON Response
    */
   @GET
   @Path("/datatype/{datatype}/attributes")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getDatatypeAttributes(@PathParam("datatype") String datatype) {
       return queryRepository(CqlStmt.getCqlAttributesForDatatypeStatement(datatype));
   }
   
   /**
    * Returns a specified CQL Attribute for a specific CQL Datatype
    * @param datatype is the name of the datatype
    * @param attribute is the name of the attribute
    * @return JSON Response
    */
   @GET
   @Path("/datatype/{datatype}/attribute/{attribute}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getDatatypeAttribute(@PathParam("datatype") String datatype, @PathParam("attribute") String attribute) {
       return queryRepository(CqlStmt.getCqlAttributeForDatatypeStatement(datatype, attribute));
   }
   
   /**
    * Returns a specified CQL Attribute
    * @param attribute is the name of the attribute
    * @return JSON Response
    */
   @GET
   @Path("/attribute/{attribute}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getAttributes(@PathParam("attribute") String attribute) {
       return queryRepository(CqlStmt.getCqlAttributesStatement(attribute));
   }
   




}