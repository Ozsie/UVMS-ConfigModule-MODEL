/*
﻿Developed with the contribution of the European Commission - Directorate General for Maritime Affairs and Fisheries
© European Union, 2015-2016.

This file is part of the Integrated Fisheries Data Management (IFDM) Suite. The IFDM Suite is free software: you can
redistribute it and/or modify it under the terms of the GNU General Public License as published by the
Free Software Foundation, either version 3 of the License, or any later version. The IFDM Suite is distributed in
the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. You should have received a
copy of the GNU General Public License along with the IFDM Suite. If not, see <http://www.gnu.org/licenses/>.
 */
package eu.europa.ec.fisheries.uvms.config.model.mapper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.europa.ec.fisheries.schema.config.source.v1.ConfigDataSourceMethod;
import eu.europa.ec.fisheries.schema.config.source.v1.CreateAllSettingRequest;
import eu.europa.ec.fisheries.schema.config.source.v1.CreateSettingRequest;
import eu.europa.ec.fisheries.schema.config.source.v1.DeleteSettingRequest;
import eu.europa.ec.fisheries.schema.config.source.v1.GetGlobalSettingsRequest;
import eu.europa.ec.fisheries.schema.config.source.v1.GetSettingRequest;
import eu.europa.ec.fisheries.schema.config.source.v1.GetSettingsCatalogRequest;
import eu.europa.ec.fisheries.schema.config.source.v1.ListSettingsRequest;
import eu.europa.ec.fisheries.schema.config.source.v1.UpdateSettingRequest;
import eu.europa.ec.fisheries.schema.config.types.v1.SettingType;
import eu.europa.ec.fisheries.uvms.config.model.exception.ModelMapperException;
import eu.europa.ec.fisheries.uvms.config.model.exception.ModelMarshallException;

public class ConfigDataSourceRequestMapper {

    final static Logger LOG = LoggerFactory.getLogger(ConfigDataSourceRequestMapper.class);

    public static String toCreateSettingRequest(SettingType setting, String moduleName, String username) throws ModelMapperException {
        CreateSettingRequest request = new CreateSettingRequest();
        request.setMethod(ConfigDataSourceMethod.CREATE);
        request.setUsername(username);
        request.setSetting(setting);
        request.setModuleName(moduleName);
        return JAXBMarshaller.marshallJaxBObjectToString(request);
    }

    public static String toCreateAllSettingsRequest(List<SettingType> settings, String moduleName, String username) throws ModelMarshallException {
        CreateAllSettingRequest request = new CreateAllSettingRequest();
        request.setMethod(ConfigDataSourceMethod.CREATE_ALL);
        request.setUsername(username);
        request.getSettings().addAll(settings);
        request.setModuleName(moduleName);
        return JAXBMarshaller.marshallJaxBObjectToString(request);
    }

    public static String toGetSettingRequest(Long settingId) throws ModelMarshallException {
        GetSettingRequest request = new GetSettingRequest();
        request.setMethod(ConfigDataSourceMethod.GET);
        request.setSettingId(settingId);
        return JAXBMarshaller.marshallJaxBObjectToString(request);
    }

    public static String toUpdateSettingRequest(Long settingId, SettingType setting, String username) throws ModelMapperException {
        UpdateSettingRequest request = new UpdateSettingRequest();
        request.setMethod(ConfigDataSourceMethod.UPDATE);
        request.setUsername(username);
        request.setSetting(setting);
        request.setId(settingId);
        return JAXBMarshaller.marshallJaxBObjectToString(request);
    }

    public static String toDeleteSettingRequest(Long settingId) throws ModelMapperException {
        DeleteSettingRequest request = new DeleteSettingRequest();
        request.setMethod(ConfigDataSourceMethod.DELETE);
        request.setSettingId(settingId);
        return JAXBMarshaller.marshallJaxBObjectToString(request);
    }

    public static String toDeleteSettingRequest(String settingKey, String moduleName) throws ModelMapperException {
        DeleteSettingRequest request = new DeleteSettingRequest();
        request.setMethod(ConfigDataSourceMethod.DELETE);
        request.setSettingKey(settingKey);
        request.setSettingModule(moduleName);
        return JAXBMarshaller.marshallJaxBObjectToString(request);
    }

    public static String toListSettingsRequest(String moduleName) throws ModelMapperException {
        ListSettingsRequest request = new ListSettingsRequest();
        request.setMethod(ConfigDataSourceMethod.LIST);
        request.setModuleName(moduleName);
        return JAXBMarshaller.marshallJaxBObjectToString(request);
    }

    public static String toGetSettingsCatalogRequest() throws ModelMarshallException {
        GetSettingsCatalogRequest request = new GetSettingsCatalogRequest();
        request.setMethod(ConfigDataSourceMethod.GET_CATALOG);
        return JAXBMarshaller.marshallJaxBObjectToString(request);
    }

    public static String toGetGlobalSettingsRequest() throws ModelMarshallException {
        GetGlobalSettingsRequest request = new GetGlobalSettingsRequest();
        request.setMethod(ConfigDataSourceMethod.GET_GLOBALS);
        return JAXBMarshaller.marshallJaxBObjectToString(request);
    }

}