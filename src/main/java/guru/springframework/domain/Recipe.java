/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 9 lut 2019  18:14:30
 *  Author:  RS
 */
package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *<p>Przepis kulinarny</p><br>9 lut 2019
 * @author RS
 *
 */
@Data
@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	@Lob
	private String directions;
	// duzy obiekt w bazie
	@Lob
	private Byte[] image;
	// recipe jest wlascicielem relacji, jak bedzie skasowane recipe, to tez usunie sie notes, ale nie odwrotnie
	@OneToOne(cascade = CascadeType.ALL)
	private Notes notes;
	// encja Recipe jest wlascicielem relacji, moze usuwac ingredient; mappedBy - zmienna w klasie z relacją, u nas 'recipe'
	@OneToMany(cascade = CascadeType.ALL, mappedBy="recipe")
	private Set<Ingredient>ingrediens = new HashSet<Ingredient>();
	// domyslnie jest ORDINAL - dane zachwywane w DB jako Integer (1,2,3,...), nie mozna zmieniac kolejnosci lub ilosci w enum, bo dane w DB beda wskazywac na inna wartosc, 
	// przy STRING - jako String - zachowuje w DB cala wartosc enuma jako String
	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;
	// strona posiadajaca tworzy joinTable
	@ManyToMany
	@JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category>categories = new HashSet<Category>();

	
	public void setNotes(Notes notes) {
		this.notes = notes;
		notes.setRecipe(this);
	}
	
	public Recipe addIngredient(Ingredient ingredient) {
		ingredient.setRecipe(this);
		this.ingrediens.add(ingredient);
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
