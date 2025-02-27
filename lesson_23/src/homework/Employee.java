package homework;

public class Employee {
    private String name;
    private int age;
    private int salary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // геттеры - можно добавить


    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    // c сеттерами сложнее.

    // предположим, что работник в ЗАГС не пойдёт и имя меняться не должно. Поэтому для имени сеттер ставить не будем

    // возраст работника - величина изменяемая, сделаем сеттер
    // пусть работник может трудиться с совершеннолетия до момента выхода на пенсию
    public void setAge(int age) {
        if (age > 18 && age < 67) {
            this.age = age;
        }
    }

    // зарплата тоже изменяемая величина, сделаем сеттер
    // во избежание коррупционной составляющей сделаю ограничение зарплаты сверху в 1000000 евро)
    public void setSalary(int salary) {
        if (salary >= 0 && salary < 1000000) {
            this.salary = salary;
        }
    }

    public void info() {
        String result = String.format("Employee: %s, age: %d, salary: %d", this.name, this.age, this.salary);
        System.out.println(result);
    }
}
