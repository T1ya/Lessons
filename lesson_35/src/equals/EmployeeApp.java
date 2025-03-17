package equals;

public class EmployeeApp {
    public static void main(String[] args) {
        Employee employee = new Employee("John","Doe","21.10.2000");
        Employee employee1 = new Employee("John","Smith","05.12.1990");
        Employee employee2 = new Employee("Jane","Smith","21.10.2000");
        Employee employee3 = new Employee("John","Doe","21.10.2000");

        // Есть два способа сравнения объектов.

        // Оператор == сравнивает ссылки и проверяет, указывают ли они на один и тот же объект в памяти
        System.out.println("employee == employee1 " + (employee == employee1));
        System.out.println("employee2 == employee3 " + (employee2 == employee3));

        // equals сравнивает объекты по значению. И его надо переопределить
        System.out.println("employee equals employee1 " + employee.equals(employee1));
        System.out.println("employee2 equals employee3 " + employee2.equals(employee3));
        System.out.println("employee equals employee3 " + employee.equals(employee3));
    }
}
