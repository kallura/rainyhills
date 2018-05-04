package org.test.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * InputArrayValidator is implementation of validation input integer array
 * <p>
 * if array is null - throwing a ValidatorException
 * if array is empty - throwing a ValidatorException
 *
 * @author Kseniia Orlenko
 * @version 4/29/18
 */
@FacesValidator("inputArrayValidator")
public class InputArrayValidator implements Validator {

    private static final FacesMessage IS_NULL =
            new FacesMessage("The input should be not null or empty!");

    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (o == null || ((int[]) o).length == 0) {
            throw new ValidatorException(IS_NULL);
        }
    }
}
