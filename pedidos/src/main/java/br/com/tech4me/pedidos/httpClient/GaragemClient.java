package br.com.tech4me.pedidos.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tech4me.pedidos.model.Carro;

@FeignClient("garagem")
public interface GaragemClient {

  @RequestMapping(method= RequestMethod.GET, value="/carros/{id}")
  Carro obterCarro (@PathVariable String id);
  
}
