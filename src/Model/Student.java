package Model;

// создаем одного из участника университета - студента. она/он имеет имя, фамилию, возраст и id
public class Student extends User implements Comparable<Student> {
    private long studentID;

    public Student(String firstName, String lastName, int age, long studentID) {
        super(firstName, lastName, age);
        this.studentID = studentID;
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    // вывод студента
    @Override
    public String toString() {
        return "Student {" 
                
                +"first name is " + super.getFirstName()
                +", last name is " + super.getLastName()
                +", age is " + super.getAge()+
                ", student ID is " + studentID +
                '}';
    }

    // метод для сравнения студентов по разным параметрам
    // в данном случае сначала они сравниваются по возрасту, потом по id
    @Override
    public int compareTo(Student o) {
        
        // System.out.println(super.getFirstName() + " - " + o.getFirstName());
         if(super.getAge() == o.getAge())
         {
            if(this.studentID == o.studentID)
            {
                return 0;
            }
            if(this.studentID < o.studentID)
            {
                return -1;
            }
            return 1;
         } 
         if(super.getAge() < o.getAge())
         {
            return -1;
         }   
         return 1;
    }
}
