/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 10 lut 2019  11:23:52
 *  Author:  RS
 */
package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 *<p>Skladnik</p><br>10 lut 2019
 * @author RS
 *
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal amount;
	// bez kaskadowosci, nie chcemy aby przy kasowaniu skladnika, kasowac przepis
	@ManyToOne
	private Recipe recipe;
	// eager - za kazdym razem dane beda pobierane od razu z DB
	@OneToOne(fetch = FetchType.EAGER) 
	private UnitOfMeasure uom;
	
	
	public Ingredient() {

	}

	public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
		this.description = description;
		this.amount = amount;
		this.uom = uom;
	}
	
	public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
		this.description = description;
		this.amount = amount;
		this.uom = uom;
		this.recipe = recipe;
	}
	
}
