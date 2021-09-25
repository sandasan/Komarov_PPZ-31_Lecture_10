package HomeWork_10;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    final int prime = 31;
    String name, surname, sex;
    String groupName = "";
    int age;
    Student (String name, String surname, int age, String sex) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    // Переопределяем метод toString()
    @Override
    public String toString() {
        return ("Group - " + groupName + ", Name - " + name + ", Surname - " + surname + ", Age - " + age + ", Sex - " + sex);
    }

    @Override @Deprecated
    public void finalize() {
        System.out.println("Student record destroyed.");
    }

    // Переопределяем метод hashCode() вычисления хеша объекта
    @Override
    public int hashCode() {
        int result = 1;
        long temp;
        temp = hashString(name);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = hashString(surname);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = hashString(groupName);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = hashString(sex);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(age);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    // Функция расчёта хеша для строки
    long hashString(String string) {
        long result = 0;
        for (int i = 0; i < string.length(); i++) {
            result += string.charAt(i) * Math.pow(prime, (string.length() - 1));
        }
        return result;
    }

    // Переопределяем метод equals() для сравнения объектов по содержимому
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (obj == null) return false;
        else if (this.getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        if (hashString(name) != hashString(student.name)) return false;
        if (hashString(surname) != hashString(student.surname)) return false;
        if (hashString(groupName) != hashString(student.groupName)) return false;
        if (hashString(sex) != hashString(student.sex)) return false;
        if (Double.doubleToLongBits(age) != Double.doubleToLongBits(student.age)) return false;
        return true;
    }

    // Переопределяем метод clone()
    @Override
    public Student clone() {
        try {
            return (Student) super.clone(); //  используем метод clone() суперкласса Object, если он поддерживается
        } catch (CloneNotSupportedException e) { // а если не поддерживается, делаем свою реализацию клонирования этого объекта
            Student student = new Student(name, surname, age, sex);
//            System.out.println(e.getMessage());
            return student;
        }
    }
}
