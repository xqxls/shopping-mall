package com.xqxls.mall.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author 胡卓
 * @create 2023-04-26 16:54
 * @Description 用于验证状态是否在指定范围内的注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {
    String[] value() default {};

    String message() default "flag is not found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
