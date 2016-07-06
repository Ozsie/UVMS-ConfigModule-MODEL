
package eu.europa.ec.fisheries.schema.config.types.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PullSettingsStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PullSettingsStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="MISSING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PullSettingsStatus")
@XmlEnum
public enum PullSettingsStatus {

    OK,
    MISSING;

    public String value() {
        return name();
    }

    public static PullSettingsStatus fromValue(String v) {
        return valueOf(v);
    }

}
