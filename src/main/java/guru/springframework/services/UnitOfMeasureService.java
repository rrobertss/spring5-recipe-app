package guru.springframework.services;

import guru.springframework.commands.UnitOfMeasureCommand;

import java.util.Set;

/**
 * <p>Jednostki miary w skladnikach</p><br>
 * Company: RS
 * Project: spring5-recipe-app
 * Author:  RS
 * Created: 2021-01-25  11:42
 */
public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> getListAllUoms();

}
