package assignment3_q3;

/**
 * This class extends the Student class, in that this class now has a major
 * field alongside the CollegeStudent's current year in college.
 *
 * @author Joshua
 */
public class CollegeStudent extends Student {

    protected String major;
    protected int year;

    /**
     * Instantiates a CollegeStudent object
     *
     * @param name - Name of Student
     * @param age - Age of student
     * @param gender - Gender of student M or F
     * @param idNum - ID number of student
     * @param gpa - Student's current GPA
     * @param year - Current year of study for student
     * @param major - College student's chosen major
     */
    public CollegeStudent(String name, int age, String gender, String idNum, double gpa, int year, String major) {
        super(name, age, gender, idNum, gpa); //super() is called to pass the first 3 parameters to the extended superclass Student
        this.major = major;
        this.year = year;
    }

    /**
     * 
     * @return major of CollegeStudent
     */
    public String getMajor() {
        return major;
    }

    /**
     * 
     * @return current year of study
     */
    public int getYear() {
        return year;
    }

    /**
     * 
     * @param major sets CollegeStudent major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * 
     * @param year Sets current year for student (1-4) for freshman to senior respectively.
     */
    public void setYear(int year) {
        if(year < 1 || year > 4)
            throw new IllegalArgumentException("Year must be between 1-4");
        this.year = year;
    }

    /**
     * Overrides toString() by calling Student's toString() method 
     * so redundant info isn't repeated and prints out CollegeStudent-specific
     * info
     * @return String representation of CollegeStudent
     */
    @Override
    public String toString() {
        return super.toString() + ", Major: " + this.major + ", Year: " + this.year;
    }

}
