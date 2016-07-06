
package eu.europa.ec.fisheries.schema.config.source.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{urn:source.config.schema.fisheries.ec.europa.eu:v1}ConfigDataSourceBaseRequest">
 *       &lt;sequence>
 *         &lt;element name="settingId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="settingKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="settingModule" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "settingId",
    "settingKey",
    "settingModule"
})
@XmlRootElement(name = "DeleteSettingRequest")
public class DeleteSettingRequest
    extends ConfigDataSourceBaseRequest
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected Long settingId;
    @XmlElement(required = true)
    protected String settingKey;
    @XmlElement(required = true)
    protected String settingModule;

    /**
     * Gets the value of the settingId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSettingId() {
        return settingId;
    }

    /**
     * Sets the value of the settingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSettingId(Long value) {
        this.settingId = value;
    }

    /**
     * Gets the value of the settingKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettingKey() {
        return settingKey;
    }

    /**
     * Sets the value of the settingKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettingKey(String value) {
        this.settingKey = value;
    }

    /**
     * Gets the value of the settingModule property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettingModule() {
        return settingModule;
    }

    /**
     * Sets the value of the settingModule property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettingModule(String value) {
        this.settingModule = value;
    }

}
