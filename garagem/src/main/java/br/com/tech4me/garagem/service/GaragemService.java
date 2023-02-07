package br.com.tech4me.garagem.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.garagem.shared.GaragemCompletoDto;
import br.com.tech4me.garagem.shared.GaragemDto;

public interface GaragemService {
    List<GaragemCompletoDto> obterTodas();
    Optional<GaragemDto> obterPorId(String id);
    void excluirPorId(String id);
    GaragemCompletoDto cadastrar(GaragemCompletoDto dto); 
    Optional<GaragemCompletoDto> atualizarPorId(String id, GaragemCompletoDto dto);
}