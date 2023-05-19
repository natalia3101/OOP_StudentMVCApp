package View;

import java.util.List;
import java.util.Scanner;

import Controller.iGetView;
import Model.Student;

public class ViewRus implements iGetView {
    public void printAllStudents(List<Student> students)
    {
        System.out.println("-----Вывод списка студентов:-----");
        for(Student person :students)
        {
            System.out.println(person);
        }
        System.out.println("-----Конец списка-----");
    }

    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
