
package com.educacionit.java.rest.occupations.repository;


import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.educacionit.java.rest.occupations.entity.Occupation;


@Repository
public interface IOccupationRepository extends MongoRepository<Occupation, String> {

}