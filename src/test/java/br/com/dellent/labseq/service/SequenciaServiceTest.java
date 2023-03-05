package br.com.dellent.labseq.service;

import br.com.dellent.labseq.sequencia.service.SequenciaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SequenciaServiceTest {

    @Autowired
    private SequenciaService labSeqService;

    @Test
    public void testLabSeq() {
        String result = labSeqService.labseq(5);
        Assert.assertEquals("011110", result);
    }

}
