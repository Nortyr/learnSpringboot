package com.myspringboot.aop_3.impl;

import com.myspringboot.aop_3.Skill;

/**
 * @Auther: 陈晖
 * @Date:2019/1/14 0014
 * @Descroption:
 */


public class SkillImpl implements Skill {
    @Override
    public void skill() {
        System.out.println("skill");
    }
}
