/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 10 lut 2019  15:02:20
 *  Author:  RS
 */
package guru.springframework.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *<p>Katerogia (grupa) przepisow</p><br>10 lut 2019
 * @author RS
 *
 */
@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	@ManyToMany(mappedBy = "categories")
	private Set<Recipe>recipes;

	
}
