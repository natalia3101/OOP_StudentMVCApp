package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Controller.iGetModel;

public class ModelHash implements iGetModel{

    private HashMap<Long,Student> students;

    public ModelHash() {
        students = new HashMap<Long,Student>();
    }

    // метод добавления студента
    public void addStudent(String firstName, String lastName, int age, long studentID) {
        students.put(studentID, new Student(firstName, lastName, age, studentID));
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studList = new ArrayList<Student>(); 
        
        for (var stud : students.entrySet())
            studList.add(stud.getValue());

        return studList;
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
