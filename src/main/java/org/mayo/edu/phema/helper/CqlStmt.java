package org.mayo.edu.phema.helper;

import org.apache.jena.base.Sys;

public class CqlStmt extends SparqlStmt {

    public static String VERSION_CQL = "?id mms:version cql-1-4:cql-1-4 .";

    public static String CQL_TYPE = " rdf:type mms:DataElement ;  ";

    public static String CQL_START = PREFIX + SELECT + VERSION_CQL;

    public static String CONTEXT_CQL = " ?id mms:context cql-1-4:";

    public static String SUBCLASS_CQL = " ?id rdfs:subClassOf cql-1-4:";

    public static String CQL_CATEGORIES = CQL_START + CATEGORY + END;

    public static String CQL_DATATYPES = CQL_START + DATATYPE + END;

    public static String CQL_ATTRIBUTES = CQL_START + ATTRIBUTE + END;

    public static String CQL_OPTIONAL = "  OPTIONAL { ?id mms:id ?id.}  \n"
                                + "  OPTIONAL { ?id rdfs:subClassOf ?subClassOf . }  \n"
                                + "  OPTIONAL { ?id mms:version ?version . } \n"
                                + "  OPTIONAL { ?id rdfs:label  ?label .}  \n"
                                + "  OPTIONAL { ?id skos:definition ?definition . } ";


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
    public static String getCqlAttributeForDatatypeStatement(String datatypeName, String attributeName)  {
        return CQL_START + ATTRIBUTE + VERSION_CQL + OPTIONAL + FILTER_NAME +attributeName + PAREN + POSTFIX;
    }

}
