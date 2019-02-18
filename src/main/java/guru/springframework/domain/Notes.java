/*
 *  Company: RS
 *  Project: spring5-recipe-app
 *  Created: 9 lut 2019  18:51:09
 *  Author:  RS
 */
package guru.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *<p>Notatka</p><br>9 lut 2019
 * @author RS
 *
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// notes nie jest wlascicielem relacji, nie moze usuwac recipe, ale moze zostac usuniete z recipe. Przy usunieciu notes, recipe zostaje
	@OneToOne
	private Recipe recipe;
	// dlugi tekst w bazie, wiecej niz 255 znakow
	@Lob
	private String recipeNotes;
	
	
}
