package homework;

public class MyArrayApp {
    public static void main(String[] args) {
        MyArrayList<String> myList = new MyArrayList<>();
        System.out.println("List is empty? " + myList.isEmpty());
        myList.add("do");
        myList.add("re");
        myList.add("mi");
        myList.add("fa");
        System.out.println(myList + " size: " + myList.size());
        String[] restValues = new String[] {null, null, "la","si","do"};
        myList.addAll(restValues);
        myList.addAll(null);

        System.out.println(myList + " size: " + myList.size());

        System.out.println("Contains \"sol\"? - " + myList.contains("sol"));
        myList.remove(5);
        System.out.println(myList);
        System.out.println("List is empty? " + myList.isEmpty());

        myList.set(13, "sol");
        myList.set(4, "sol");
        System.out.println("String with index 4 is " + myList.get(4));

        System.out.println(myList);
        System.out.println(myList.indexOf(null));
        System.out.println(myList);
        System.out.println("Index of \"do\" is " + myList.lastIndexOf("do"));
        System.out.println("Last index of \"do\" is " + myList.indexOf("do"));
    }
}
