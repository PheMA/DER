package org.mayo.edu.phema.rest;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mayo.edu.phema.helper.Config;
import org.mayo.edu.phema.helper.SparqlStmt;
import org.mayo.edu.phema.helper.Store;
import org.mayo.edu.phema.helper.Store.OutputFormat;


/**
 * This class contains the REST service calls pertaining to FHIR data elements.
 */
@Path("/fhir")
public class FHIR_REST {
   
    
   private Response queryRepository(String sparql, OutputFormat format)  {
       String response = "test";
       
       Config config;
       config = new Config();
       config.setConfig();

       //System.out.println(sparql);
       try {
           Store store = new Store(config.getRepositoryUrl());
           response = store.query(sparql,format, 100000);

       } catch (MalformedURLException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       if(response.equals("test"))  {
           return Response.status(Response.Status.NOT_FOUND).entity("Data was not retrieved").build();
       }
       return Response.status(200).entity(response).build();
   }
   
   /**
    * Returns all FHIR Categories
    * @return  JSON Response
    */
   @GET
   @Path("/categories")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getCategories() {
       return queryRepository(SparqlStmt.FHIR_CATEGORIES, Store.OutputFormat.JSON);
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
       System.out.println (SparqlStmt.getFhirCategoryStatement(category));
       return queryRepository(SparqlStmt.getFhirCategoryStatement(category), Store.OutputFormat.JSON);
   }
   
   /**
    * Returns all FHIR Datatypes
    * @return JSON Response
    */
   @GET
   @Path("/datatypes")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getDatatypes( ) {
       return queryRepository(SparqlStmt.FHIR_DATATYPES, Store.OutputFormat.JSON);
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
       return queryRepository(SparqlStmt.getFhirDatatypeStatement(datatype), Store.OutputFormat.JSON);
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
       return queryRepository(SparqlStmt.getFhirDatatypesForCategoryStatement(category), Store.OutputFormat.JSON);
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
       return queryRepository(SparqlStmt.getFhirDatatypeForCategoryStatement(category, datatype), Store.OutputFormat.JSON);
   }
   
   /**
    * Returns all FHIR Attributes
    * @return JSON Response
    */
   @GET
   @Path("/attributes")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getAttributes() {
       return queryRepository(SparqlStmt.FHIR_ATTRIBUTES, Store.OutputFormat.JSON);
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
       return queryRepository(SparqlStmt.getFhirAttributesForDatatypeStatement(datatype), Store.OutputFormat.JSON);
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
       return queryRepository(SparqlStmt.getFhirAttributeForDatatypeStatement(datatype, attribute), Store.OutputFormat.JSON);
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
       return queryRepository(SparqlStmt.getFhirAttributesStatement(attribute), Store.OutputFormat.JSON);
   }
   
//   /**
//    * Returns a specified FHIR 
//    * @param valueset
//    * @return JSON Response
//    */
//   @GET
//   @Path("/valueset/{valueset}")
//   @Produces(MediaType.APPLICATION_JSON)
//   public Response getValueSets(@PathParam("valueset") String valueset) {
//       String valueSet = ""
//               + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>  "
//               + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>  "
//               + "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>  "
//               + "PREFIX mms: <http://rdf.cdisc.org/mms#>     "
//               + "PREFIX fhir: <http://rdf.hl7.org/fhir/schema#>  "
//               + "PREFIX qdm: <http://rdf.healthit.gov/qdm/schema#>   "  
//               + "SELECT * WHERE {  "
//               + "?id rdf:type fhir:Resource .  "
//               + "?id rdf:type qdm:FHIRValueSet .  "
//               + "?id rdfs:label ?datatypeLabel .  "
//               + "OPTIONAL { ?id mms:context ?context . }  "
//               + "OPTIONAL { ?id mms:version ?version . }  "
//               + "OPTIONAL { ?id skos:definition ?definition . }   "
//               + "OPTIONAL {  ?id mms:member  ?member . }  "
//               + "FILTER (REGEX(STR(?id), \"" +valueset +"\", \"i\")) }" ;
//       
//       return queryRepository(valueSet, Store.OutputFormat.JSON);
//   } 



}