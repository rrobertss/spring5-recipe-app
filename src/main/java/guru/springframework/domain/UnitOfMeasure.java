/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 10 lut 2019  11:31:08
 *  Author:  RS
 */
package guru.springframework.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *<p></p><br>10 lut 2019
 * @author RS
 *
 */
@Data
@Entity
public class UnitOfMeasure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	
}
