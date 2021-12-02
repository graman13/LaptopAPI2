package com.myproject.laptop.service;

import com.myproject.laptop.entity.Laptop;
import com.myproject.laptop.repository.JDBCRepository;
import com.myproject.laptop.repository.LaptopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@WebMvcTest(LaptopServiceImpl.class)
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class LaptopServiceImplTest {

    @InjectMocks
    private LaptopServiceImpl laptopService;

    @Mock
    private LaptopRepository repo;

    @Mock
    private JDBCRepository jdbc;
//
//    @Before
//    private void setUp(){
//        mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
//    }

    @Test
    void TestgetAllLaptops() {
        List<Laptop> laptopList= List.of(new Laptop("Dell","Insporon",900.0,"8GB"));
        when(jdbc.getLaps()).thenReturn(laptopList);
        Assertions.assertEquals(laptopList,jdbc.getLaps());

    }
}