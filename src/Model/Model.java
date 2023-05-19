package Model;

import java.util.List;

import Controller.iGetModel;

public class Model implements iGetModel {
    private List<Student> students;
    // сделать это франилище в hashmaps. позволит создать новую модель и 
    // 

    public Model(List<Student> students) {
        this.students = students;
    }

    public List<Student> getAllStudents()
    {
        return students;
    }

    @Override
    public boolean deleteStudent(long studentID) {
        for (int i = 0; i < students.size(); i ++) {
            if (students.get(i).getStudentID() == studentID) {
                students.remove(i);
                return true;
            }
        }
        
        return false;
    }

    
}
