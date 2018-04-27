package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Brand;
import com.ecommerce.sw2.Models.Domain.SystemModel;
import com.ecommerce.sw2.Models.Repository.BrandRepository;
import com.ecommerce.sw2.Models.Repository.SystemModelRepository;
import com.ecommerce.sw2.TestNGWithSpringApplication;
import com.ecommerce.sw2.forms.AddSystemModelForm;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.awt.image.SampleModel;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;


/**
 * Created by Mina_Yousry on 26/04/2018.
 */
@Test
////@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@ContextConfiguration(locations={"classpath:applicationContext.xml"})
//@SpringBootTest(classes = TestNGWithSpringApplication.class)
public class SystemModelServiceImpTest extends AbstractTestNGSpringContextTests {

    private static Logger logger = Logger.getLogger(SystemModelServiceImpTest.class);

    @BeforeMethod
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    SystemModelServiceImp systemModelService;

    @Mock
    SystemModelRepository systemModelRepository;

    @Mock
    BrandRepository brandRepository;


    @DataProvider(name = "testAddSystemModel")
    public static Object[][] value() {
        return new Object[][]{
                {"S9", "S9", "Samsung"},
                {null, "S9", "Samsung"},
                {null, "S9", "SS"},
                {null, "", "Samsung"},
                {null, "S9", ""}
        };
    }

    @Test
    public void testAddSystemModel() throws Exception {
        String brandname = "Samsung";
        String modelname = "S9";

        AddSystemModelForm addSystemModelForm = new AddSystemModelForm(modelname,brandname);

        Brand brand = (new Brand());
        SystemModel systemModel = (new SystemModel(modelname,brand));

        when(brandRepository.getBrandByName(brandname)).thenReturn(brand);
        when(systemModelRepository.save(any())).thenReturn(systemModel);


        assertEquals(systemModel,systemModelService.AddSystemModel(addSystemModelForm));
    }

    @Test
    public void testAddSystemModel1() throws Exception {
        String brandname = "";
        String modelname = "S9";

        AddSystemModelForm addSystemModelForm = new AddSystemModelForm(modelname,brandname);

        Brand brand = spy(new Brand());
        SystemModel systemModel = spy(new SystemModel(modelname,brand));

        when(brandRepository.getBrandByName(brandname)).thenReturn(null);
        when(systemModelRepository.save(any())).thenReturn(systemModel);


        assertEquals(null,systemModelService.AddSystemModel(addSystemModelForm));
    }

    @Test
    public void testAddSystemModel2() throws Exception {
        String brandname = "Samsung";
        String modelname = "S9";

        AddSystemModelForm addSystemModelForm = new AddSystemModelForm(modelname,brandname);

        Brand brand = spy(new Brand());
        SystemModel systemModel = spy(new SystemModel(modelname,brand));

        when(brandRepository.getBrandByName(brandname)).thenReturn(brand);
        when(systemModelRepository.save(any())).thenReturn(null);


        assertEquals(null,systemModelService.AddSystemModel(addSystemModelForm));
    }


    @Test
    public void testAddSystemModel3() throws Exception {
        String brandname = "blabla";
        String modelname = "S9";

        AddSystemModelForm addSystemModelForm = new AddSystemModelForm(modelname,brandname);

        Brand brand = spy(new Brand());
        SystemModel systemModel = spy(new SystemModel(modelname,brand));

        when(brandRepository.getBrandByName(brandname)).thenReturn(null);
        when(systemModelRepository.save(any())).thenReturn(systemModel);


        assertEquals(null,systemModelService.AddSystemModel(addSystemModelForm));
    }
}