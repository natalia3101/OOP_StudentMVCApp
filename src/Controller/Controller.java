package Controller;


import java.util.ArrayList;
import java.util.List;

import Model.Student;

// import javax.jws.WebParam.Mode;
import Model.Model;
import Model.ModelHash;
import View.View;
import View.ViewRus;

public class Controller {

    private List<Student> students; 
    private iGetView view;
    private iGetModel model;

    public Controller(iGetView view, iGetModel model) {
        this.view = view;
        this.model = model;
        this.students = new ArrayList<Student>();
    } 

    public void getAllStudents()
    {
        students = model.getAllStudents();
    }

    public boolean testData()
    {
        if(students.size() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void updateView()
    {
        //MVP
        getAllStudents();
        if(testData())
        {
            view.printAllStudents(students);
        }
        else{
            System.out.println("The student list is empty");
        }
        
        //MVC
        //view.printAllStudent(model.getAllStudent());
    }

    public void run()
    {
        Commands com = Commands.NONE;
        boolean getNewIteration = true;
        while(getNewIteration)
        {
            String command = view.prompt("Enter a command: ");
            com = Commands.valueOf(command.toUpperCase());
            switch(com)
            {
                case EXIT:
                    getNewIteration = false;
                    System.out.println("Exit the app");
                    break;
                case LIST:
                    getAllStudents();
                    updateView();
                    break;
                case DELETE:
                    getAllStudents();
                    String studentID = view.prompt("enter Student Id: ");
                    Long id = Long.valueOf(studentID).longValue();
                    boolean res = model.deleteStudent(id);
                    if (!res)
                        System.out.println("not found");
                    else {
                        System.out.println("deleted");
                        updateView();
                    }
                    break;
                    // добавить команду делит по номеру студента
                    // добавить в интерфейс igetmodel
            }

        }
    }

}
