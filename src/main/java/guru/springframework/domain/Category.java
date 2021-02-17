/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 10 lut 2019  15:02:20
 *  Author:  RS
 */
package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

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
