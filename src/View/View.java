package View;

import java.util.List;
import java.util.Scanner;

import Controller.iGetView;
import Model.Student;

public class View implements iGetView{
    public void printAllStudents(List<Student> students)
    {
        System.out.println("-----The list of students:-----");
        for(Student person :students)
        {
            System.out.println(person);
        }
        System.out.println("-----End of the list-----");
    }

    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }


}
