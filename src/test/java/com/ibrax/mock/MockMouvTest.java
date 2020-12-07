package com.ibrax.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibrax.controllers.MouvementController;
import com.ibrax.services.MouvementService;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@ContextConfiguration(classes = {MouvementController.class})
@WebMvcTest(controllers = {MouvementController.class})
public class MockMouvTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private MouvementService service;

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeTest
    public void before() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void historique() throws Exception {
        this.mvc.perform(get("/api/v1/mouvements/abonne/1"))
                .andExpect(status().isOk());
    }
}
