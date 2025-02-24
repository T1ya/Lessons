public class whileLoop {
    public static void main(String[] args) {
        //while example
        int i = 0;
        while (i < 10){
            System.out.println(i);
            i++;
        }
        //or with decrement
        i = 100;
        while (i > 89) {
            System.out.printf("%d, ",i--);
        }
        System.out.println();
        //can calculate sum with while
        i = 1;
        int sum = 0;
        while (i < 101) {
            sum +=i;
            i++;
        }
        System.out.println("Sum 1..100 = " + sum);
        System.out.println("========");
        String str = "hello";
        i = 0;
        while (i < str.length()){
            System.out.println(str.charAt(i++));
        }
    }
}
