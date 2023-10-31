package com.alvaro.springbootform.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ObligatorioValidador.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Obligatorio {

	String message() default "Este campo es obligatorio, no puede estar vacío";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
