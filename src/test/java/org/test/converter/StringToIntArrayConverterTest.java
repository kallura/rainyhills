package org.test.converter;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import javax.faces.convert.ConverterException;

/**
 * @author Kseniia Orlenko
 * @version 4/29/18
 */
public class StringToIntArrayConverterTest {

    private StringToIntArrayConverter converter = new StringToIntArrayConverter();

    @Test
    public void getAsObject() {

        int[] result = converter.getAsObject(null, null, "1,2,3");

        assertNotNull("The result is not null", result);
        assertEquals("The result size is 3", 3, result.length);
        assertEquals("The result contains 1", 1, result[0]);
        assertEquals("The result contains 2", 2, result[1]);
        assertEquals("The result contains 3", 3, result[2]);
    }

    @Test(expected = ConverterException.class)
    public void getAsObjectNegative() {

        converter.getAsObject(null, null, "-1,-2,-3");
    }

    @Test(expected = ConverterException.class)
    public void getAsObjectCharacters() {

        converter.getAsObject(null, null, "a, b, c");
    }

    @Test
    public void getAsString() {
        int[] ints = new int[] {1, 2, 3};

        String result = converter.getAsString(null, null, ints);

        assertNotNull("The result is not null", result);
        assertEquals("The result should match '1,2,3'", "1,2,3", result);
    }
}