package Validacao;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SenhasIguaisValidator.class)
public @interface SenhasIguais {

	String message() default "A senha e repetição devem ser igauis";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
