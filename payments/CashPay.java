package payments;

public class CashPay implements Payment{
    @Override
    public boolean process(double price){
        System.out.println("Paid " + price + " with privat cash ...");
        return true;
    }

}
