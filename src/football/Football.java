package football;

public class Football {
    private int number;
    private String position;
    private int salary;
    private int age;

    public Football(){}

    public Football(int number, String position, int salary, int age) {
        this.number = number;
        this.position = position;
        this.salary = salary;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public int getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        String result = "Number: " + getNumber() + ", position: " + getPosition() + ", salary: " + getSalary() + ", age: " + getAge();
        return result;
    }
}
