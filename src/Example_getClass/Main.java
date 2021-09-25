package Example_getClass;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Is 'sc' belongs to class 'Scanner': " + check(sc, Scanner.class));
        System.out.println("Is 'sc' belongs to class 'int': " + check(sc, int.class));
    }

    public static boolean check(Object obj, Class<?> classOne) {
        Class<?> classTwo = obj.getClass();
        if (classOne == classTwo) {
            return true;
        }
        return false;
    }
}
