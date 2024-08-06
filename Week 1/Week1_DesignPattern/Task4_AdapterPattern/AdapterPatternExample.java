// AdapterPatternExample.java
public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        PaymentProcessor squareProcessor = new SquareAdapter(new Square());

        payPalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(200.0);
        squareProcessor.processPayment(300.0);
    }
}
