package com.ibrax.mock;

import com.ibrax.controllers.ContratController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibrax.dto.request.ContratDTO;
import com.ibrax.services.ContratService;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@ContextConfiguration(classes = {ContratController.class})
@WebMvcTest(controllers = {ContratController.class})
public class MockContractTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ContratService service;

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeTest
    public void before() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void create() throws Exception {
        ContratDTO contratDTO = new ContratDTO();
        contratDTO.setAbonne(1L);
        contratDTO.setAdresse("test");
        this.mvc.perform(post("/api/v1/contrats/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(contratDTO))
        ).andExpect(status().isOk());
    }
}
