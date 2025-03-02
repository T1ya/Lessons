public class Person {
    private String name;
    private int age;
    private String hobby;

    Person(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHobby() {
        return hobby;
    }

    public String toString() {
        String result = String.format("Employee: %s, age: %d, hobby: %s", this.name, this.age, this.hobby);
        return result;
    }
}
