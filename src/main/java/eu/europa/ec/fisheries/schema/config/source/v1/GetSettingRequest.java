
package eu.europa.ec.fisheries.schema.config.source.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
    "settingId"
})
@XmlRootElement(name = "GetSettingRequest")
public class GetSettingRequest
    extends ConfigDataSourceBaseRequest
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected Long settingId;

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

}
