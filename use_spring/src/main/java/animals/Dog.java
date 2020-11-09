package animals;
import org.springframework.stereotype.Component;


public class Dog {

    private String name = "Барбос";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
