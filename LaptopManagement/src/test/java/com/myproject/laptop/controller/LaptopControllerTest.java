package com.myproject.laptop.controller;

import com.myproject.laptop.entity.Laptop;
import com.myproject.laptop.service.LaptopServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LaptopController.class)
class LaptopControllerTest {

    @Autowired
    private LaptopController controller;
    @Autowired
    private MockMvc mockMvc;
//    @Autowired
//    private WebApplicationContext context;

    @MockBean
    private LaptopServiceImpl laptopService;

    @Test
    void testGetAllLaptops() throws Exception {
        List<Laptop> laptopList= List.of(new Laptop("Dell","Insporon",900.0,"8GB"));
        when(laptopService.getAllLaptops()).thenReturn(laptopList);
        mockMvc.perform(get("/laptops")).andExpect(status().isOk());

    }
}