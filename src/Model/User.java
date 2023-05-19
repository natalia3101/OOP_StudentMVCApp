package Model;

// любой участник образовательного процесса, сюда входят любые люди из универа - студенты, преподаватели, сотрудники
// я кстати не поняла, почему юзер не анонимный
public class User {
    private String firstName;
    private String lastName;
    private int age;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User {" +
                "first name is " + firstName +
                ", last name is " + lastName +
                ", age is " + age +
                '}';
    }
}