package data;

public class MySQL implements Database {

    @Override
    public void save(String data) {
        System.out.println("Lưu " + data + " vào MySQL");
        
    }
}
