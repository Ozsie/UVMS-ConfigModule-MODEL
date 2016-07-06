
package eu.europa.ec.fisheries.schema.config.source.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfigDataSourceBaseRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfigDataSourceBaseRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="method" type="{urn:source.config.schema.fisheries.ec.europa.eu:v1}ConfigDataSourceMethod"/>
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
@XmlType(name = "ConfigDataSourceBaseRequest", propOrder = {
    "method",
    "username"
})
@XmlSeeAlso({
    ListSettingsRequest.class,
    CreateSettingRequest.class,
    CreateAllSettingRequest.class,
    GetSettingsCatalogRequest.class,
    DeleteSettingRequest.class,
    GetSettingRequest.class,
    UpdateSettingRequest.class,
    GetGlobalSettingsRequest.class
})
public abstract class ConfigDataSourceBaseRequest
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected ConfigDataSourceMethod method;
    @XmlElement(required = true)
    protected String username;

    /**
     * Gets the value of the method property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigDataSourceMethod }
     *     
     */
    public ConfigDataSourceMethod getMethod() {
        return method;
    }

    /**
     * Sets the value of the method property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigDataSourceMethod }
     *     
     */
    public void setMethod(ConfigDataSourceMethod value) {
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
