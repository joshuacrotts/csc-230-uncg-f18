package assignment3_q2;

/**
 * This class is to represent a Book object.
 *
 * @author Joshua Crotts
 * @date September 24, 2018
 */
public class Book {

    private String name;
    private Author author;
    private double price;
    private int qtyInStock;

    /**
     * Instantiates a Book object
     *
     * @param name - Name of book
     * @param author - Author object (author of said book)
     * @param price - Price of book
     * @param qtyInStock - How many books are remaining in stock
     */
    public Book(String name, Author author, double price, int qtyInStock) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    /**
     * 
     * @return name of book
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return Author object of book
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * 
     * @return price of book
     */
    public double getPrice() {
        return price;
    }

    /**
     * 
     * @return quantity in stock
     */
    public int getQtyInStock() {
        return qtyInStock;
    }

    /**
     * 
     * @param price sets price of book
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 
     * @param qtyInStock sets quantity in stock of book
     */
    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    /**
     * Overrides toString() in object to print out details about author and book
     * @return 
     */
    @Override
    public String toString() {
        return "Book{" + "name=" + name + ", author=" + author + ", price=" + price + ", qtyInStock=" + qtyInStock + '}';
    }

}
