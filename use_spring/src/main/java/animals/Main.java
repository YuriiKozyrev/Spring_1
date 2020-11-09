package animals;

import configs.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Cat cat = context.getBean(Cat.class);
        System.out.println(cat.getName());

        Dog dog = context.getBean(Dog.class);
        System.out.println(dog.getName());
    }

}
