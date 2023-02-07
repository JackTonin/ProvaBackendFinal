package br.com.tech4me.garagem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tech4me.garagem.model.Garagem;
import br.com.tech4me.garagem.repository.GaragemRepository;
import br.com.tech4me.garagem.shared.GaragemCompletoDto;
import br.com.tech4me.garagem.shared.GaragemDto;
import org.modelmapper.ModelMapper;

    @Service
public class GaragemServiceImpl implements GaragemService { 
  @Autowired
  private GaragemRepository repositorio;

  @Override
  public List<GaragemCompletoDto> obterTodas() {
    List<Garagem> garagens = repositorio.findAll(); 

    return garagens.stream()
                .map(c -> new ModelMapper().map(c, GaragemCompletoDto.class))
                .collect(Collectors.toList());
  }

  @Override
  public Optional<GaragemDto> obterPorId(String id) {
    Optional<Garagem> garagem  = repositorio.findById(id);

    if (garagem.isPresent()) {
      return Optional.of(new ModelMapper().map(garagem.get(), GaragemDto.class));
    }
    return Optional.empty();
  }

  @Override
  public void excluirPorId(String id) { 
    repositorio.deleteById(id);
  }

  @Override
  public GaragemCompletoDto cadastrar(GaragemCompletoDto dto) {
    Garagem garagem = new ModelMapper().map(dto, Garagem.class);
    repositorio.save(garagem);
    return new ModelMapper().map(garagem, GaragemCompletoDto.class);
  }

  @Override
  public Optional<GaragemCompletoDto> atualizarPorId(String id, GaragemCompletoDto dto) { 
    Optional<Garagem> retorno = repositorio.findById(id);

    if (retorno.isPresent()) {
      Garagem garagem = new ModelMapper().map(dto, Garagem.class);
      garagem.setId(id);
      repositorio.save(garagem);
      return Optional.of(new ModelMapper().map(garagem, GaragemCompletoDto.class));
    } else {
      return Optional.empty();
    }


  }}

