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
 * Created: 2019-11-27  19:16
 */
public class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "description";
    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull("Object is not null", converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull("Object is null", converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() {
        // given
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(ID_VALUE);
        unitOfMeasure.setDescription(DESCRIPTION);

        // when
        UnitOfMeasureCommand unitOfMeasureCommand = converter.convert(unitOfMeasure);

        // then
        assertEquals("Wrong ID", ID_VALUE, unitOfMeasureCommand.getId());
        assertEquals("Wrong description", DESCRIPTION, unitOfMeasureCommand.getDescription());
    }
}