package com.myspringboot.reflect;

/**
 * @author: 陈晖
 * @Date: Create in 下午 3:56 2019/10/8 0008
 * @Descroption:
 */


public class SonDemo extends FatherDemo {
    private String mSonName;
    protected int mSonAge;
    public String mSonBirthday;

    public void printSonMsg(){
        System.out.println("Son Msg - name : "
                + mSonName + "; age : " + mSonAge);
    }

    private void setSonName(String name){
        mSonName = name;
    }

    private void setSonAge(int age){
        mSonAge = age;
    }

    private int getSonAge(){
        return mSonAge;
    }

    private String getSonName(){
        return mSonName;
    }
}
