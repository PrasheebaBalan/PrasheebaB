import java.util.List;
import java.util.ArrayList;


interface PaymentStrategy {
    void pay(int amount);
}


class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;

    public CreditCardPayment(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using credit card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using PayPal.");
    }
}

class ShoppingCart {
    private List<Item> items;
    private PaymentStrategy paymentStrategy;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        int total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        paymentStrategy.pay(total);
    }
}


class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}


public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Laptop", 1000));
        cart.addItem(new Item("Mouse", 50));

        cart.setPaymentStrategy(new CreditCardPayment("John Doe", "1234567890123456"));
        cart.checkout();

        cart.setPaymentStrategy(new PayPalPayment("john.doe@example.com"));
        cart.checkout();
    }
}
