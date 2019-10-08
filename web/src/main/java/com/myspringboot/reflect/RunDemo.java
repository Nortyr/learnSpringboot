package com.myspringboot.reflect;

import java.lang.reflect.*;

/**
 * @author: 陈晖
 * @Date: Create in 下午 6:18 2019/10/8 0008
 * @Descroption:
 */


public class RunDemo {
        public static void main(String[] args) {
            Class sonClass=SonDemo.class;
            Class fatherClass=FatherDemo.class;
            System.out.println("子类名称:"+sonClass.getName());
            System.out.println("父类名称:"+fatherClass.getName());
            // public 成员变量包括父类中的public
            // Field[] fields=sonClass.getFields();
            // 子类中所有成员变量
            Field[] fields = sonClass.getDeclaredFields();
            for (Field field : fields) {
                //获取访问权限并输出
                int modifiers = field.getModifiers();
                System.out.print(Modifier.toString(modifiers) + " ");
                //输出变量的类型及变量名
                System.out.println(field.getType().getName()
                        + " " + field.getName());
            }
            // 子类和父类中所有的public方法
//            Method[] methods=sonClass.getMethods();
            // 2.2 获取所有本类的的方法（不问访问权限）
             Method[] methods = sonClass.getDeclaredMethods();
            for (Method method : methods) {
                //获取并输出方法的访问权限（Modifiers：修饰符）
                int modifiers = method.getModifiers();
                System.out.print(Modifier.toString(modifiers) + " ");
                //获取并输出方法的返回值类型
                Class returnType = method.getReturnType();
                System.out.print(returnType.getName() + " "
                        + method.getName() + "( ");
                //获取并输出方法的所有参数
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter:
                        parameters) {
                    System.out.print(parameter.getType().getName()
                            + " " + parameter.getName() + ",");
                }
                //获取并输出方法抛出的异常
                Class[] exceptionTypes = method.getExceptionTypes();
                if (exceptionTypes.length == 0){
                    System.out.println(" )");
                }
                else {
                    for (Class c : exceptionTypes) {
                        System.out.println(" ) throws "
                                + c.getName());
                    }
                }
            }

            Class testRunClass=TestRunClass.class;
            TestRunClass testRunClass1=new TestRunClass();
            try {
                Method method=testRunClass.getDeclaredMethod("privateMethod",String.class, int.class);
                if (method != null) {
                    //获取私有方法的访问权
                    //只是获取访问权，并不是修改实际权限
                    method.setAccessible(true);

                    //使用 invoke 反射调用私有方法
                    //privateMethod 是获取到的私有方法
                    //testClass 要操作的对象
                    //后面两个参数传实参
                    method.invoke(testRunClass1, "Java Reflect", 666);
                }

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            //2. 获取私有变量
            Field privateField = null;
            try {
                privateField = testRunClass.getDeclaredField("MSG");
                //3. 操作私有变量
                if (privateField != null) {
                    //获取私有变量的访问权
                    privateField.setAccessible(true);

                    //修改私有变量，并输出以测试
                    System.out.println("Before Modify：MSG = " + testRunClass1.getMsg());

                    //调用 set(object , value) 修改变量的值
                    //privateField 是获取到的私有变量
                    //testClass 要操作的对象
                    //"Modified" 为要修改成的值
                    privateField.set(testRunClass1, "Modified");
                    System.out.println("After Modify：MSG = " + testRunClass1.getMsg());
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


        }
}
