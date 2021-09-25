package Example_Serialization;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Group PN121 = new Group();
        PN121.addHuman("Alexander", 21, 'м');
        PN121.addHuman("Alexey", 18, 'м');
        PN121.addHuman("Katya", 18, 'ж');

        System.out.println();
        System.out.println("Вывод данных исходного объекта: ");
        System.out.println();
        PN121.printGroup();

        try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream("fil"))) {
            OOS.writeObject(PN121); // Запись объекта в файл
        } catch (IOException e) {
            System.out.println("ERROR save group !!!");
            System.out.println(e.getMessage());
        }
        Group KT321 = null;
        try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream("fil"))) {
            KT321 = (Group) OIS.readObject(); // Считывание объекта из файла
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR load group !!!");
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("Вывод данных считанного объекта: ");
        System.out.println();
        KT321.printGroup();
    }
}
