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
package eu.europa.ec.fisheries.uvms.config.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import eu.europa.ec.fisheries.schema.config.source.v1.ConfigDataSourceMethod;
import eu.europa.ec.fisheries.schema.config.source.v1.DeleteSettingRequest;
import eu.europa.ec.fisheries.schema.config.source.v1.GetSettingRequest;
import eu.europa.ec.fisheries.schema.config.source.v1.GetSettingsCatalogRequest;
import eu.europa.ec.fisheries.schema.config.source.v1.ListSettingsRequest;
import eu.europa.ec.fisheries.schema.config.source.v1.UpdateSettingRequest;
import eu.europa.ec.fisheries.schema.config.types.v1.SettingType;
import eu.europa.ec.fisheries.schema.config.types.v1.SettingsCatalogEntry;
import eu.europa.ec.fisheries.uvms.config.model.exception.ModelMapperException;
import eu.europa.ec.fisheries.uvms.config.model.mapper.ConfigDataSourceRequestMapper;
import eu.europa.ec.fisheries.uvms.config.model.mapper.ConfigDataSourceResponseMapper;

public class ConfigDatasourceResponseMapperTest {

    public ConfigDatasourceResponseMapperTest() {
    }

    private SettingType TEST_SETTING;
    private SettingType TEST_SETTING_2;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        TEST_SETTING = new SettingType();
        TEST_SETTING.setKey("testSettingKey");
        TEST_SETTING.setValue("testSettingValue");
        TEST_SETTING.setGlobal(false); 

