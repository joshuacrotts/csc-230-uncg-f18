
package assignment3_q3;

/** This class represents a Teacher, bringing down the name, gender and age
 * fields from Person. Two new fields are added: subject and salary to better 
 * suit a teacher.
 *
 * @author Joshua Crotts
 * @date September 24, 2018
 */
public class Teacher extends Person{
    protected String subject;
    protected double salary;
    
    /**
     * Creates a Teacher object, name, age and gender are all a part of the
     * Person class.
     * @param name - String name of Teacher
     * @param age - int age of Teacher
     * @param gender - String gender of Teacher (m/f)
     * @param subject - String subject of teach for Teacher 
     * @param salary - double salary for Teacher
     */
    public Teacher(String name, int age, String gender, String subject, double salary){
        super(name, age, gender);//Calls parent's class constructor (Person)
        
        this.subject = subject;
        this.salary = salary;
    }

    /**
     * 
     * @return subject for Teacher
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 
     * @return salary for Teacher
     */
    public double getSalary() {
        return salary;
    }

    /**
     * 
     * @param salary sets salary for Teacher
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * 
     * @param subject sets subject for Teacher
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 
     * @return String representation of Teacher, calling Person's toString() method
     * to prevent redundant code and to also print out their name, age and gender.
     */
    @Override
    public String toString() {
        return super.toString() + ", subject: " + this.subject + ", salary: "+salary;
    }
    
    
}
