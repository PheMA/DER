package org.mayo.edu.phema.helper;


/**
 * This class contains all the SPARQL statements
 *
 */
public abstract class SparqlStmt {

    protected static String PREFIX = 
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
            +" PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
            +" PREFIX skos: <http://www.w3.org/2004/02/skos/core#> "
            +" PREFIX mms: <http://rdf.cdisc.org/mms#>  " 
            +" PREFIX qdm: <http://rdf.healthit.gov/qdm/schema#>  "
            +" PREFIX fhir: <http://rdf.hl7.org/fhir/schema#> "
            +" PREFIX cql-1-4: <http://cql.hl7.org/element#> "
            +" PREFIX qdm-5-4: <http://rdf.healthit.gov/qdm/element#> ";

    protected static String SELECT = " SELECT * WHERE { ";
    
    protected static String ALL_START = PREFIX + SELECT;
    
    protected static String FILTER_NAME = " FILTER (STR(?dataElementName)='";

    protected static String FILTER_LABEL = "FILTER (STR(?label)='";
    
    protected static String FILTER_CONTEXT = " FILTER (REGEX(STR(?context), '";

    protected static String FILTER_SUBCLASS = " FILTER (REGEX(STR(?subClassOf), '";
    
    protected static String LABEL = " ?id rdfs:label ?label . ";
    
    protected static String CATEGORY = " ?id rdf:type qdm:QDMCategory . " +LABEL;
    
    protected static String DATATYPE = " ?id rdf:type qdm:QDMDatatype . " +LABEL;
    
    protected static String ATTRIBUTE = " ?id rdf:type qdm:QDMAttribute . " +LABEL;
    
    protected static String LOGICAL = " ?id rdf:type qdm:QDMLogicalOperator . " +LABEL;
            
    protected static String RELATIONSHIP = " ?id rdf:type qdm:QDMRelationshipOperator . " +LABEL;
    
    protected static String COMPARISON = " ?id rdf:type qdm:QDMComparisonOperator . " +LABEL;
            
    protected static String TEMPORAL = " ?id rdf:type qdm:QDMTemporalOperator . " +LABEL;
                    
    protected static String SUBSET =  " ?id rdf:type qdm:QDMSubsetOperator . " +LABEL;
                            
    protected static String FUNCTION = " ?id rdf:type qdm:QDMFunction . " +LABEL;

    protected static String OPTIONAL = 
            " OPTIONAL { ?id mms:context ?context . } " +
            " OPTIONAL { ?id mms:version ?version . }" +
            " OPTIONAL { ?id skos:definition ?definition . }  " +
            " OPTIONAL { ?id mms:dataElementDescription ?dataElementDescription .}   " +
            " OPTIONAL { ?id skos:note ?note .}   " +
            " OPTIONAL { ?id mms:dataElementLabel ?dataElementLabel . }   " +
            " OPTIONAL { ?id mms:dataElementName ?dataElementName.}  " +
            " OPTIONAL { ?id fhir:control  ?cardinality .}  " +
            " OPTIONAL { ?id fhir:type  ?type .}   " +
            " OPTIONAL { ?id fhir:meta-attribute ?isMeta .} " ;
    
    protected static String PER = " . ";
    
    protected static String PAREN = "') ";
    
    protected static String POSTFIX = " } ";

    protected static String END = OPTIONAL + POSTFIX;
    
    public static String CATEGORIES = ALL_START + CATEGORY + END;

    public static String DATATYPES = ALL_START + DATATYPE + END;

    public static String ATTRIBUTES = ALL_START + ATTRIBUTE + END;

    public static String LOGICAL_OPERATORS = ALL_START + LOGICAL + END;

    public static String RELATIONSHIP_OPERATORS = ALL_START + RELATIONSHIP + END;

    public static String COMPARISON_OPERATORS = ALL_START + COMPARISON + END;

    public static String TEMPORAL_OPERATORS = ALL_START + TEMPORAL + END;

}



