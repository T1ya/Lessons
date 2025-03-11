public class SimpleApp {
    public static void main(String[] args) {
        SimpleBox obj = new SimpleBox(10);
        System.out.println(obj);

        SimpleBox obj2 = new SimpleBox(20);
        System.out.println(obj2);

        //error!
        //int sum = obj.getValue() + obj2.getValue();

        //can cast to int
        int sum = (int) obj.getValue() + (int) obj2.getValue();
        System.out.println("Sum = " + sum);

        SimpleBox obj3 = new SimpleBox("Eu!");
        System.out.println(obj3);

        //try array
        SimpleBox[] boxes = {
                obj,
                obj2,
                //obj3, // this gives an error
                new SimpleBox(30)};
        int sumAll = 0;

        for (SimpleBox b: boxes) {
            sumAll += (int)b.getValue();
        }
        System.out.println(sumAll);
        //to prevents this kind of errors we can use Generics
    }
}
