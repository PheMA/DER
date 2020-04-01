package org.mayo.edu.phema.helper;

public class CqlStmt extends SparqlStmt {

    private static final String VERSION_CQL = "?id mms:version cql-1-4:cql-1-4 .";

    private static final String CQL_START = PREFIX + SELECT + VERSION_CQL;

    private static final String SUBCLASS_CQL = " ?id rdfs:subClassOf cql-1-4:";

    private static final String CQL_OPTIONAL = "  OPTIONAL { ?id mms:id ?id.}  "
        + "  OPTIONAL { ?id rdfs:subClassOf ?subClassOf . } "
        + "  OPTIONAL { ?id mms:version ?version . } "
        + "  OPTIONAL { ?id rdfs:label  ?label .}  "
        + "  OPTIONAL { ?id skos:definition ?definition . } ";

    public static final String CQL_CATEGORIES = CQL_START + CATEGORY + END;

    public static final String CQL_DATATYPES = CQL_START + DATATYPE + END;

    public static final String CQL_ATTRIBUTES = CQL_START + ATTRIBUTE + END;

    // get a specific category based on its name
    public static String getCqlCategoryStatement(String categoryName)  {
        return CQL_START + CATEGORY + CQL_OPTIONAL + FILTER_LABEL + categoryName + PAREN + POSTFIX;
    }

    // get a specific datatype based on its name
    public static String getCqlDatatypeStatement(String datatypeName)  {
        return CQL_START + DATATYPE + CQL_OPTIONAL + FILTER_LABEL + datatypeName + PAREN + POSTFIX;
    }

    // get all datatypes for a specific category
    public static String getCqlDatatypesForCategoryStatement(String categoryName)  {
        return CQL_START + DATATYPE + SUBCLASS_CQL +categoryName + PER + CQL_OPTIONAL + POSTFIX;
    }

    // get a specific datatype for a specific category
    public static String getCqlDatatypeForCategoryStatement(String categoryName, String datatypeName)  {
        return CQL_START + DATATYPE + SUBCLASS_CQL +categoryName + PER + CQL_OPTIONAL + FILTER_LABEL + datatypeName + PAREN + POSTFIX;
    }

    public static String getCqlAttributesForDatatypeStatement(String datatypeName)  {
        return CQL_START + ATTRIBUTE + VERSION_CQL +SUBCLASS_CQL + datatypeName +PER + OPTIONAL + POSTFIX;
    }

    public static String getCqlAttributesStatement(String attributeName)  {
        return CQL_START + ATTRIBUTE + VERSION_CQL + OPTIONAL + FILTER_NAME + attributeName + PAREN + POSTFIX;
    }

    // get a specific attribute for a specific datatype
    public static String getCqlAttributeForDatatypeStatement(String attributeName)  {
        return CQL_START + ATTRIBUTE + VERSION_CQL + OPTIONAL + FILTER_NAME +attributeName + PAREN + POSTFIX;
    }

}
