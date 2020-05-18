package com.notorious.utils.impl;

import com.notorious.utils.Cal;
import org.springframework.stereotype.Component;

@Component
public class CalImpl implements Cal {
    public int add(int num1, int num2) {
        int result=num1+num2;

        return result;
    }

    public int sub(int num1, int num2) {
        int result=num1-num2;
        return result;
    }

    public int mul(int num1, int num2) {
        int result=num1*num2;
        return result;
    }

    public int div(int num1, int num2) {
        int result=num1/num2;
        return result;
    }
}
