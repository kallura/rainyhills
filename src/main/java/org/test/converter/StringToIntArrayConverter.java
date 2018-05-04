package org.test.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * StringToIntArrayConverter is implementation of a converter from a string to an array of integers.
 * The string format is 1,2,3,...
 *
 * @author Kseniia Orlenko
 * @version 4/29/18
 */
@FacesConverter("stringToIntArrayConverter")
public class StringToIntArrayConverter implements Converter {

    private static final String PATTERN = "[0-9]+(,[0-9]+)*";
    private static final FacesMessage IS_INVALID =
            new FacesMessage("The input should match the pattern [0-9, /,]+");

    @Override
    public int[] getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (!s.matches(PATTERN)) {
            throw new ConverterException(IS_INVALID);
        }
        String[] numbersStr = s.split(",");
        int[] numbers = new int[numbersStr.length];
        for (int i = 0; i < numbersStr.length; i++) {
            numbers[i] = Integer.valueOf(numbersStr[i].trim());
        }
        return numbers;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        int[] numbers = (int[]) o;
        StringBuilder numbersStr = new StringBuilder();
        for (int number : numbers) {
            numbersStr.append(number).append(",");
        }
        return numbersStr.deleteCharAt(numbersStr.length() - 1).toString();
    }
}
