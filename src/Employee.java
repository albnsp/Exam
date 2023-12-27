import java.util.Objects;

public class Employee {

    private final int id;

    private static int counter;

    private String name;

    private String surname;

    private String otchestvo;

    private int department;

    private int salary;

    public Employee(String name, String surname, String otchestvo, int department, int salary) {
        if (department <=0 || department > 5) throw new IllegalArgumentException("ошибка!");
        counter++;
        this.id = getCounter();
        this.name = name;
        this.surname = surname;
        this.otchestvo = otchestvo;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        if (department >= 1 && department <= 5) {
            department++;
        }
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", otchestvo='" + otchestvo + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
        public String getPullName() {
            return "Employee{" +
                    "surname='" + surname + '\'' +
                    ", name='" + name + '\'' +
                    ", otchestvo='" + otchestvo + '\'' +
                    '}';
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department && salary == employee.salary && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(otchestvo, employee.otchestvo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


