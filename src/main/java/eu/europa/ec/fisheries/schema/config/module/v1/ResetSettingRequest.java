
package eu.europa.ec.fisheries.schema.config.module.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.fisheries.schema.config.types.v1.SettingType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{urn:module.config.schema.fisheries.ec.europa.eu:v1}ConfigModuleBaseRequest">
 *       &lt;sequence>
 *         &lt;element name="setting" type="{urn:types.config.schema.fisheries.ec.europa.eu:v1}SettingType"/>
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
    "setting"
})
@XmlRootElement(name = "ResetSettingRequest")
public class ResetSettingRequest
    extends ConfigModuleBaseRequest
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected SettingType setting;

    /**
     * Gets the value of the setting property.
     * 
     * @return
     *     possible object is
     *     {@link SettingType }
     *     
     */
    public SettingType getSetting() {
        return setting;
    }

    /**
     * Sets the value of the setting property.
     * 
     * @param value
     *     allowed object is
     *     {@link SettingType }
     *     
     */
    public void setSetting(SettingType value) {
        this.setting = value;
    }

}
