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
            +" PREFIX fhir: <http://rdf.hl7.org/fhir/schema#>";
            
    protected static String PREFIX_QDM = " PREFIX qdm-5-4: <http://rdf.healthit.gov/qdm/element#> ";

    protected static String PREFIX_FHIR = " PREFIX fhir-3-0-1: <http://rdf.hl7.org/fhir/fhir-3-0-1#> ";

    protected static String PREFIX_CQL = " PREFIX cql-1-4: <http://cql.hl7.org/element#>  ";

    protected static String VERSION_FHIR = "?id mms:version fhir-3-0-1:fhir-3-0-1 .";

    protected static String VERSION_CQL = "?id mms:version cql-1-4:cql-1-4 .";

    protected static String SELECT = " SELECT * WHERE { ";
    
    protected static String QDM_TYPE = " ?id mms:version qdm-5-4:qdm-5-4 . ";
    
    protected static String FHIR_TYPE = " ?id rdf:type fhir:Resource . ";

    protected static String CQL_TYPE = " ?id rdf:type fhir:Resource . ";
    
    protected static String ALL_START = PREFIX + SELECT;
    
    protected static String QDM_START = PREFIX + PREFIX_QDM + SELECT +QDM_TYPE;
    
    protected static String FHIR_START = PREFIX + PREFIX_FHIR + SELECT + FHIR_TYPE + VERSION_FHIR;

    protected static String CQL_START = PREFIX + PREFIX_CQL + SELECT + VERSION_CQL;

    protected static String CONTEXT_QDM = " ?id mms:context qdm-5-4:";
    
    protected static String CONTEXT_FHIR = " ?id mms:context fhir-3-0-1:";

    protected static String CONTEXT_CQL = " ?id mms:context cql-1-4:";
    
    protected static String FILTER_NAME = " FILTER (STR(?dataElementName)='";
    
    protected static String FILTER_CONTEXT = " FILTER (REGEX(STR(?context), '";
    
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
    
    public static String QDM_CATEGORIES = QDM_START + CATEGORY + END;
    
    public static String FHIR_CATEGORIES = FHIR_START + CATEGORY + END;

    public static String CQL_CATEGORIES = CQL_START + CATEGORY + END;

    public static String DATATYPES = ALL_START + DATATYPE + END;
    
    public static String QDM_DATATYPES = QDM_START + DATATYPE + END;
    
    public static String FHIR_DATATYPES = FHIR_START + DATATYPE + END;

    public static String CQL_DATATYPES = CQL_START + DATATYPE + END;

    public static String ATTRIBUTES = ALL_START + ATTRIBUTE + END;
    
    public static String QDM_ATTRIBUTES = QDM_START + ATTRIBUTE + END;
    
    public static String FHIR_ATTRIBUTES = FHIR_START + ATTRIBUTE + END;

    public static String CQL_ATTRIBUTES = CQL_START + ATTRIBUTE + END;

    public static String LOGICAL_OPERATORS = ALL_START + LOGICAL + END;
    
    public static String QDM_LOGICAL_OPERATORS = QDM_START + LOGICAL + END;
    
    public static String RELATIONSHIP_OPERATORS = ALL_START + RELATIONSHIP + END;
    
    public static String QDM_RELATIONSHIP_OPERATORS = QDM_START + RELATIONSHIP + END;
    
    public static String COMPARISON_OPERATORS = ALL_START + COMPARISON + END;
    
    public static String QDM_COMPARISON_OPERATORS = QDM_START + COMPARISON + END;
    
    public static String TEMPORAL_OPERATORS = ALL_START + TEMPORAL + END;
    
    public static String QDM_TEMPORAL_OPERATORS = QDM_START + TEMPORAL + END;
    
    public static String SUBSET_OPERATORS = ALL_START + SUBSET+ END;
    
    public static String QDM_SUBSET_OPERATORS = QDM_START + SUBSET+ END;
    
    public static String FUNCTIONS = ALL_START + FUNCTION + END;
    
    public static String QDM_FUNCTIONS = QDM_START + FUNCTION + END;

    // get a specific category based on its name
    public static String getQdmCategoryStatement(String categoryName)  {
        return QDM_START + CATEGORY + OPTIONAL + FILTER_NAME + categoryName + PAREN + POSTFIX;
    }  
    
    public static String getFhirCategoryStatement(String categoryName)  {
        return FHIR_START + CATEGORY + VERSION_FHIR + OPTIONAL + FILTER_NAME + categoryName + PAREN + POSTFIX;
    }

    public static String getCqlCategoryStatement(String categoryName)  {
        return CQL_START + CATEGORY + VERSION_CQL + OPTIONAL + FILTER_NAME + categoryName + PAREN + POSTFIX;
    }

    // get a specific datatype based on its name    
    public static String getQdmDatatypeStatement(String datatypeName)  {
        return QDM_START + DATATYPE + OPTIONAL + FILTER_NAME + datatypeName + PAREN + POSTFIX;
    }   
    
    public static String getFhirDatatypeStatement(String datatypeName)  {
        return FHIR_START + DATATYPE + VERSION_FHIR + OPTIONAL + FILTER_NAME + datatypeName + PAREN + POSTFIX;
    }

    public static String getCqlDatatypeStatement(String datatypeName)  {
        return CQL_START + DATATYPE + VERSION_CQL + OPTIONAL + FILTER_NAME + datatypeName + PAREN + POSTFIX;
    }

    // get all datatypes for a specific category    
    public static String getQdmDatatypesForCategoryStatement(String categoryName)  {
        return QDM_START + DATATYPE + CONTEXT_QDM +categoryName + PER + OPTIONAL + POSTFIX;
    }
    
    public static String getFhirDatatypesForCategoryStatement(String categoryName)  {
        return FHIR_START + DATATYPE + VERSION_FHIR + CONTEXT_FHIR +categoryName + PER + OPTIONAL + POSTFIX;
    }

    public static String getCqlDatatypesForCategoryStatement(String categoryName)  {
        return CQL_START + DATATYPE + CONTEXT_CQL +categoryName + PER + OPTIONAL + POSTFIX;
    }
    
    // get a specific datatype for a specific category 
    public static String getQdmDatatypeForCategoryStatement(String categoryName, String datatypeName)  {
        return QDM_START + DATATYPE +  CONTEXT_QDM +categoryName + PER + OPTIONAL + FILTER_NAME + datatypeName + PAREN + POSTFIX;
    }
    
    public static String getFhirDatatypeForCategoryStatement(String categoryName, String datatypeName)  {
        return FHIR_START + DATATYPE + VERSION_FHIR + CONTEXT_FHIR +categoryName + PER + OPTIONAL + FILTER_NAME + datatypeName + PAREN + POSTFIX;
    }

    public static String getCqlDatatypeForCategoryStatement(String categoryName, String datatypeName)  {
        return CQL_START + DATATYPE + CONTEXT_CQL +categoryName + PER + OPTIONAL + FILTER_NAME + datatypeName + PAREN + POSTFIX;
    }
    
    // get all attributes for a specific datatype    
    public static String getQdmAttributesForDatatypeStatement(String datatypeName)  {
        return QDM_START + ATTRIBUTE + OPTIONAL + FILTER_CONTEXT + datatypeName + PAREN +")" + POSTFIX;
    }
    
    // get all instances for a specific datatype    
    public static String getQdmInstancesForDatatypeStatement(String datatypeName)  {
        return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>  " +
        "PREFIX qdm: <http://rdf.healthit.gov/qdm/schema#>  " +
        "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>  " +
        "PREFIX mms: <http://rdf.cdisc.org/mms#>  " +
        "SELECT * WHERE {  " +
        "?s rdf:type qdm:" +datatypeName +" . " +
        "?s rdfs:label ?label .  " +
        "OPTIONAL { ?s mms:version ?version . }  " +
        "OPTIONAL { ?s mms:dataElementLabel ?dataElementLabel . }  " +
        "OPTIONAL { ?s mms:dataElementName ?dataElementName . }  " +
        "OPTIONAL { ?s mms:dataElementValueDomain ?dataElementValueDomain . } " +
        "}  " ;
    }
    
    public static String getFhirAttributesForDatatypeStatement(String datatypeName)  {
        return FHIR_START + ATTRIBUTE + VERSION_FHIR + OPTIONAL + FILTER_CONTEXT + datatypeName + PAREN +")" + POSTFIX;
    }

    public static String getCqlAttributesForDatatypeStatement(String datatypeName)  {
        return CQL_START + ATTRIBUTE + VERSION_CQL + OPTIONAL + FILTER_CONTEXT + datatypeName + PAREN +")" + POSTFIX;
    }

    // get all attribute with a specific name
    public static String getQdmAttributesStatement(String attributeName)  {
        return QDM_START + ATTRIBUTE + OPTIONAL + FILTER_NAME + attributeName + PAREN + POSTFIX;
    }
    
    public static String getFhirAttributesStatement(String attributeName)  {
        return FHIR_START + ATTRIBUTE + VERSION_FHIR + OPTIONAL + FILTER_NAME + attributeName + PAREN + POSTFIX;
    }

    public static String getCqlAttributesStatement(String attributeName)  {
        return CQL_START + ATTRIBUTE + VERSION_CQL + OPTIONAL + FILTER_NAME + attributeName + PAREN + POSTFIX;
    }
    
    // get a specific attribute for a specific datatype
    public static String getQdmAttributeForDatatypeStatement(String datatypeName, String attributeName)  {
        String fullName = datatypeName +"." +attributeName;
        String stmt = QDM_START + ATTRIBUTE + OPTIONAL + 
                " FILTER (REGEX(STR(?id), \"" +fullName +"\", \"i\"))" + POSTFIX;
        return stmt;
    }
    
    public static String getFhirAttributeForDatatypeStatement(String datatypeName, String attributeName)  {
        String fullName = datatypeName +"." +attributeName;
        String stmt = FHIR_START + ATTRIBUTE + VERSION_FHIR + OPTIONAL + 
                " FILTER (REGEX(STR(?id), \"" +fullName +"\", \"i\"))" + POSTFIX;
        //System.out.println(stmt);
        return stmt;
    }

    public static String getCqlAttributeForDatatypeStatement(String datatypeName, String attributeName)  {
        String fullName = datatypeName +"." +attributeName;
        String stmt = CQL_START + ATTRIBUTE + VERSION_CQL + OPTIONAL +
                " FILTER (REGEX(STR(?id), \"" +fullName +"\", \"i\"))" + POSTFIX;
        //System.out.println(stmt);
        return stmt;
    }

    
    public static String getQdmLogicalOperator(String logicalOperator)  {
        return QDM_START + LOGICAL + OPTIONAL + FILTER_NAME + logicalOperator + PAREN + POSTFIX;
    }

    public static String getQdmRelationshipOperator(String relationshipOperator)  {
        return QDM_START + RELATIONSHIP + OPTIONAL + FILTER_NAME  + relationshipOperator + PAREN + POSTFIX;
    }

    public static String getQdmComparisonOperator(String comparisonOperator)  {
        return QDM_START + COMPARISON + OPTIONAL + FILTER_NAME + comparisonOperator + PAREN + POSTFIX;
    }

    public static String getQdmTemporalOperator(String temporalOperator)  {
        return QDM_START + TEMPORAL + OPTIONAL + FILTER_NAME + temporalOperator + PAREN + POSTFIX;
    }

    public static String getQdmSubsetOperator(String subsetOperator)  {
        return QDM_START + SUBSET + OPTIONAL + FILTER_NAME + subsetOperator + PAREN + POSTFIX;
    }

    public static String getQdmFunction(String function)  {
        return QDM_START + FUNCTION + OPTIONAL + FILTER_NAME + function + PAREN + POSTFIX;
    }
}



