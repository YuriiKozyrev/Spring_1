package configs;


import animals.Cat;
import animals.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public Cat getCat() {
        return new Cat();
    }

/*    @Bean
    public Dog getDog() {
        return new Dog();
    }*/

    @Bean
    public Dog getDog(Cat cat) {
        Dog dog = new Dog();
        dog.setName(dog.getName() + " ловит " + cat.getName());
        return dog;
    }

}
