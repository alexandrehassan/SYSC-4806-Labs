package com.AddressBook;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher{
//    public void launch(){
//        String[] contextPaths=new String[]{"META-INF/app-context.xml"};
//        new ClassPathXmlApplicationContext(contextPaths);
//    }

    public  void launch(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppContext.class);
        context.refresh();
    }
}
