package org.sda.servlets.util;

import org.sda.servlets.domain.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidationUtil {

    private static Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public static boolean validate(User user) {
        Set<ConstraintViolation<User>> constraintViolations = validateInternal(user);
        return constraintViolations.isEmpty();
    }

    public static Set<ConstraintViolation<User>> validateInternal(User entity) {
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(entity);
        return constraintViolations;
    }

    public static <T> Set<ConstraintViolation<T>> validateInternal(T entity) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
        return constraintViolations;
    }
}
