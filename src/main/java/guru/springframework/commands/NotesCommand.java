package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p></p><br>
 * Company: RS
 * Project: spring5-recipe-app
 * Author:  RS
 * Created: 2019-11-27  18:52
 */
@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {

    private Long id;
    private String recipeNotes;
}
