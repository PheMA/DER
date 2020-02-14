package org.mayo.edu.phema.helper;

public class FhirStmt extends SparqlStmt {

    private static String PREFIX_FHIR = " PREFIX fhir-3-0-1: <http://rdf.hl7.org/fhir/fhir-3-0-1#> ";

    private static String VERSION_FHIR = "?id mms:version fhir-3-0-1:fhir-3-0-1 .";

    private static String FHIR_TYPE = " ?id rdf:type fhir:Resource . ";

    private static String FHIR_START = PREFIX + PREFIX_FHIR + SELECT + FHIR_TYPE + VERSION_FHIR;

    private static String CONTEXT_FHIR = " ?id mms:context fhir-3-0-1:";

    public static String FHIR_CATEGORIES = FHIR_START + CATEGORY + END;

    public static String FHIR_DATATYPES = FHIR_START + DATATYPE + END;

    public static String FHIR_ATTRIBUTES = FHIR_START + ATTRIBUTE + END;

    // get a specific category based on its name
    public static String getFhirCategoryStatement(String categoryName)  {
        return FHIR_START + CATEGORY + VERSION_FHIR + OPTIONAL + FILTER_NAME + categoryName + PAREN + POSTFIX;
    }

    // get a specific datatype based on its name
    public static String getFhirDatatypeStatement(String datatypeName)  {
        return FHIR_START + DATATYPE + VERSION_FHIR + OPTIONAL + FILTER_NAME + datatypeName + PAREN + POSTFIX;
    }

    // get all datatypes for a specific category
    public static String getFhirDatatypesForCategoryStatement(String categoryName)  {
        return FHIR_START + DATATYPE + VERSION_FHIR + CONTEXT_FHIR +categoryName + PER + OPTIONAL + POSTFIX;
    }

    // get a specific datatype for a specific category
    public static String getFhirDatatypeForCategoryStatement(String categoryName, String datatypeName)  {
        return FHIR_START + DATATYPE + VERSION_FHIR + CONTEXT_FHIR +categoryName + PER + OPTIONAL + FILTER_NAME + datatypeName + PAREN + POSTFIX;
    }

    // get all attributes for a specific datatype
    public static String getFhirAttributesForDatatypeStatement(String datatypeName)  {
        return FHIR_START + ATTRIBUTE + VERSION_FHIR + OPTIONAL + FILTER_CONTEXT + datatypeName + PAREN +")" + POSTFIX;
    }

    // get all instances for a specific datatype


    // get all attribute with a specific name
    public static String getFhirAttributesStatement(String attributeName)  {
        return FHIR_START + ATTRIBUTE + VERSION_FHIR + OPTIONAL + FILTER_NAME + attributeName + PAREN + POSTFIX;
    }

    // get a specific attribute for a specific datatype
    public static String getFhirAttributeForDatatypeStatement(String datatypeName, String attributeName)  {
        String fullName = datatypeName +"." +attributeName;
        String stmt = FHIR_START + ATTRIBUTE + VERSION_FHIR + OPTIONAL +
                " FILTER (REGEX(STR(?id), \"" +fullName +"\", \"i\"))" + POSTFIX;
        //System.out.println(stmt);
        return stmt;
    }

}