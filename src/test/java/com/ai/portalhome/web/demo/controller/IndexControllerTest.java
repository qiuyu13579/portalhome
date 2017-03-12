package com.ai.portalhome.web.demo.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

public class IndexControllerTest {
    
    private IndexController indexController;

    @Before
    public void before() throws Exception {
        
        indexController=new IndexController();
        
    }


    @Test
    public void testIndex() {
        
        Model model=Mockito.mock(Model.class);
        
        String result=indexController.index(model);
        
        assertTrue("index".equals(result));
        
        Mockito.verify(model,Mockito.times(1)).addAttribute("hello","index-hello");
        
    }

}
