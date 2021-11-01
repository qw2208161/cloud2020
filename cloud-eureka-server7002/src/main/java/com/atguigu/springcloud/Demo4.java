package com.atguigu.springcloud;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhqin.zhou
 * @date 2021/8/27 14:12
 * @description Demo4
 */
public class Demo4 {
    public static void main(String [] args) {
        String unionid = "#33";
        A a = new A();
        a.setAge(11);

        A a1 = new A();
        a1.setAge(22);
        a1.setName("#33");

        List<A> list = new ArrayList<>();
        list.add(a);
        list.add(a1);

        List<String> names = new ArrayList<>();
        for(A item : list) {
            if(StringUtils.isEmpty(item.getName()) ) {
                continue;
            }
            names.add(item.name);
        }

        Boolean bindAccountFlag = false;
        if(names.size() == 0) {
            bindAccountFlag = true;
        }else if (names.size()== 1) {
            bindAccountFlag = unionid.equals(names.get(0));
        }else {
            bindAccountFlag = false;
        }
        if(list.size() <= 1 && unionid.equals(list.get(0))) {
            System.out.println("dddd");
        }

        System.out.println(names.toString());
    }

    static class A {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        private String name;
        private int age;
    }
}
