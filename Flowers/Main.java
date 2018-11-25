package Flowers;

import discounts.Minus20;
import discounts.PromocodeDiscount;
import payments.CashPay;
import payments.Private24Payment;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        Rose rose1 = new Rose(7);
        Tulip tulip1 = new Tulip(5);
        Chamomile chamomile1 = new Chamomile(8);
        FlowerBucket bucket = new FlowerBucket();

        bucket.addFlower(rose1);
        bucket.addFlower(tulip1);
        bucket.addFlower(chamomile1);

        Order order = new Order();
        System.out.println("Want to try our bucket or to create yours?" +
                "Print 'default' or 'own'");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();

        if (choice.equals("default")){
            System.out.println("Thanks!");
            System.out.print("You have to pay: ");
            order.addFlowerBucket(bucket);
            System.out.print(order.getPrice());
        }
        if (choice.equals("own")){
            FlowerBucket myBucket = new FlowerBucket();

            System.out.println("Which flowers do you need? Print flower name");
            Scanner scan1 = new Scanner(System.in);
            String choice1 = scan1.nextLine();
            if (choice1.equals("rose")){
                System.out.println("How much Roses do you need? Print a number.");
                Scanner scan11 = new Scanner(System.in);
                int choice11 = scan11.nextInt();
                Rose rose = new Rose(choice11);
                myBucket.addFlower(rose);

            }

            if (choice1.equals("chamomile")){
                System.out.println("How much Chamomiles do you need? Print a number.");
                Scanner scanCh = new Scanner(System.in);
                int choiceCh = scanCh.nextInt();
                Chamomile chamomile = new Chamomile(choiceCh);
                myBucket.addFlower(chamomile);

            }

            if (choice1.equals("tulip")){
                System.out.println("How much Tulips do you need? Print a number.");
                Scanner scanTu = new Scanner(System.in);
                int choiceTu = scanTu.nextInt();
                Tulip tulip = new Tulip(choiceTu);
                myBucket.addFlower(tulip);

            }

            order.addFlowerBucket(myBucket);

            System.out.println("Thanks!");
            System.out.print("Please, pay: ");
            System.out.print(order.getPrice());
        }

        System.out.println("Do you have any discounts? Print type of discount 'minus20' or 'promocode'");
        Scanner discountPay = new Scanner(System.in);
        String discount = discountPay.nextLine();

        if (discount.equals("minus20")){
            Minus20 minus = new Minus20(order);
            minus.process();
            System.out.println(order.getPrice());
        }
        if (discount.equals("promocode")){
            PromocodeDiscount promocode = new PromocodeDiscount(order);
            promocode.process();
            System.out.println(order.getPrice());
        }

        System.out.println("You will pay throught Privat24 'pr24' or by cash'cash'");
        Scanner pay = new Scanner(System.in);
        String payment = pay.nextLine();

        if (payment.equals("pr24")){
            Private24Payment pr24 = new Private24Payment();
            pr24.process(order.getPrice());
        }

        if (payment.equals("cash")){
            CashPay cash = new CashPay();
            cash.process(order.getPrice());
        }
    }

}
