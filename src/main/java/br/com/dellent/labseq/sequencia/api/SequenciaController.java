package br.com.dellent.labseq.sequencia.api;

import br.com.dellent.labseq.sequencia.service.SequenciaService;
import br.com.dellent.labseq.sequencia.api.dto.SequenciaResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(maxAge = 3600)
@AllArgsConstructor
@RequestMapping(path = SequenciaController.PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
@Api(value = "Sequência do número")
public class SequenciaController {
    public static final String PATH = "api/dellent/sequencia";

    @Autowired
    private SequenciaService sequenciaService;


    @ApiOperation(value = "Consultar Sequencia do número")
    @GetMapping("/consultar/{numero}")
    public ResponseEntity<SequenciaResponseDTO> consultar(@PathVariable Long numero){
        HttpHeaders responseHeaders = new HttpHeaders();
        SequenciaResponseDTO sequenciaResponseDTO = sequenciaService.handle(numero);
        return new ResponseEntity<SequenciaResponseDTO>(sequenciaResponseDTO, responseHeaders, HttpStatus.OK);
    };




}
