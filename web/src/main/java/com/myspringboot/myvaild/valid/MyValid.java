package com.myspringboot.myvaild.valid;

import com.myspringboot.myvaild.po.MyPo;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @Auther: 陈晖
 * @Date:2019/1/22 0022
 * @Descroption:
 */


public class MyValid implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(MyPo.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(target==null){
            errors.rejectValue("",null,"用户名不能为空");
            return;
        }
        MyPo myPo=(MyPo)target;
        if(StringUtils.isEmpty(myPo.getId())){
            errors.rejectValue("userName",null,"用户名不能为空");
        }

    }
}
