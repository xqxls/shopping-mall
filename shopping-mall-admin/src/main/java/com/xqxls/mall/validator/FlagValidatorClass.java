package com.xqxls.mall.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 胡卓
 * @create 2023-04-26 16:54
 * @Description 状态约束校验器
 */
public class FlagValidatorClass implements ConstraintValidator<FlagValidator,Integer> {

    private String[] values;

    @Override
    public void initialize(FlagValidator flagValidator) {
        this.values = flagValidator.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;
        if(value==null){
            //当状态为空时使用默认值
            return true;
        }
        for (String s : values) {
            if (s.equals(String.valueOf(value))) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }
}
