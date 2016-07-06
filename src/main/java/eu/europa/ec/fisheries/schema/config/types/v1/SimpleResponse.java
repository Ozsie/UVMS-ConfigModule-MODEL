
package eu.europa.ec.fisheries.schema.config.types.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SimpleResponse.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SimpleResponse">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="NOK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SimpleResponse")
@XmlEnum
public enum SimpleResponse {

    OK,
    NOK;

    public String value() {
        return name();
    }

    public static SimpleResponse fromValue(String v) {
        return valueOf(v);
    }

}
