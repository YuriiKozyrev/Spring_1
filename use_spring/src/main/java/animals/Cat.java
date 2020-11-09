package animals;

import org.springframework.stereotype.Component;

public class Cat {

    private String name = "Мурзик";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

