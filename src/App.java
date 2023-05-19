import java.util.ArrayList;
import java.util.List;

import Controller.Controller;
import Controller.iGetModel;
import Controller.iGetView;
import Model.FileRepo;
import Model.Model;
import Model.Student;
import View.View;

public class App {
    public static void main(String[] args) throws Exception {
        List<Student> students = new ArrayList<>();
        Student s1 = new Student("Galina", "Slepenko", 60, 543);
        Student s2 = new Student("Dima", "Slepenko", 32, 523);
        Student s3 = new Student("Nat", "Babenko", 25, 53);
        Student s4 = new Student("Petr", "Slepenko", 65, 343);
        Student s5 = new Student("Chris", "Manulina", 26, 943);
        Student s6 = new Student("Lou", "H", 34, 843);
        Student s7 = new Student("Arthur", "C", 41, 93);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);
        
        FileRepo fileRepo = new FileRepo("StudentDb.txt");
    //    for(Student pers :students)
    //    {
    //     fileRepo.addStudent(pers);
    //    }
    //    fileRepo.saveAllStudentToFile();
        iGetModel model = new Model(students);
        iGetModel modelFileRepo = fileRepo;



        iGetView view = new View();
        Controller control = new Controller(view, model);
        control.run();
        // control.updateView();

    
    }
}
