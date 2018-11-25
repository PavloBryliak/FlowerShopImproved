package payments;

public class Private24Payment implements Payment{
    @Override
    public boolean process(double price){
        System.out.println("Paid " + price + " with privat 24 ...");
        return true;
    }

}