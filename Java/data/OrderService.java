package data;

public class OrderService {
    private Database data;

    public OrderService( Database data){
        this.data = data;
    }

    public void checkout(String id){
        data.save(id);
    }
}
