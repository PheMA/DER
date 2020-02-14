package org.mayo.edu.phema.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mayo.edu.phema.helper.SparqlStmt;


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
       return queryRepository(SparqlStmt.QDM_CATEGORIES);
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
       return queryRepository(SparqlStmt.getQdmCategoryStatement(category));
   }
   
   /**
    * Returns all QDM Datatypes
    * @return  JSON Response
    */
   @GET
   @Path("/datatypes")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getDatatypes( ) {
       return queryRepository(SparqlStmt.QDM_DATATYPES);
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
       return queryRepository(SparqlStmt.getQdmDatatypeStatement(datatype));
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
       return queryRepository(SparqlStmt.getQdmDatatypesForCategoryStatement(category));
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
       return queryRepository(SparqlStmt.getQdmDatatypeForCategoryStatement(category, datatype));
   }
   
   /**
    * Returns all QDM Attributes
    * @return JSON Response
    */
   @GET
   @Path("/attributes")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getAttributes() {
       return queryRepository(SparqlStmt.QDM_ATTRIBUTES);
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
       return queryRepository(SparqlStmt.getQdmAttributesForDatatypeStatement(datatype));
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
       return queryRepository(SparqlStmt.getQdmInstancesForDatatypeStatement(datatype));
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
       return queryRepository(SparqlStmt.getQdmAttributeForDatatypeStatement(datatype, attribute));
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
       return queryRepository(SparqlStmt.getQdmAttributesStatement(attribute));
   }
   
   /**
    * Returns all QDM Logical Operators  
    * @return JSON Response
    */
   @GET
   @Path("/logicalOperators")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getLogicalOperators( ) {
       return queryRepository(SparqlStmt.QDM_LOGICAL_OPERATORS);
   }
   
   /**
    * Returns a specific QDM Logical Operator
    * @param logicalOperator the name of the Logical Operator
    * @return JSON Response
    */
   @GET
   @Path("/logicalOperator/{logicalOperator}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getLogicalOperator(@PathParam("logicalOperator") String logicalOperator) {
       return queryRepository(SparqlStmt.getQdmLogicalOperator(logicalOperator));
   }
   
   /**
    * Returns all QDM Relationship Operators
    * @return JSON Response
    */
   @GET
   @Path("/relationshipOperators")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getRelationshipOperators( ) {
       return queryRepository(SparqlStmt.QDM_RELATIONSHIP_OPERATORS);
   }
   
   /**
    * Returns a specific QDM Relationship Operator
    * @param relationshipOperator the name of the Relationship Operator
    * @return JSON Response
    */
   @GET
   @Path("/relationshipOperator/{relationshipOperator}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getRelationshipOperator(@PathParam("relationshipOperator") String relationshipOperator) {
       return queryRepository(SparqlStmt.getQdmRelationshipOperator(relationshipOperator));
   }
   
   /**
    * Returns all QDM Comparison Operators
    * @return JSON Response
    */
   @GET
   @Path("/comparisonOperators")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getComparisonOperators( ) {
       return queryRepository(SparqlStmt.QDM_COMPARISON_OPERATORS);
   }
   
   /**
    * Returns a specific QDM Comparison Operator
    * @param comparisonOperator the name of the Comparison Operator 
    * @return JSON Response
    */
   @GET
   @Path("/comparisonOperator/{comparisonOperator}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getComparisonOperator(@PathParam("comparisonOperator") String comparisonOperator) {
       return queryRepository(SparqlStmt.getQdmComparisonOperator(comparisonOperator));
   }
   
   /**
    * Returns all QDM Temporal Operators
    * @return JSON Response
    */
   @GET
   @Path("/temporalOperators")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getTemporalOperators( ) {
       return queryRepository(SparqlStmt.QDM_TEMPORAL_OPERATORS);
   }
   
   /**
    * Returns a specific QDM Temporal Operator
    * @param temporalOperator the name of the 
    * @return JSON Response
    */
   @GET
   @Path("/temporalOperator/{temporalOperator}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getTemporalOperator(@PathParam("temporalOperator") String temporalOperator) {
       return queryRepository(SparqlStmt.getQdmTemporalOperator(temporalOperator));
   }
   
   /**
    * Returns all QDM Subset Operators
    * @return JSON Response
    */
   @GET
   @Path("/subsetOperators")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getSubsetOperators( ) {
       return queryRepository(SparqlStmt.QDM_SUBSET_OPERATORS);
   }
   
   /**
    * Returns a specific QDM Subset Operator
    * @param subsetOperator the name of the Subset Operator
    * @return JSON Response
    */
   @GET
   @Path("/subsetOperator/{subsetOperator}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getSubsetOperator(@PathParam("subsetOperator") String subsetOperator)  {
       return queryRepository(SparqlStmt.getQdmSubsetOperator(subsetOperator));
   }
   
   /**
    * Returns all QDM Functions
    * @return JSON Response
    */
   @GET
   @Path("/functions")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getFunctions( ) {
       return queryRepository(SparqlStmt.QDM_FUNCTIONS);
   }
   
   /**
    * Returns a specific QDM Functions
    * @param function the name of the Function
    * @return JSON Response
    */
   @GET
   @Path("/function/{function}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getFunction(@PathParam("function") String function) {
       return queryRepository(SparqlStmt.getQdmFunction(function));
   }


}