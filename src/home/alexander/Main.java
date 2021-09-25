package home.alexander;

public class Main {

    public static void main(String[] args) {
        Rectangle a = new Rectangle(4, 5);
        Rectangle b = new Rectangle(4, 5);
        Rectangle c = a.clone();
        System.out.println(a); // Использование метода toString()

        int n = 10;
        for ( ;(n-- > 0); ) {
            new Rectangle(3, 4); // Создаётся 10 объектов без ссылки
        }
        System.gc(); // Принудительный вызов сборщика мусора

        System.out.println("a.hashCode() = " + a.hashCode());

        System.out.println("a equals b: " + a.equals(b)); // Вернёт false, если метод equals() не переопределён, так как сравниваются ссылки, а они разные. Для сравнения внутреннего содержимого нужно переопределить метод equals.
        a.length = 3;
        System.out.println("a: " + a);
        System.out.println("c: " + c);

        /*
        Правила, которые должны выполняться при переопределении метода equals:
        - Для любого ненулевого значения x x.equals(x) должен возвращать true.
        - Для любых ненулевых значений x и y x.equals(y) должен возвращать true тогда и только тогда, когда y.equals(x) возвращает true.
        - Для любых ненулевых значений x, y, и z если x.equals(y), возвращает true и y.equals(z) возвращает true, то x.equals(z) должно вернуть true.
        - Для любых ненулевых значений x и y множественные вызовы x.equals(y) последовательно должны возвращать true или false, если информация, которая используется при их сравнении, не изменяется.
        - Для любых ненулевых x x.equals(null) должен вернуть false.
        */
    }
}
