package com.springboot.jpa.SpringBootAssignmentFirst.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NameValidator.class)
public @interface NameValid {

    String message() default "Invlid name";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
