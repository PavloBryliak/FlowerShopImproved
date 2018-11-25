package discounts;

import Flowers.Order;

public class PromocodeDiscount extends Discount {
    //private Order order;
    public PromocodeDiscount(Order order){ super(order);}
    @Override
    public double getPrice(){
        return 0.9*super.getPrice();
    }
}

