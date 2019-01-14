package com.myspringboot.aop_3.impl;

import com.myspringboot.aop_3.Skill;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Auther: 陈晖
 * @Date:2019/1/14 0014
 * @Descroption:
 */

@Service
public class SkillImpl implements Skill {
    @Override
    public void skill() {
        System.out.println("skill");
    }
}
