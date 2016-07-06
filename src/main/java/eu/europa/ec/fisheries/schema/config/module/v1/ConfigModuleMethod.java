
package eu.europa.ec.fisheries.schema.config.module.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfigModuleMethod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConfigModuleMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PULL"/>
 *     &lt;enumeration value="PUSH"/>
 *     &lt;enumeration value="SET"/>
 *     &lt;enumeration value="RESET"/>
 *     &lt;enumeration value="PING"/>
 *     &lt;enumeration value="LIST"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConfigModuleMethod")
@XmlEnum
public enum ConfigModuleMethod {

    PULL,
    PUSH,
    SET,
    RESET,
    PING,
    LIST;

    public String value() {
        return name();
    }

    public static ConfigModuleMethod fromValue(String v) {
        return valueOf(v);
    }

}
