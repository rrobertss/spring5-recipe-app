package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <p></p><br>
 * Company: RS
 * Project: spring5-recipe-app
 * Author:  RS
 * Created: 2019-11-26  22:47
 */
public class CategoryToCategoryCommandTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "description";
    CategoryToCategoryCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(converter.convert(null));
    }


    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull("Empty object not nul", converter.convert(new Category()));
    }

    @Test
    public void convert() throws Exception{
        // given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        // when
        CategoryCommand categoryCommand = converter.convert(category);

        // then
        assertEquals("Id not equals", ID_VALUE, categoryCommand.getId());
        assertEquals("Description not equals", DESCRIPTION, categoryCommand.getDescription());
    }
}