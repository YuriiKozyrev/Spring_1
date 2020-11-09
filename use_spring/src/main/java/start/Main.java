package start;

import animals.Cat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("animals");

        Cat cat = context.getBean(Cat.class);
        System.out.println(cat.getName());
    }
}
