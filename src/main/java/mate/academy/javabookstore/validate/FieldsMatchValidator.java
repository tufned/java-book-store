package mate.academy.javabookstore.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;
import org.springframework.beans.BeanWrapperImpl;

public class FieldsMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String firstField;
    private String secondField;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        firstField = constraintAnnotation.first();
        secondField = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        try {
            BeanWrapperImpl beanWrapper = new BeanWrapperImpl(value);
            Object firstObj = beanWrapper.getPropertyValue(firstField);
            Object secondObj = beanWrapper.getPropertyValue(secondField);
            return Objects.equals(firstObj, secondObj);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Can't validate fields: " + firstField + " and " + secondField, e);
        }
    }
}
