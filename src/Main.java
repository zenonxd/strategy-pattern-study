import java.util.Scanner;
import java.util.function.Consumer;


public class Main {
    public static void main(String[] args) {
        var paymentMethod = "BOLETO";

        PaymentType paymentType = PaymentType.valueOf(paymentMethod.toUpperCase());
        paymentType.pay(100.0);
    }
}

class PaymentMethod {

    public static void creditCard(double amount) {
        System.out.printf("You payed R$" + amount + " with your CreditCard");
    }

    public static void pix(double amount) {
        System.out.printf("You payed R$" + amount + " with PIX");
    }

    public static void boleto(double amount) {
        System.out.printf("You payed R$" + amount + " with your Boleto");
    }
}

enum PaymentType {
    CREDIT_CARD(PaymentMethod::creditCard), PIX(PaymentMethod::pix),
    BOLETO(PaymentMethod::boleto);

    private final Consumer<Double> paymentStrategy;
    PaymentType(Consumer<Double> paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        paymentStrategy.accept(amount);
    }
}