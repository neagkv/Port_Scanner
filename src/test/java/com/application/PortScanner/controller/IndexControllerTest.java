package com.application.PortScanner.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

//    IndexController indexController;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//
//        indexController = new IndexController();
//    }
//
//    @Test
//    public void testMockMVC() throws Exception {
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
//
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("index"));
//    }
//
//
//    @Test
//    public void getIndexPage() throws Exception {
//
//        //when
//        String viewName = indexController.getIndex();
//        //then
//        assertEquals("index", viewName);
//    }


}
