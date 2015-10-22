package westpac;

public class Order {

    public static char BID = 'B';
    public static char ASK = 'A';

    private long id;
    private double price;
    private char side;
    private long size;
    private String sym;


    public Order(long orderid, double orderprice, char orderside, long ordersize, String ordersym) {
        id=orderid;
        price=orderprice;
        size=ordersize;
        side=orderside;
        sym=ordersym;
    }


    public long getId() {
        return id;
    }

    public double getPrice(){
        return price;
    }

    public long getSize(){
        return size;
    }

    public String getSym(){
        return sym;
    }

    public char getSide() {
        return side;
    }

}
