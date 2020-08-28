package assignment3_q3;

/**
 * This class represents a Person.
 *
 * @author Joshua Crotts
 * @date September 24, 2018
 */
public class Person {

    protected String name;
    protected int age;
    protected String gender;

    /**
     * Creates an Author object
     *
     * @param name - name of person
     * @param age - age of person
     * @param gender - char of person, M or F
     */
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    /**
     * 
     * @return name of Person
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return age of Person
     */
    public int getAge() {
        return age;
    }

    /**
     * 
     * @return gender of Person
     */
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param name sets name of Person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @param age sets age of Person
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 
     * @param gender sets gender of Person
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Overrides toString() from Object and prints out relevant instance vars
     * for Person
     * @return String representation of Person, prints out instance variables
     */
    @Override
    public String toString() {
        return "Name: " + this.name + ", Age: " + this.age + ", Gender: " + this.gender;
    }
}
