
package eu.europa.ec.fisheries.schema.config.module.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfigModuleBaseRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfigModuleBaseRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="method" type="{urn:module.config.schema.fisheries.ec.europa.eu:v1}ConfigModuleMethod"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfigModuleBaseRequest", propOrder = {
    "method",
    "username"
})
@XmlSeeAlso({
    ListSettingsRequest.class,
    PullSettingsRequest.class,
    ResetSettingRequest.class,
    PingRequest.class,
    SetSettingRequest.class,
    PushSettingsRequest.class
})
public abstract class ConfigModuleBaseRequest
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected ConfigModuleMethod method;
    @XmlElement(required = true)
    protected String username;

    /**
     * Gets the value of the method property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigModuleMethod }
     *     
     */
    public ConfigModuleMethod getMethod() {
        return method;
    }

    /**
     * Sets the value of the method property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigModuleMethod }
     *     
     */
    public void setMethod(ConfigModuleMethod value) {
        this.method = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

}
