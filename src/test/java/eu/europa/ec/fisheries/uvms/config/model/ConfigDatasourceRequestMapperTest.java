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

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.europa.ec.fisheries.schema.config.source.v1.ConfigDataSourceMethod;
import eu.europa.ec.fisheries.schema.config.source.v1.CreateSettingRequest;
import eu.europa.ec.fisheries.schema.config.source.v1.DeleteSettingRequest;
import eu.europa.ec.fisheries.schema.config.source.v1.GetSettingRequest;
import eu.europa.ec.fisheries.schema.config.source.v1.GetSettingsCatalogRequest;
import eu.europa.ec.fisheries.schema.config.source.v1.ListSettingsRequest;
import eu.europa.ec.fisheries.schema.config.source.v1.UpdateSettingRequest;
import eu.europa.ec.fisheries.schema.config.types.v1.SettingType;
import eu.europa.ec.fisheries.uvms.config.model.mapper.ConfigDataSourceRequestMapper;

public class ConfigDatasourceRequestMapperTest {

    public ConfigDatasourceRequestMapperTest() {
    }

    private SettingType TEST_SETTING;

    private static final String TEST_USER="TestUser";
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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test_toCreateSettingRequest() throws Exception {
        String xmlString = ConfigDataSourceRequestMapper.toCreateSettingRequest(TEST_SETTING, "testModule", TEST_USER);

        CreateSettingRequest request = unmarshall(xmlString, CreateSettingRequest.class);
        assertEquals(request.getMethod(), ConfigDataSourceMethod.CREATE);
        assertEquals(request.getModuleName(), "testModule");
        assertSettingEquals(TEST_SETTING, request.getSetting());
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
        String xmlString = ConfigDataSourceRequestMapper.toUpdateSettingRequest(3L, TEST_SETTING, TEST_USER);

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