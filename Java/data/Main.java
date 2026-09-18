package data;

public class Main {
   public static void main(String[] args) {
        Database data = new MySQL();
        OrderService sv1 = new OrderService(data);
        sv1.checkout("0792252181");
    }
}
