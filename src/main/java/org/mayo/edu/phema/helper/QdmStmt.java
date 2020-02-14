package org.mayo.edu.phema.helper;

public class QdmStmt  extends SparqlStmt {


    protected static String PREFIX_QDM = " PREFIX qdm-5-4: <http://rdf.healthit.gov/qdm/element#> ";

    protected static String QDM_TYPE = " ?id mms:version qdm-5-4:qdm-5-4 . ";

    protected static String QDM_START = PREFIX + PREFIX_QDM + SELECT +QDM_TYPE;

    protected static String CONTEXT_QDM = " ?id mms:context qdm-5-4:";

    public static String QDM_CATEGORIES = QDM_START + CATEGORY + END;

    public static String QDM_DATATYPES = QDM_START + DATATYPE + END;

    public static String QDM_ATTRIBUTES = QDM_START + ATTRIBUTE + END;

    public static String QDM_LOGICAL_OPERATORS = QDM_START + LOGICAL + END;

    public static String QDM_RELATIONSHIP_OPERATORS = QDM_START + RELATIONSHIP + END;

    public static String QDM_COMPARISON_OPERATORS = QDM_START + COMPARISON + END;

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
