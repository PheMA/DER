package org.mayo.edu.phema.helper;

public class CqlStmt extends SparqlStmt {

    protected static String PREFIX_CQL = " PREFIX cql-1-4: <http://cql.hl7.org/element#>  ";

    protected static String VERSION_CQL = "?id mms:version cql-1-4:cql-1-4 .";

    protected static String CQL_TYPE = " ?id rdf:type fhir:Resource . ";

    protected static String CQL_START = PREFIX + PREFIX_CQL + SELECT + VERSION_CQL;

    protected static String CONTEXT_CQL = " ?id mms:context cql-1-4:";

    public static String CQL_CATEGORIES = CQL_START + CATEGORY + END;

    public static String CQL_DATATYPES = CQL_START + DATATYPE + END;

    public static String CQL_ATTRIBUTES = CQL_START + ATTRIBUTE + END;


    // get a specific category based on its name
    public static String getCqlCategoryStatement(String categoryName)  {
        return CQL_START + CATEGORY + VERSION_CQL + OPTIONAL + FILTER_NAME + categoryName + PAREN + POSTFIX;
    }

    // get a specific datatype based on its name
    public static String getCqlDatatypeStatement(String datatypeName)  {
        return CQL_START + DATATYPE + VERSION_CQL + OPTIONAL + FILTER_NAME + datatypeName + PAREN + POSTFIX;
    }

    // get all datatypes for a specific category
    public static String getCqlDatatypesForCategoryStatement(String categoryName)  {
        return CQL_START + DATATYPE + CONTEXT_CQL +categoryName + PER + OPTIONAL + POSTFIX;
    }

    // get a specific datatype for a specific category
    public static String getCqlDatatypeForCategoryStatement(String categoryName, String datatypeName)  {
        return CQL_START + DATATYPE + CONTEXT_CQL +categoryName + PER + OPTIONAL + FILTER_NAME + datatypeName + PAREN + POSTFIX;
    }


    public static String getCqlAttributesForDatatypeStatement(String datatypeName)  {
        return CQL_START + ATTRIBUTE + VERSION_CQL + OPTIONAL + FILTER_CONTEXT + datatypeName + PAREN +")" + POSTFIX;
    }


    public static String getCqlAttributesStatement(String attributeName)  {
        return CQL_START + ATTRIBUTE + VERSION_CQL + OPTIONAL + FILTER_NAME + attributeName + PAREN + POSTFIX;
    }

    // get a specific attribute for a specific datatype
    public static String getCqlAttributeForDatatypeStatement(String datatypeName, String attributeName)  {
        String fullName = datatypeName +"." +attributeName;
        String stmt = CQL_START + ATTRIBUTE + VERSION_CQL + OPTIONAL +
                " FILTER (REGEX(STR(?id), \"" +fullName +"\", \"i\"))" + POSTFIX;
        //System.out.println(stmt);
        return stmt;
    }



}
