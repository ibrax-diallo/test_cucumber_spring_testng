package com.ibrax.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibrax.controllers.AbonneController;
import com.ibrax.entities.Abonne;
import com.ibrax.services.AbonneService;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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
@ContextConfiguration(classes = {AbonneController.class})
@WebMvcTest(controllers = {AbonneController.class})
public class MockTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private AbonneService service;

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeTest
    public void before() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void create() throws Exception {
        Abonne abonne = new Abonne();
        abonne.setPrenom("ibrahima");
        abonne.setNom("DIALLO");
        abonne.setAdresse("Gennivilliers");
        this.mvc.perform(post("/api/v1/abonne/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(abonne))
        ).andExpect(status().isOk());

    }

    @Test
    public void getAbonne() throws Exception {
        this.mvc.perform(get("/api/v1/abonne/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void putAbonne() throws Exception {
        Abonne abonne = new Abonne();
        abonne.setPrenom("ibrahima");
        abonne.setNom("Scorpio");
        abonne.setAdresse("Saint denis");
        this.mvc.perform(put("/api/v1/abonne/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(abonne))
        ).andExpect(status().isOk());
    }
}
