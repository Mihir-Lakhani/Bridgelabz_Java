package Java_Streams.DisplayAllStudentNames;

class Student {

    private String firstName;
    private String lastName;
    int marks;

    Student(String firstName, String lastName, int marks){
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks = marks;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMarks() {
        return marks;
    }

    public String fullName(){
        return (getFirstName() + " " + getLastName());
    }
}