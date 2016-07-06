
package eu.europa.ec.fisheries.schema.config.module.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="moduleName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="settings" type="{urn:types.config.schema.fisheries.ec.europa.eu:v1}SettingType" maxOccurs="unbounded" minOccurs="0"/>
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
    "moduleName",
    "settings"
})
@XmlRootElement(name = "PushSettingsRequest")
public class PushSettingsRequest
    extends ConfigModuleBaseRequest
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String moduleName;
    protected List<SettingType> settings;

    /**
     * Gets the value of the moduleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * Sets the value of the moduleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleName(String value) {
        this.moduleName = value;
    }

    /**
     * Gets the value of the settings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the settings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSettings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SettingType }
     * 
     * 
     */
    public List<SettingType> getSettings() {
        if (settings == null) {
            settings = new ArrayList<SettingType>();
        }
        return this.settings;
    }

}
