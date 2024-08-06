public class TestDecoratorPattern {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        
        // Sending Email only
        notifier.send("Hello via Email!");

        // Adding SMS notification
        Notifier smsNotifier = new SMSNotifierDecorator(notifier);
        smsNotifier.send("Hello via Email and SMS!");

        // Adding Slack notification
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);
        slackNotifier.send("Hello via Email, SMS, and Slack!");
    }
}
