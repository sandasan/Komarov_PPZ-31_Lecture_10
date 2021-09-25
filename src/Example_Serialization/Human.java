package Example_Serialization;

import java.io.Serializable;

public class Human implements Serializable { // Если сериализуемый класс имеет свойства-классы, то они тоже должны поддкрживать сериализацию
    private static final long serialVersionUID = 1L; // Для сериализуемого объекта вычисляется контрольная сумма, но при наличии такого статического члена она не вычисляется, а берётся заданная.
    String name;
    int age;
    char sex;
    Human (String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    // Переопределяем метод toString()
    @Override
    public String toString() {
        return ("Name - " + name + ", Age - " + age + ", Sex - " + String.valueOf(sex));
    }
}
