/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 10 lut 2019  16:48:42
 *  Author:  RS
 */
package guru.springframework.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.UnitOfMeasure;

/**
 *<p></p><br>10 lut 2019
 * @author RS
 *
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{

	Optional<UnitOfMeasure>findByDescription(String description);
}
