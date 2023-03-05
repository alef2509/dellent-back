package br.com.dellent.labseq.api;

import br.com.dellent.labseq.sequencia.api.SequenciaController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LabSeqControllerTest {

    @Autowired
    private SequenciaController labSeqController;

    @Test
    public void testLabSeqEndpoint() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(labSeqController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8487/api/dellent/sequencia/consultar/5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.numero").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.resultado").value("011110"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json("{\"numero\":5,\"resultado\":\"011110\"}"));
    }

}

