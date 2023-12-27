import javax.naming.MalformedLinkException;

public class Main {
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = new Employee("Alex", "Gordeev", "Vladimirovich", 1, 15_000);
        employees[1] = new Employee("Dmitriy", "Savelev", "Ivanovich", 2, 150_000);
        employees[2] = new Employee("Gabrail", "Abogyan", "Amtonovich", 3, 29_000);
        employees[3] = new Employee("Alina", "Burova", "Sergeevna", 4, 200_000);
        employees[4] = new Employee("Svetlana", "Shalaeva", "Urevna", 5, 370_000);
        employees[5] = new Employee("Egor", "Sevicky", "Vladimirovich", 1, 77_000);
        employees[6] = new Employee("Tatyana", "Nafka", "Dmitreevna", 2, 88_000);
        employees[7] = new Employee("Semen", "Kafka", "Kirillovich", 3, 93_000);
        employees[8] = new Employee("Sara", "Demina", "Fedorovna", 4, 57_000);
        employees[9] = new Employee("Artem", "Alexseev", "Vladimirovich", 5, 300_000);

        int departmentNumber = 4;

        all();
        System.out.println();
        System.out.println(getMinSalary());
        System.out.println();
        System.out.println(getSumSalaryPerMonth());
        System.out.println();
        System.out.println(getMaxSalary());
        System.out.println();
        System.out.println(getSredneeZnachenie());
        System.out.println();
        aVoid();

        System.out.println();
        getIndexSalary();

        // Задание 2. b.
        System.out.println("Сотрудник с максимальной зарплатой в отделе № "+ departmentNumber +" - " + getMaxDepartmentSalary(2));
        System.out.println(" ");
        // Задание 2. c.
        System.out.printf("Сумма затрат на зарплаты в месяц: в отделе № " + departmentNumber + " - %.2f рублей.", getSumSalaryDepartmentPerMonth(departmentNumber));
        System.out.println(" ");
        System.out.println(" ");
        // Задание 2. d.
        System.out.printf("Среднее значение зарплат: в отделе № " + departmentNumber +" - %.2f рублей.", getAverageSalaryDepartment(departmentNumber));
        System.out.println(" ");
        System.out.println(" ");
        // Задание 2. e.
        getIndexSalaryDepartment(departmentNumber);
        System.out.println(" ");
        System.out.println(" ");
        // Задание 2. f.
        getAllEmployeesDepartment(departmentNumber);
        System.out.println(" ");
        // Задание 3 a.
        double EmployeesSalary = 30000.00d;
        getAllEmployeesSalaryMin(EmployeesSalary);
        System.out.println(" ");
        // Задание 3 b.
        getAllEmployeesSalaryMax(EmployeesSalary);
    }


    // a
    private static void all() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    // минимальная зарплата  (с)
    public static Employee getMinSalary() {
        double min = 0;
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                min = employees[i].getSalary();
                index = i;
                break;
            }
        }
        Employee minSalary = employees[index];
        for (int i = index; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                minSalary = employees[i];
            }
        }
        return minSalary;
    }

    //зарплаты в месяц (b)
    public static double getSumSalaryPerMonth() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee == null) continue;
            sum += employee.getSalary();
        }
        return sum;
    }

    // максимальная зарплата (d)
    public static Employee getMaxSalary() {
        double max = 0;
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                max = employees[i].getSalary();
                index = i;
                break;
            }
        }
        Employee maxSalary = employees[index];
        for (int i = index; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                maxSalary = employees[i];
            }
        }
        return maxSalary;
    }

    //среднее значение (e)
    public static double getSredneeZnachenie() {
        double sum = getSumSalaryPerMonth();
        int count = countEmployees();
        return sum / count;
    }

    public static int countEmployees() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return count;
    }

    public static void aVoid() {
        for (Employee employee : employees) {
            System.out.println(employee.getPullName());
        }
    }

    // повышенная сложность

    // 1
    public static void getIndexSalary() {
        int arg = 10;
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * arg / 100);
                System.out.println("задание 1: " + employee.getSalary());

            }
        }
    }

    //2 a
    //Повышенная сложность.
    public static Employee getMinDepartmentSalary(int departmentNumber) {
        int min = 0;
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                min = employees[i].getSalary();
                index = i;
                break;
            }
        }

        Employee minSalary = employees[index];
        for (int i = index; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() < min && employees[i].getDepartment() == departmentNumber) {
                min = employees[i].getSalary();
                minSalary = employees[i];
            }
        }
        return minSalary;
    }

    //2 b
    public static Employee getMaxDepartmentSalary(int departmentNumber) {
        double max = 0;
        int index = 0;
        Employee maxSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                max = employees[i].getSalary();
                maxSalary = employees[i];
                index = i;
                break;
            }
        }

        for (int i = index; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() > max && employees[i].getDepartment() == departmentNumber) {
                max = employees[i].getSalary();
                maxSalary = employees[i];
            }
        }
        return maxSalary;
    }
    // 2 c
    public static double getSumSalaryDepartmentPerMonth(int departmentNumber) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getDepartment() == departmentNumber) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }

    // 2 d
    public static double getAverageSalaryDepartment(int departmentNumber) {
        double sum = 0;
        int countEmp = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getDepartment() == departmentNumber) {
                countEmp++;
                sum += employees[i].getSalary();
            }
        }
        return sum / countEmp;
    }

    //2 e
    public static void getIndexSalaryDepartment(int departmentNumber) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * departmentNumber / 100);
                System.out.printf("%.2f  ", employee.getSalary());
            }
        }
    }
    //2 f
    public static void getAllEmployeesDepartment(int departmentNumber) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                System.out.println("Информация о сотруднике: (Уникальный идентификатор = " + employee.getId() + ", " + employee.getPullName() + ", З/П в месяц: " + employee.getSalary() + ')');
            }
        }
    }

    //3 a
    public static void getAllEmployeesSalaryMin(double EmployeesSalary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < EmployeesSalary) {
                System.out.println("Информация о сотруднике: (Уникальный идентификатор = " + employee.getId() + ", " + employee.getPullName() + ", З/П в месяц: " + employee.getSalary() + ')');
            }
        }
    }
    //3 b
    public static void getAllEmployeesSalaryMax(double EmployeesSalary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= EmployeesSalary) {
                System.out.println("Информация о сотруднике: (Уникальный идентификатор = " + employee.getId() + ", " + employee.getPullName() + ", З/П в месяц: " + employee.getSalary() + ')');
            }
        }
    }
}


