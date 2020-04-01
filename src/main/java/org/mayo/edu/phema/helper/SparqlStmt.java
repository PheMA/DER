package org.mayo.edu.phema.helper;


/**
 * This class contains all the SPARQL statements
 *
 */
public abstract class SparqlStmt {

    protected static final String PREFIX =
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
            +" PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
            +" PREFIX skos: <http://www.w3.org/2004/02/skos/core#> "
            +" PREFIX mms: <http://rdf.cdisc.org/mms#>  " 
            +" PREFIX qdm: <http://rdf.healthit.gov/qdm/schema#>  "
            +" PREFIX fhir: <http://rdf.hl7.org/fhir/schema#> "
            +" PREFIX cql-1-4: <http://cql.hl7.org/element#> "
            +" PREFIX qdm-5-4: <http://rdf.healthit.gov/qdm/element#> ";

    protected static final String SELECT = " SELECT * WHERE { ";

    protected static final String FILTER_NAME = " FILTER (STR(?dataElementName)='";

    protected static final String FILTER_LABEL = "FILTER (STR(?label)='";

    protected static final String FILTER_CONTEXT = " FILTER (REGEX(STR(?context), '";

    protected static final String LABEL = " ?id rdfs:label ?label . ";

    protected static final String CATEGORY = " ?id rdf:type qdm:QDMCategory . " +LABEL;

    protected static final String DATATYPE = " ?id rdf:type qdm:QDMDatatype . " +LABEL;

    protected static final String ATTRIBUTE = " ?id rdf:type qdm:QDMAttribute . " +LABEL;

    protected static final String OPTIONAL =
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

    protected static final String PER = " . ";

    protected static final String PAREN = "') ";

    protected static final String POSTFIX = " } ";

    protected static final String END = OPTIONAL + POSTFIX;

    protected SparqlStmt() {
        super();
    }
}



