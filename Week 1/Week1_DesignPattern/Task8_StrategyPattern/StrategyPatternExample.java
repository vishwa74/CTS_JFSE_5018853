public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Use Credit Card Payment
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432", "John Doe"));
        context.executePayment(100.0);

        // Use PayPal Payment
        context.setPaymentStrategy(new PayPalPayment("john.doe@example.com"));
        context.executePayment(200.0);
    }
}