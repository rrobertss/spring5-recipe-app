/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 9 lut 2019  18:14:30
 *  Author:  RS
 */
package guru.springframework.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *<p>Przepis kulinarny</p><br>9 lut 2019
 * @author RS
 *
 */
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
	public Integer getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}
	public Integer getCookTime() {
		return cookTime;
	}
	public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}
	public Integer getServings() {
		return servings;
	}
	public void setServings(Integer servings) {
		this.servings = servings;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}
	public Byte[] getImage() {
		return image;
	}
	public void setImage(Byte[] image) {
		this.image = image;
	}
	public Notes getNotes() {
		return notes;
	}
	public void setNotes(Notes notes) {
		this.notes = notes;
		notes.setRecipe(this);
	}
	
	public Recipe addIngredient(Ingredient ingredient) {
		ingredient.setRecipe(this);
		this.ingrediens.add(ingredient);
		return this;
	}
	
	public Set<Ingredient> getIngrediens() {
		return ingrediens;
	}
	public void setIngrediens(Set<Ingredient> ingrediens) {
		this.ingrediens = ingrediens;
	}
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	
}
