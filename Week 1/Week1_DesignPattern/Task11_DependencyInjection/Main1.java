public class Main1 {
    public static void main(String[] args) {
        // Create repository implementation
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        
        // Inject repository into service
        CustomerService customerService = new CustomerService(customerRepository);

        // Use service to find a customer
        Customer customer = customerService.getCustomer(1);
        System.out.println("Customer found: " + customer.getName());
    }
}