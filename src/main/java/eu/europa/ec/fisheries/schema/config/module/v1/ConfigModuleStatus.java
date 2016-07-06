
package eu.europa.ec.fisheries.schema.config.module.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfigModuleStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConfigModuleStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DEPLOYED"/>
 *     &lt;enumeration value="SETTING_CHANGED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConfigModuleStatus")
@XmlEnum
public enum ConfigModuleStatus {

    DEPLOYED,
    SETTING_CHANGED;

    public String value() {
        return name();
    }

    public static ConfigModuleStatus fromValue(String v) {
        return valueOf(v);
    }

}
