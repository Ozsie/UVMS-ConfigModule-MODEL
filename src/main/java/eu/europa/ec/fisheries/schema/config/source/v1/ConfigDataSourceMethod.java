
package eu.europa.ec.fisheries.schema.config.source.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfigDataSourceMethod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConfigDataSourceMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CREATE"/>
 *     &lt;enumeration value="CREATE_ALL"/>
 *     &lt;enumeration value="GET"/>
 *     &lt;enumeration value="UPDATE"/>
 *     &lt;enumeration value="DELETE"/>
 *     &lt;enumeration value="LIST"/>
 *     &lt;enumeration value="GET_CATALOG"/>
 *     &lt;enumeration value="GET_GLOBALS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConfigDataSourceMethod")
@XmlEnum
public enum ConfigDataSourceMethod {

    CREATE,
    CREATE_ALL,
    GET,
    UPDATE,
    DELETE,
    LIST,
    GET_CATALOG,
    GET_GLOBALS;

    public String value() {
        return name();
    }

    public static ConfigDataSourceMethod fromValue(String v) {
        return valueOf(v);
    }

}
