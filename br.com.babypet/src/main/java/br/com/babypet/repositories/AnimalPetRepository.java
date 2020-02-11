package br.com.babypet.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.babypet.domain.AnimalPet;
@Repository
public interface AnimalPetRepository extends MongoRepository<AnimalPet, String> {
	

}
