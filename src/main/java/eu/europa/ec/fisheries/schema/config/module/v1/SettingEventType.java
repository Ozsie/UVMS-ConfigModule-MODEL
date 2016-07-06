
package eu.europa.ec.fisheries.schema.config.module.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SettingEventType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SettingEventType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SET"/>
 *     &lt;enumeration value="RESET"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SettingEventType")
@XmlEnum
public enum SettingEventType {

    SET,
    RESET;

    public String value() {
        return name();
    }

    public static SettingEventType fromValue(String v) {
        return valueOf(v);
    }

}
