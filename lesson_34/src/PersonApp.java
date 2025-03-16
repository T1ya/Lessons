public class PersonApp {
    public static void main(String[] args) {
        Person person = new Person("12345","@.net");

        person.setPassword("sdassdsddd");
        person.setPassword("luckyMe4MeetYou");
        person.setPassword("11111111222223333]");
        person.setPassword("BooChakaLaka123@");

        System.out.println(person);
    }
}
