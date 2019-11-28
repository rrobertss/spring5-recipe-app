/*
 * Company: RS
 * Project: spring5-recipe-app
 */
package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p></p><br>
 * Author:  RS
 * Created: 2019-11-26  21:08
 */
@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {

    private Long id;
    private String description;
}