        TEST_SETTING_2 = new SettingType();
        TEST_SETTING_2.setKey("testSettingKey2");
        TEST_SETTING_2.setValue("testSettingValue2");
        TEST_SETTING_2.setGlobal(false); 
}

    @After
    public void tearDown() {
    }

    @Test
    public void test_requiresCorrelationId() throws Exception {
        TextMessage message = Mockito.mock(TextMessage.class);
        Mockito.when(message.getJMSCorrelationID()).thenReturn(null);

        try {
            ConfigDataSourceResponseMapper.getSettingFromCreateSettingResponse(message, null);
        }
        catch (ModelMapperException e) {
            return;
        }

        fail();
    }

    @Test
    public void testCreateSettingResponse() throws Exception {
        TextMessage message = Mockito.mock(TextMessage.class);
        Mockito.when(message.getText()).thenReturn(ConfigDataSourceResponseMapper.toSingleSettingResponse(TEST_SETTING));
        Mockito.when(message.getJMSCorrelationID()).thenReturn("testCorrelationId");
        SettingType setting = ConfigDataSourceResponseMapper.getSettingFromCreateSettingResponse(message, "testCorrelationId");

        assertSettingEquals(TEST_SETTING, setting);
    }

    @Test
    public void testGetSettingResponse() throws Exception {
        TextMessage message = Mockito.mock(TextMessage.class);
        Mockito.when(message.getText()).thenReturn(ConfigDataSourceResponseMapper.toSingleSettingResponse(TEST_SETTING));
        Mockito.when(message.getJMSCorrelationID()).thenReturn("testCorrelationId");
        SettingType setting = ConfigDataSourceResponseMapper.getSettingFromGetSettingResponse(message, "testCorrelationId");

        assertSettingEquals(TEST_SETTING, setting);
    }

    @Test
    public void testUpdateSettingResponse() throws Exception {
        TextMessage message = Mockito.mock(TextMessage.class);
        Mockito.when(message.getText()).thenReturn(ConfigDataSourceResponseMapper.toSingleSettingResponse(TEST_SETTING));
        Mockito.when(message.getJMSCorrelationID()).thenReturn("testCorrelationId");
        SettingType setting = ConfigDataSourceResponseMapper.getSettingFromUpdateSettingResponse(message, "testCorrelationId");

        assertSettingEquals(TEST_SETTING, setting);
    }
    
    @Test
    public void testListSettingsResponse() throws Exception {
        TextMessage message = Mockito.mock(TextMessage.class);
        Mockito.when(message.getText()).thenReturn(ConfigDataSourceResponseMapper.toListSettingsResponse(Arrays.asList(TEST_SETTING)));
        Mockito.when(message.getJMSCorrelationID()).thenReturn("testCorrelationId");
        List<SettingType> settings = ConfigDataSourceResponseMapper.getSettingsFromListSettingsResponse(message, "testCorrelationId");
        assertEquals(1, settings.size());
        assertSettingEquals(TEST_SETTING, settings.get(0));
    }

    @Test
    public void test_toGetSettingRequest() throws Exception {
        String xmlString = ConfigDataSourceRequestMapper.toGetSettingRequest(3L);

        GetSettingRequest request = unmarshall(xmlString, GetSettingRequest.class);
        assertEquals(request.getMethod(), ConfigDataSourceMethod.GET);
        assertEquals(3L, request.getSettingId().longValue());
    }

    @Test
    public void test_toUpdateSettingRequest() throws Exception {
        String xmlString = ConfigDataSourceRequestMapper.toUpdateSettingRequest(3L, TEST_SETTING, "TestUser");

        UpdateSettingRequest request = unmarshall(xmlString, UpdateSettingRequest.class);
        assertEquals(request.getMethod(), ConfigDataSourceMethod.UPDATE);
        assertSettingEquals(TEST_SETTING, request.getSetting());
        assertEquals(3L, request.getId().longValue());
    }

    @Test
    public void test_toDeleteSettingRequest() throws Exception {
        String xmlString = ConfigDataSourceRequestMapper.toDeleteSettingRequest(3L);

        DeleteSettingRequest request = unmarshall(xmlString, DeleteSettingRequest.class);
        assertEquals(request.getMethod(), ConfigDataSourceMethod.DELETE);
        assertEquals(3L, request.getSettingId().longValue());
    }

    @Test
    public void test_toListSettingsRequest() throws Exception {
        String xmlString = ConfigDataSourceRequestMapper.toListSettingsRequest("testModule");

        ListSettingsRequest request = unmarshall(xmlString, ListSettingsRequest.class);
        assertEquals(request.getMethod(), ConfigDataSourceMethod.LIST);
        assertEquals("testModule", request.getModuleName());
    }

    @Test
    public void test_toGetSettingsCatalogRequest() throws Exception {
        String xmlString = ConfigDataSourceRequestMapper.toGetSettingsCatalogRequest();

        GetSettingsCatalogRequest request = unmarshall(xmlString, GetSettingsCatalogRequest.class);
        assertEquals(request.getMethod(), ConfigDataSourceMethod.GET_CATALOG);
    }

    @Test
    public void testCatalogFromSettingCatalogResponse() throws Exception {
        SettingsCatalogEntry entry1 = new SettingsCatalogEntry();
        entry1.setModuleName("testModule1");
        entry1.getSettings().add(TEST_SETTING);

        SettingsCatalogEntry entry2 = new SettingsCatalogEntry();
        entry2.setModuleName("testModule2");
        entry2.getSettings().add(TEST_SETTING_2);

        TextMessage message = Mockito.mock(TextMessage.class);
        Mockito.when(message.getText()).thenReturn(ConfigDataSourceResponseMapper.toGetSettingCatalogResponse(Arrays.asList(entry1, entry2)));
        Mockito.when(message.getJMSCorrelationID()).thenReturn("testCorrelationId");
        Map<String, List<SettingType>> catalog = ConfigDataSourceResponseMapper.getCatalogFromSettingCatalogResponse(message, "testCorrelationId");

        assertEquals(2, catalog.size());
        assertFalse(catalog.get("testModule1").isEmpty());
        assertSettingEquals(TEST_SETTING, catalog.get("testModule1").get(0));
        assertFalse(catalog.get("testModule2").isEmpty());
        assertSettingEquals(TEST_SETTING_2, catalog.get("testModule2").get(0));
    }

    private static void assertSettingEquals(SettingType expected, SettingType actual) {
        assertEquals(expected.getKey(), actual.getKey());
        assertEquals(expected.getValue(), actual.getValue());
        assertEquals(expected.isGlobal(), actual.isGlobal());
    }

    @SuppressWarnings("unchecked")
    private <T> T unmarshall(String xmlString, Class<T> clazz) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StringReader sr = new StringReader(xmlString);
        return (T) unmarshaller.unmarshal(sr);
    }

}