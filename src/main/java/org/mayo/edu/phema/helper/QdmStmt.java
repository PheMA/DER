package org.mayo.edu.phema.helper;

public class QdmStmt  extends SparqlStmt {

    private static final String QDM_VERSION = " ?id mms:version qdm-5-4:qdm-5-4 . ";

    private static final String QDM_START = PREFIX + SELECT +QDM_VERSION;

    private static final String CONTEXT_QDM = " ?id mms:context qdm-5-4:";

    public static final String QDM_CATEGORIES = QDM_START + CATEGORY + END;

    public static final String QDM_DATATYPES = QDM_START + DATATYPE + END;

    public static final String QDM_ATTRIBUTES = QDM_START + ATTRIBUTE + END;

    // get a specific category based on its name
    public static String getQdmCategoryStatement(String categoryName)  {
        return QDM_START + CATEGORY + OPTIONAL + FILTER_NAME + categoryName + PAREN + POSTFIX;
    }

    // get a specific datatype based on its name
    public static String getQdmDatatypeStatement(String datatypeName)  {
        return QDM_START + DATATYPE + OPTIONAL + FILTER_NAME + datatypeName + PAREN + POSTFIX;
    }

    // get all datatypes for a specific category
    public static String getQdmDatatypesForCategoryStatement(String categoryName)  {
        return QDM_START + DATATYPE + CONTEXT_QDM +categoryName + PER + OPTIONAL + POSTFIX;
    }

    // get a specific datatype for a specific category
    public static String getQdmDatatypeForCategoryStatement(String categoryName, String datatypeName)  {
        return QDM_START + DATATYPE +  CONTEXT_QDM +categoryName + PER + OPTIONAL + FILTER_NAME + datatypeName + PAREN + POSTFIX;
    }

    // get all attributes for a specific datatype
    public static String getQdmAttributesForDatatypeStatement(String datatypeName)  {
        return QDM_START + ATTRIBUTE + OPTIONAL + FILTER_CONTEXT + datatypeName + PAREN +")" + POSTFIX;
    }

    // get all attribute with a specific name
    public static String getQdmAttributesStatement(String attributeName)  {
        return QDM_START + ATTRIBUTE + OPTIONAL + FILTER_NAME + attributeName + PAREN + POSTFIX;
    }

    // get a specific attribute for a specific datatype
    public static String getQdmAttributeForDatatypeStatement(String datatypeName, String attributeName)  {
        String fullName = datatypeName +"." +attributeName;
        return QDM_START + ATTRIBUTE + OPTIONAL +
                " FILTER (REGEX(STR(?id), \"" +fullName +"\", \"i\"))" + POSTFIX;
    }

}
