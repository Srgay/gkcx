package com.gkcx.demo;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class test {
    public MF[] a;

    public void a() {
        this.a= new MF[]{this.getSelfInitializer()};
    }

    public static void main(String[] args) {
        test test=new test();
        test.a();
        MF[] var3=test.a;
        int var4 = test.a.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            MF a = var3[var5];
            a.onStartup(var5);
        }
    }


    private MF getSelfInitializer() {
        return this::selfInitialize;
    }


    private void selfInitialize(Integer a) {
        System.out.println(a);

    }
}
