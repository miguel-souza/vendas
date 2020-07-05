package io.github.yasminsouza.validation.constraintValidation;

import io.github.yasminsouza.validation.NotEmptyList;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NotEmptyListValidator implements ConstraintValidator<NotEmptyList, List> {
    @Override
    public boolean isValid(List value, ConstraintValidatorContext context) {
        return !ObjectUtils.isEmpty(value);
    }
}
