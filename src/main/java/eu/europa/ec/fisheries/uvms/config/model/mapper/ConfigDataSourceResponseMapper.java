/*
﻿﻿Developed with the contribution of the European Commission - Directorate General for Maritime Affairs and Fisheries
© European Union, 2015-2016.
 
This file is part of the Integrated Data Fisheries Management (IFDM) Suite. The IFDM Suite is free software: you can
redistribute it and/or modify it under the terms of the GNU General Public License as published by the
Free Software Foundation, either version 3 of the License, or any later version. The IFDM Suite is distributed in
the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. You should have received a copy
of the GNU General Public License along with the IFDM Suite. If not, see <http://www.gnu.org/licenses/>.
 */
package eu.europa.ec.fisheries.uvms.config.model.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.europa.ec.fisheries.schema.config.source.v1.GetSettingsCatalogResponse;
import eu.europa.ec.fisheries.schema.config.source.v1.SettingsListResponse;
import eu.europa.ec.fisheries.schema.config.source.v1.SingleSettingResponse;
import eu.europa.ec.fisheries.schema.config.types.v1.ConfigFault;
import eu.europa.ec.fisheries.schema.config.types.v1.PullSettingsStatus;
import eu.europa.ec.fisheries.schema.config.types.v1.SettingType;
import eu.europa.ec.fisheries.schema.config.types.v1.SettingsCatalogEntry;
import eu.europa.ec.fisheries.uvms.config.model.exception.ConfigMessageValidationException;
import eu.europa.ec.fisheries.uvms.config.model.exception.ModelMapperException;
import eu.europa.ec.fisheries.uvms.config.model.exception.ModelMarshallException;

public class ConfigDataSourceResponseMapper {

    final static Logger LOG = LoggerFactory.getLogger(ConfigDataSourceResponseMapper.class);

    /**
     * Validates a response
     *
     * @param response a response text message
     * @param correlationId message correlation ID
     * @throws ConfigMessageValidationException if the message is null, missing or incorrect correlation ID or is a fault message  
     * @throws JMSException if the correlation ID cannot be accessed 
     */
    private static void validateResponse(TextMessage response, String correlationId) throws ConfigMessageValidationException, JMSException {

        if (response == null) {
            LOG.error("[ Error when validating response in ResponseMapper: Response is Null ]");
            throw new ConfigMessageValidationException("[ Error when validating response in ResponseMapper: Response is Null ]");
        }

        if (response.getJMSCorrelationID() == null) {
            LOG.error("[ No corelationId in response.] Expected was: {} ", correlationId);
            throw new ConfigMessageValidationException("[ No correlationId in response (Null) ] . Expected was: " + correlationId);
        }

        if (!correlationId.equalsIgnoreCase(response.getJMSCorrelationID())) {
            LOG.error("[ Wrong corelationId in response. Expected was {0} But actual was: {1} ]", correlationId, response.getJMSCorrelationID());
            throw new ConfigMessageValidationException("[ Wrong correlationId in response. ] Expected was: " + correlationId + " but actual was: " + response.getJMSCorrelationID());
        }

        try {
            ConfigFault fault = JAXBMarshaller.unmarshallTextMessage(response, ConfigFault.class);
            throw new ConfigMessageValidationException(fault.getMessage());
        } catch (ModelMarshallException e) {
            // Do nothing because the response message is not an error message.
        }
    }

    public static String toSingleSettingResponse(SettingType setting) throws ModelMarshallException {
        SingleSettingResponse response = new SingleSettingResponse();
        response.setSetting(setting);
        return JAXBMarshaller.marshallJaxBObjectToString(response);
    }

    public static String toListSettingsResponse(List<SettingType> settings) throws ModelMarshallException {
        SettingsListResponse response = new SettingsListResponse();
        if (settings == null) {
            response.setModuleStatus(PullSettingsStatus.MISSING);
        }
        else {
            response.setModuleStatus(PullSettingsStatus.OK);
            response.getSettings().addAll(settings);
        }

        return JAXBMarshaller.marshallJaxBObjectToString(response);
    }

