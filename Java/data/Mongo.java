package data;

public class Mongo implements Database {

    @Override
    public void save(String data) {
        System.out.println("Lưu " + data + " vào MongoDB");   
    }
}
