package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Controller.iGetModel;

public class FileRepo implements iGetModel{
    private String fileName;
    private List<Student> students;

    public FileRepo(String fileName) {
        this.fileName = fileName;
        this.students = new ArrayList<>();
        try(FileWriter fw = new FileWriter(fileName, true))
        {
            fw.flush(); 
            // закрыли и скинули данные из памяти   
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // если есть ошибка, то он покажет, что за ошибка
        }
    }


    public void addStudent(Student student)
    {
        this.students.add(student);
    }


    public void readAllStudentsFromFile()
    {
        try
        {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line != null)
            {
                String[] param = line.split(" ");
                Student pers = new Student(param[0], param[1], Integer.parseInt(param[2]), Long.parseLong(param[3]));
                students.add(pers);
                line = reader.readLine();
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            // вывод ошибки
        }
    }


    public void saveAllStudentToFile()
    {
        try(FileWriter fw = new FileWriter(fileName, true))
        {
            for(Student pers : students)
            {
                fw.write(pers.getFirstName()+" "+pers.getLastName()+" "+pers.getAge()+" "+pers.getStudentID());
                fw.append('\n');
            }
            fw.flush();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> getAllStudents() {
        readAllStudentsFromFile();
        return students;
    }


    @Override
    public boolean deleteStudent(long studentID) {
        
        for (int i = 0; i < students.size(); i ++) {

            if (students.get(i).getStudentID() == studentID) {

                students.remove(i);
       
                // Очищаем файл со студентами и сохраняем обновлённый список
                try (FileWriter fw = new FileWriter(fileName, false)) {
                    fw.flush();
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
                saveAllStudentToFile();

                return true;
            }
        }

        return false;
    }
}
