package HomeWork_10;

import home.alexander.Rectangle;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Group group = null;
        // Меню для выбора действия пользователя
        Scanner in;
        String action;
        // Цикл для проверки команд вызода из программы (exit or quit to close program)
        do {
            // Цикл нахождения в программе с отчечением неправильных команд
            do {
                System.out.println("Please choose an action (test or addgroup, or addstud, or save, or view; exit or quit to close program):");
                in = new Scanner(System.in);
                action = in.nextLine();
                    switch (action) {
                    case "addgroup":
                        group = new Group();
                        group.setName(inputParameter("group name"));
                        break;
                    case "addstud":
                        if (group == null) {
                            System.err.println("Please create a group firstly");
                            break;
                        }
                        group.addStudent(
                            inputParameter("student's name"),
                            inputParameter("student's surname"),
                            Integer.parseInt(inputParameter("student's age")),
                            inputParameter("student's sex"),
                            group
                        );
                        break;
                    case "save":
                        // Запись объекта в файл
                        try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream("fil"))) {
                            OOS.writeObject(group);
                        } catch (IOException e) {
                            System.err.println("ERROR save group !!!");
                            System.err.println(e.getMessage());
                        }
                        break;
                    case "view":
                        // Считывание объекта из файла
                        group = null;
                        try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream("fil"))) {
                            group = (Group) OIS.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            System.err.println("ERROR load group !!!");
                            System.err.println(e.getMessage());
                        }
                        showInfoHeader();
                        group.printGroup();
                        break;
                    case "test":
                        Group PN121 = new Group();
                        PN121.setName("PN121");
                        PN121.addStudent("Alexander", "Boyko", 21, "м", PN121);
                        PN121.addStudent("Alexey", "Vishnyakov", 18, "м", PN121);
                        PN121.addStudent("Katya", "Osadchaja", 18, "ж", PN121);
                        showInfoHeader();
                        PN121.printGroup();

                        try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream("fil"))) {
                            OOS.writeObject(PN121); // Запись объекта в файл
                        } catch (IOException e) {
                            System.err.println("ERROR save group !!!");
                            System.err.println(e.getMessage());
                        }

                        Group KT321 = null;
                        try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream("fil"))) {
                            KT321 = (Group) OIS.readObject(); // Считывание объекта из файла
                        } catch (IOException | ClassNotFoundException e) {
                            System.err.println("ERROR load group !!!");
                            System.err.println(e.getMessage());
                        }
                        showInfoHeader();
                        KT321.printGroup();

                        // Тестирование методов clone() и hashCode()
                        System.out.println("\nТестирование методов clone() и hashCode()");
                        Student student1 = new Student("Andrey", "Borisov", 25, "M");
                        System.out.println("student1 hashCode() = " + student1.hashCode());
                        Student student2 = student1.clone();
                        System.out.println("student2 hashCode() = " + student2.hashCode());
                        System.out.println("student2: " + student2);

                        // Тестирование метода equals()
                        System.out.println("\nТестирование метода equals()");
                        System.out.println("student1.equals(student2): " + (student1.equals(student2) ? "true" : "false"));

                        // Тестирование метода finalize()
                        System.out.println("\nТестирование метода finalize()");
                        int n = 5;
                        for ( ;(n-- > 0); ) {
                            new Student("TestName" + n, "TestSurname" + n, 24, "F"); // Создаётся 5 объектов без ссылки
                        }
                        System.gc(); // Принудительный вызов сборщика мусора
                        break;
                    default:
                        break;
                }
            } while (!action.equals("addgroup")
                    && !action.equals("addstud")
                    && !action.equals("save")
                    && !action.equals("view")
                    && !action.equals("test")
                    && !action.equals("exit")
                    && !action.equals("quit"));
        } while (!action.equals("exit")
                && !action.equals("quit"));
    }

    static String inputParameter(String parameterName) {
        Scanner parameterInput = new Scanner(System.in);
        System.out.print("Please input the " + parameterName + ": ");
        String gotParameterName = parameterInput.nextLine();
        return gotParameterName;
    }

    static void showInfoHeader() {
        System.out.println("\nВывод данных считанного объекта: ");
    }
}
