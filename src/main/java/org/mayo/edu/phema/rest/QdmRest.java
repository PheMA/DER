package org.mayo.edu.phema.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.mayo.edu.phema.helper.QdmStmt;


/**
 * This class contains the REST service calls pertaining to QDM data elements.
 */
@Path("/qdm")
public class QdmRest extends ElementRest  {

   /**
    * Returns all the QDM Categories
    * @return  JSON Response
    */
   @GET
   @Path("/categories")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getCategories() {
       return queryRepository(QdmStmt.QDM_CATEGORIES);
   }
   
   /**
    * Returns the specified QDM Category
    * @param category is the name of the Category
    * @return  JSON Response
    */
   @GET
   @Path("/category/{category}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getCategory(@PathParam("category") String category) {
       return queryRepository(QdmStmt.getQdmCategoryStatement(category));
   }
   
   /**
    * Returns all QDM Datatypes
    * @return  JSON Response
    */
   @GET
   @Path("/datatypes")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getDatatypes( ) {
       return queryRepository(QdmStmt.QDM_DATATYPES);
   }
   
   /**
    * Returns the specified QDM Datatype
    * @param datatype is the name of the Datatype
    * @return  JSON Response
    */
   @GET
   @Path("/datatype/{datatype}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getDatatype(@PathParam("datatype") String datatype) {
       return queryRepository(QdmStmt.getQdmDatatypeStatement(datatype));
   }
   
   /**
    * Returns all the QDM Datatypes for a specified Category
    * @param category is the name of the Category
    * @return JSON Response
    */
   @GET
   @Path("/category/{category}/datatypes")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getCategoryDatatypes(@PathParam("category") String category) {
       return queryRepository(QdmStmt.getQdmDatatypesForCategoryStatement(category));
   }
   
   /**
    * Returns a specific QDM Datatype for a specified Category
    * @param category is the name of the Category
    * @param datatype is the name of the Datatype
    * @return JSON Response
    */
   @GET
   @Path("category/{category}/datatype/{datatype}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getCategoryDatatype(@PathParam("category") String category, @PathParam("datatype") String datatype) {
       return queryRepository(QdmStmt.getQdmDatatypeForCategoryStatement(category, datatype));
   }
   
   /**
    * Returns all QDM Attributes
    * @return JSON Response
    */
   @GET
   @Path("/attributes")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getAttributes() {
       return queryRepository(QdmStmt.QDM_ATTRIBUTES);
   }
   
   /**
    * Returns all QDM Attributes for a specified Datatype
    * @param datatype is the name of the Datatype
    * @return JSON Response
    */
   @GET
   @Path("/datatype/{datatype}/attributes")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getDatatypeAttributes(@PathParam("datatype") String datatype) {
       return queryRepository(QdmStmt.getQdmAttributesForDatatypeStatement(datatype));
   }
   
   /**
    * Returns all instances of a specific QDM Datatype
    * @param datatype is the name of the Datatype
    * @return JSON Response
    */
   @GET
   @Path("/datatype/{datatype}/instances")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getDatatypeInstances(@PathParam("datatype") String datatype) {
       return queryRepository(QdmStmt.getQdmInstancesForDatatypeStatement(datatype));
   }
   
   /**
    * Returns a specific QDM Attribute for a specified Datatype
    * @param datatype is the name of the datatype
    * @param attribute is the name of the attribute
    * @return JSON Response
    */
   @GET
   @Path("/datatype/{datatype}/attribute/{attribute}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getDatatypeAttribute(@PathParam("datatype") String datatype, @PathParam("attribute") String attribute) {
       return queryRepository(QdmStmt.getQdmAttributeForDatatypeStatement(datatype, attribute));
   }
   
   /**
    * Returns all QDM Attributes with a specified name
    * @param attribute is the name of the attribute
    * @return JSON Response
    */
   @GET
   @Path("/attribute/{attribute}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getAttributes(@PathParam("attribute") String attribute) {
       return queryRepository(QdmStmt.getQdmAttributesStatement(attribute));
   }

}