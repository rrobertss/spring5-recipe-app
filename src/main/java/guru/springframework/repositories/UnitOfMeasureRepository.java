/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 10 lut 2019  16:48:42
 *  Author:  RS
 */
package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 *<p></p><br>10 lut 2019
 * @author RS
 *
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{

	Optional<UnitOfMeasure>findByDescription(String description);
}
