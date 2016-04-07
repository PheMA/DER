package org.mayo.edu.phema.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class sets the configuration information.  
 * */

public final class Config  {

    /**
     * Configuration file name.
     */
    private String configFileName = "config.properties";
    /**
     * Configuration properties.
     */
    private Properties configProps;

    /**
     * URL to the data repository
     */
    private static String repositoryUrl;
    
    /**
     * URL to the REST services
     */
    private static String serviceUrl;

    /**
     * Constructor finds the working directory and loads the configuration properties.
     */
    public Config()  {
        String workingDir = System.getProperty("user.dir");
        int binLoc = workingDir.lastIndexOf("bin");
        if(binLoc > -1)  {
            workingDir = workingDir.substring(0, binLoc); 
        }
        else  {
            workingDir = workingDir + File.separator;
        }
        //TODO: get rid of the hard coded reference to the project name as user may rename war file
        String configFullPath = workingDir +"webapps" + File.separator 
                +"DER" +File.separator +"conf" +File.separator +configFileName;
        configProps = new java.util.Properties();
        try {
            System.out.println("looking for configuration in - " +configFileName);
            InputStream is = new FileInputStream(configFullPath);
            configProps.load(is);
        } catch (Exception eta) {
            eta.printStackTrace();
        }
    }

    /**
     * get the property value.
     * @param key name of the property
     * @return property value
     */
    public String getProperty(final String key)  {
       String value = this.configProps.getProperty(key);
       return value;
    }

    /**
     * sets the configuration properties.
     */
    public void setConfig()  {
        repositoryUrl = getProperty("REPOSITORY_URL");
        serviceUrl = getProperty("SERVICE_URL");

        runPropertyCheck();
    }

    /**
     * Get the repository URL
     * @return repository URL
     */
    public String getRepositoryUrl() {
        return repositoryUrl;
    }
    
    /**
     * Get the service URL
     * @return service URL
     */
    public String getServiceUrl() {
        return serviceUrl;
    }

    /**
     * Validate that all the properties were set correctly.
     * If there is no annotation file, the gene name and id must come from the configuration 
     * file or command line.
     */
    private void runPropertyCheck()  {
        if (repositoryUrl == null)  {
            System.out.println("ERROR - missing parameter REPOSITORY_URL");
        }
        if (serviceUrl == null)  {
            System.out.println("ERROR - missing parameter SERVICE_URL");
        }
    }

}