    public static String toGetSettingCatalogResponse(List<SettingsCatalogEntry> entries) throws ModelMarshallException {
        GetSettingsCatalogResponse response = new GetSettingsCatalogResponse();
        response.getSetting().addAll(entries);
        return JAXBMarshaller.marshallJaxBObjectToString(response);
    }

    public static SettingType getSettingFromCreateSettingResponse(TextMessage message, String correlationId) throws ModelMapperException {
        try {
            validateResponse(message, correlationId);
            SingleSettingResponse response = JAXBMarshaller.unmarshallTextMessage(message, SingleSettingResponse.class);
            return response.getSetting();
        }
        catch(ConfigMessageValidationException | ModelMarshallException | JMSException e) {
            LOG.error("[ Error when mapping response to single setting object. ] {}", e.getMessage());
            throw new ModelMapperException("Error when mapping response to single setting object:" + e.getMessage());
        }
    }

    public static SettingType getSettingFromGetSettingResponse(TextMessage message, String correlationId) throws ModelMapperException {
        try {
            validateResponse(message, correlationId);
            SingleSettingResponse response = JAXBMarshaller.unmarshallTextMessage(message, SingleSettingResponse.class);
            return response.getSetting();
        }
        catch(ConfigMessageValidationException | ModelMarshallException | JMSException e) {
            LOG.error("[ Error when mapping response to single setting object. ] {}", e.getMessage());
            throw new ModelMapperException("Error when mapping response to single setting object:" + e.getMessage());
        }
    }

    public static SettingType getSettingFromUpdateSettingResponse(TextMessage message, String correlationId) throws ModelMapperException {
        try {
            validateResponse(message, correlationId);
            SingleSettingResponse response = JAXBMarshaller.unmarshallTextMessage(message, SingleSettingResponse.class);
            return response.getSetting();
        }
        catch(ConfigMessageValidationException | ModelMarshallException | JMSException e) {
            LOG.error("[ Error when mapping response to single setting object. ] {}", e.getMessage());
            throw new ModelMapperException("Error when mapping response to single setting object:" + e.getMessage());
        }
    }

    public static SettingType getSettingFromDeleteSettingResponse(TextMessage message, String correlationId) throws ModelMapperException {
        try {
            validateResponse(message, correlationId);
            SingleSettingResponse response = JAXBMarshaller.unmarshallTextMessage(message, SingleSettingResponse.class);
            return response.getSetting();
        }
        catch(ConfigMessageValidationException | ModelMarshallException | JMSException e) {
            LOG.error("[ Error when mapping response to single setting object. ] {}", e.getMessage());
            throw new ModelMapperException("Error when mapping response to single setting object:" + e.getMessage());
        }
    }

    public static List<SettingType> getSettingsFromListSettingsResponse(TextMessage message, String correlationId) throws ModelMapperException {
        try {
            validateResponse(message, correlationId);
            SettingsListResponse response = JAXBMarshaller.unmarshallTextMessage(message, SettingsListResponse.class);
            if (response.getModuleStatus() == PullSettingsStatus.MISSING) {
                return null;
            }

            return response.getSettings();
        }
        catch(ConfigMessageValidationException | ModelMarshallException | JMSException e) {
            LOG.error("[ Error when mapping response to settings list. ] {}", e.getMessage());
            LOG.error("[ Error when mapping response to settings list. ] {}", e);
            throw new ModelMapperException("Error when mapping response to settings list:" + e.getMessage());
        }
    }

    public static Map<String, List<SettingType>> getCatalogFromSettingCatalogResponse(TextMessage message, String correlationId) throws ModelMapperException {
        try {
            validateResponse(message, correlationId);
            GetSettingsCatalogResponse response = JAXBMarshaller.unmarshallTextMessage(message, GetSettingsCatalogResponse.class);
            Map<String, List<SettingType>> settingsByModule = new HashMap<>();
            for (SettingsCatalogEntry entry : response.getSetting()) {
                settingsByModule.put(entry.getModuleName(), entry.getSettings());
            }

            return settingsByModule;
        }
        catch(ConfigMessageValidationException | ModelMarshallException | JMSException e) {
            LOG.error("[ Error when mapping response to settings catalog. ] {}", e.getMessage());
            throw new ModelMapperException("Error when mapping response to settings catalog:" + e.getMessage());
        }
    }

}