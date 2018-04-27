package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Brand;
import com.ecommerce.sw2.Models.Repository.BrandRepository;
import com.ecommerce.sw2.forms.AddBrandForm;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

/**
 * Created by Mina_Yousry on 27/04/2018.
 */
@Test
public class BrandServiceTest extends AbstractTestNGSpringContextTests {

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @InjectMocks
    BrandServiceImp brandServiceImp;

    @Mock
    BrandRepository brandRepository;

    @Test
    public void testAddBrand() throws Exception {
        String brandname = "brandname";
        Brand brand = new Brand(brandname);
        AddBrandForm addBrandForm = new AddBrandForm(brandname);
        when(brandRepository.save(any())).thenReturn(brand);
        assertEquals(brand,brandServiceImp.AddBrand(addBrandForm));
    }

    @Test
    public void testAddBrand1() throws Exception {
        String brandname = "brandname";
        Brand brand = new Brand(brandname);
        AddBrandForm addBrandForm = new AddBrandForm(brandname);
        when(brandRepository.save(any())).thenReturn(null);
        assertEquals(null,brandServiceImp.AddBrand(addBrandForm));
    }

    @Test
    public void testAddBrand2() throws Exception {
        String brandname = "";
        Brand brand = new Brand(brandname);
        AddBrandForm addBrandForm = new AddBrandForm(brandname);
        when(brandRepository.save(any())).thenReturn(null);
        assertEquals(null,brandServiceImp.AddBrand(addBrandForm));
    }


}