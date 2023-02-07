package br.com.tech4me.garagem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.garagem.model.Garagem;

public interface GaragemRepository extends MongoRepository<Garagem, String>
 {
    
}
