package br.com.tech4me.garagem.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.tech4me.garagem.service.GaragemService;
import br.com.tech4me.garagem.shared.GaragemCompletoDto;
import br.com.tech4me.garagem.shared.GaragemDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/carros")
public class GaragemController {
    @Autowired
    private GaragemService servico;

    @PostMapping public ResponseEntity<GaragemCompletoDto> cadastrarCarro(@RequestBody @Valid GaragemCompletoDto carro){
        return new ResponseEntity<>(servico.cadastrar(carro), HttpStatus.CREATED);
 
    }

    @GetMapping
    public ResponseEntity<List<GaragemCompletoDto>> obterCarros(){
        return new ResponseEntity<>(servico.obterTodas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
  public ResponseEntity<GaragemDto> obterCarroPorId(@PathVariable String id) {
    Optional<GaragemDto> retorno = servico.obterPorId(id);

    if (retorno.isPresent()) {
      return new ResponseEntity<>(retorno.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluirCarro(@PathVariable String id){
    servico.excluirPorId(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{id}")
  public ResponseEntity<GaragemCompletoDto> atualizarGaragem(@PathVariable String id, @RequestBody GaragemCompletoDto garagem){
    Optional<GaragemCompletoDto> retorno = servico.atualizarPorId(id, garagem); 

    if (retorno.isPresent()) {
      return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

  }

  @GetMapping("/porta")
  public String obterPorta(@Value("${local.server.port}") String porta){
    return "A instância que respondeu a requisição está rodando na porta" + porta;
  }


}

