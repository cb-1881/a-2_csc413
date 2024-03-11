    public class PriorQueueTest {
        public static void main(String[] args) {
            LinkedPriorityQueue<Customer> queue = new LinkedPriorityQueue<>();
    
            // Adding customers to the queue
            queue.add(new Customer("C001", "Alice", "ACC123", 1500.00));
            queue.add(new Customer("C002", "Bob", "ACC456", 1200.00));
            queue.add(new Customer("C003", "Charlie", "ACC789", 1800.00));
            queue.add(new Customer("C004", "Dana", "ACC101", 1300.00));
    
            // Printing all customers in priority order
            System.out.println("All customers in priority queue:");
            queue.printList();
    
            // Peeking at the customer with the highest priority
            System.out.println("\nCustomer with highest priority (peek): " + queue.peek());
    
            // Polling customers (retrieving and removing)
            System.out.println("\nPolling customers:");
            Customer polledCustomer;
            while ((polledCustomer = queue.poll()) != null) {
                System.out.println(polledCustomer);
            }
    
            // Trying to peek and poll from an empty queue
            System.out.println("\nPeeking after all customers have been polled: " + queue.peek());
            System.out.println("Polling from empty queue: " + queue.poll());
        }
    
    
    
}
