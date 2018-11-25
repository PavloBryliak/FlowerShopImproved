package Flowers;

import delivery.Delivery;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import payments.Payment;

import java.util.ArrayList;

@ToString
public class Order {
    @Getter
    private ArrayList<FlowerBucket> items;
    @Setter @Getter
    private Payment payment;
    @Setter @Getter
    private Delivery delivery;

    public Order() {items = new ArrayList<>();}

    public boolean process(){
        return true;
    }

    public double getPrice() {
        double price = 0;
        for (FlowerBucket bucket: items){
            price += bucket.getPrice();
        }
        return price;
    }
    public void addFlowerBucket(FlowerBucket flowerBucket){
        items.add(flowerBucket);
    }
}
