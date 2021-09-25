package HomeWork_10;

import java.io.Serializable;

public class Group implements Serializable {
    private Student[] group;
    String name;
    private static final long serialVersionUID = 1L;

    Group() {
        group = new Student[0];
    }

    public void setName(String name) {
        this.name = name;
    }

    // Добавление студента в группу
    public void addStudent(String name, String surname, int age, String sex, Group destGroup) {
        Student[] newGroup = new Student[group.length + 1]; // Создаём массив студентов длины, на 1 больше, чем количество элементов в существующем массиве group типа Student (готовим место для нового студента)
        System.arraycopy(group, 0, newGroup, 0, group.length); // Копируем существующий массив group в новый с начала, при этом в новом массиве остаётся ещё одна свободная ячейка для нового студента
        Student student = new Student(name, surname, age, sex);
        student.setGroupName(destGroup.name);
        newGroup[newGroup.length - 1] = student; // Добавляем в конец массива нового студента
        group = newGroup; // Записываем обновлённую группу
    }

    // Вывод информации о всей группе
    public void printGroup() {
        for (Student student :
                group) {
            System.out.println(student);
        }
    }
}
