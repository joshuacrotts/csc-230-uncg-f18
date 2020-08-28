package assignment3_q3;

/**
 * This is the Driver class for Question 3 of assignment 3, regarding a
 * hierarchy of a Person, Student, CollegeStudent and Teacher classes. This
 * class itself tests the implementation of the toString() method for each
 * class.
 *
 * @author Joshua Crotts
 * @date September 24, 2018
 */
public class DriverClass_Q3 {

    public static void main(String[] args) {
        Person bob = new Person("Coach Bob", 27, "M");
        System.out.println(bob);

        Student lynne = new Student("Lynne Brooke", 16, "F", "HS95129", 3.5);
        System.out.println(lynne);

        Teacher mrJava = new Teacher("Duke Java", 34, "M", "Computer Science", 50000);
        System.out.println(mrJava);

        CollegeStudent ima = new CollegeStudent("Ima Frosh", 18, "F", "UCB123", 4.0, 1, "English");
        System.out.println(ima);
    }
}
