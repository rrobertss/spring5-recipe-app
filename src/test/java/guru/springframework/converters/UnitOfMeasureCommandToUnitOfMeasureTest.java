package guru.springframework.converters;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <p></p><br>
 * Company: RS
 * Project: spring5-recipe-app
 * Author:  RS
 * Created: 2019-11-27  20:56
 */
public class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "description";
    private UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull("Object not null", converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull("Object is null", converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() {
        // given
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(ID_VALUE);
        unitOfMeasureCommand.setDescription(DESCRIPTION);

        // when
        UnitOfMeasure unitOfMeasure = converter.convert(unitOfMeasureCommand);

        // then
        assertNotNull("Object is null",unitOfMeasure);
        assertEquals("Wrong ID", ID_VALUE, unitOfMeasure.getId());
        assertEquals("Wrong description", DESCRIPTION, unitOfMeasure.getDescription());
    }
}