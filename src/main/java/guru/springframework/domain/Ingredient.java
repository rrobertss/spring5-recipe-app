/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 10 lut 2019  11:23:52
 *  Author:  RS
 */
package guru.springframework.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *<p>Skladnik</p><br>10 lut 2019
 * @author RS
 *
 */
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


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	public UnitOfMeasure getUom() {
		return uom;
	}
	public void setUom(UnitOfMeasure uom) {
		this.uom = uom;
	}
	
	
}
