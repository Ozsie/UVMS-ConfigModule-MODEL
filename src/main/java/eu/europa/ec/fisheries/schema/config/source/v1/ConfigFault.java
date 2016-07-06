
package eu.europa.ec.fisheries.schema.config.source.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.6
 * 2016-07-06T11:53:22.917+02:00
 * Generated source version: 2.7.6
 */

@WebFault(name = "configFault", targetNamespace = "urn:types.config.schema.fisheries.ec.europa.eu:v1")
public class ConfigFault extends Exception {
    
    private eu.europa.ec.fisheries.schema.config.types.v1.ConfigFault configFault;

    public ConfigFault() {
        super();
    }
    
    public ConfigFault(String message) {
        super(message);
    }
    
    public ConfigFault(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigFault(String message, eu.europa.ec.fisheries.schema.config.types.v1.ConfigFault configFault) {
        super(message);
        this.configFault = configFault;
    }

    public ConfigFault(String message, eu.europa.ec.fisheries.schema.config.types.v1.ConfigFault configFault, Throwable cause) {
        super(message, cause);
        this.configFault = configFault;
    }

    public eu.europa.ec.fisheries.schema.config.types.v1.ConfigFault getFaultInfo() {
        return this.configFault;
    }
}
