package assignment3_q3;

/**
 * This class represents a Student; the name, gender and age fields are brought
 * down from the Person class via extends hierarchy, and new fields (idNumber
 * and gpa) are implemented to better suit a Student.
 *
 * @author Joshua Crotts
 * @date September 24, 2018
 */
public class Student extends Person {

    protected String idNumber;
    protected double gpa;

    public Student(String name, int age, String gender, String idNum, double gpa) {
        super(name, age, gender);
        this.idNumber = idNum;
        this.gpa = gpa;

    }

    /**
     * 
     * @return ID number for Student
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 
     * @return GPA for Student
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * 
     * @param idNumber sets ID number for Student
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * 
     * @param gpa sets GPA for Student
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     * Overrides toString() from Person and calls Person's toString() method
     * to prevent redundant code
     * @return string representation of Student; prints Student fields and fields
     * from Person
     */
    @Override
    public String toString() {
        return super.toString() + ", ID Number: " + this.idNumber + ", GPA: " + this.gpa;
    }

}
