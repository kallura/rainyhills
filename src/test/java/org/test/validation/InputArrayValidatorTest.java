package org.test.validation;

import static org.junit.Assert.fail;

import org.junit.Test;

import javax.faces.validator.ValidatorException;

/**
 * @author Kseniia Orlenko
 * @version 4/29/18
 */
public class InputArrayValidatorTest {

    private InputArrayValidator inputArrayValidator = new InputArrayValidator();

    @Test
    public void validatePositiveFlow() {
        try {
            inputArrayValidator.validate(null, null, new int[] {1, 2, 3, 4});
        } catch (RuntimeException e) {
            fail("Test should not fail. Please check an error: " + e.getMessage());
        }
    }

    @Test(expected = ValidatorException.class)
    public void validateNullArray() {
        inputArrayValidator.validate(null, null, null);
    }

    @Test(expected = ValidatorException.class)
    public void validateNullEmpty() {
        inputArrayValidator.validate(null, null, new int[] {});
    }
}