package org.mayo.edu.phema.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This object contains all the metadata found in common for all data elements
 */
@XmlRootElement
public class DataElementModel {

    private static String id;
    private static String label;
    private static String context;
    private static String version;
    private static String definition;
    private static String dataElementDescription;
    private static String note;
    private static String dataElementLabel;
    private static String dataElementName;
    
    /**
     * The URI of the data element
     * @return 
     */
    public static String getId() {
        return id;
    }
    /**
     * The name of the data element
     * @return
     */
    public static String getLabel()  {
        return label;
    }
    /** 
     * The context uri for the data element
     * @return
     */
    public static String getContext() {
        return context;
    }
    /**
     * The release version from which the data element was defined
     * @return
     */
    public static String getVersion() {
        return version;
    }
    /**
     * The definition given for the data element
     * @return
     */
    public static String getDefinition() {
        return definition;
    }
    /**
     * The description given for the data element
     * @return
     */
    public static String getDataElementDescription() {
        return dataElementDescription;
    }
    /** 
     * The notes given for the data elements
     * @return
     */
    public static String getNote() {
        return note;
    }
    /**
     * The data element label
     * @return
     */
    public static String getDataElementLabel() {
        return dataElementLabel;
    }
    /**
     * The data element name.  It is derived from the data element label with all spaces removed.
     * @return
     */
    public static String getDataElementName() {
        return dataElementName;
    }
    
    
    public static void setId(String id) {
        DataElementModel.id = id;
    }
    public static void setLabel(String label) {
        DataElementModel.label = label;
    }
    public static void setContext(String context) {
        DataElementModel.context = context;
    }
    public static void setVersion(String version) {
        DataElementModel.version = version;
    }
    public static void setDefinition(String definition) {
        DataElementModel.definition = definition;
    }
    public static void setDataElementDescription(String dataElementDescription) {
        DataElementModel.dataElementDescription = dataElementDescription;
    }
    public static void setNote(String note) {
        DataElementModel.note = note;
    }
    public static void setDataElementLabel(String dataElementLabel) {
        DataElementModel.dataElementLabel = dataElementLabel;
    }
    public static void setDataElementName(String dataElementName) {
        DataElementModel.dataElementName = dataElementName;
    }
   
    
    
}
