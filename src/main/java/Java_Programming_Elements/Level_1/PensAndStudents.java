public class PensAndStudents {
    public static void main(String[] args){

        int pens = 14;

        int students = 3;

        int pen_per_std = pens/students;

        int remaining_pens = pens%students;

        System.out.printf("The pen per student is %d and the remaining pen is %d", pen_per_std, remaining_pens);
    }
}
