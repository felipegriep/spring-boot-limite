package br.com.southsystem.workshop.limite.repository;

import br.com.southsystem.workshop.limite.model.Limite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimiteRepository extends MongoRepository<Limite, String> {
}
