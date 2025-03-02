public class PersonApp {
    public static void main(String[] args) {
        Person Harry = new Person("Harry", 31, "foto");
        Person Jack = new Person("Jack", 40, "fishing");

        System.out.println(Harry.toString());
        System.out.println(Jack.toString());

        Person [] people = new Person[5];
        //stores LINLS
        people[0] = Harry;
        people[1] = Jack;
        people[2] = new Person("Tom",1, "crying");

        Harry.setAge(32);

       for (int i = 0; i < people.length; i++) {
           if (people[i] != null) {
               System.out.println(people[i].toString());
           }
       }
    }
}
