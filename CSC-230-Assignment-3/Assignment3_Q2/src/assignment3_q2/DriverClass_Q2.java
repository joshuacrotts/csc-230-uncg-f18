package assignment3_q2;

/**
 * This class is the Driver class for Question 2 of Assignment 3, regarding a
 * Book and Author class. Book have Author objects, and other fields alongside
 * getters and setters.
 *
 * @author Joshua Crotts
 * @date September 24, 2018
 */
public class DriverClass_Q2 {

    public static void main(String[] args) {
        Book toc = new Book("Theory of Computation", new Author("Michael Sipser", "msipser@mit.edu", 'm'), 200.00, 12);

        System.out.println("Book name: " + toc.getName());
        System.out.println("Book price: " + toc.getPrice());
        System.out.println("Book qty in stock: " + toc.getQtyInStock());
        System.out.println("\nAuthor of book: " + toc.getAuthor().getName());
        System.out.println("Author's email: " + toc.getAuthor().getEmail());
        System.out.println("Author's gender: " + toc.getAuthor().getGender());
    }
}
