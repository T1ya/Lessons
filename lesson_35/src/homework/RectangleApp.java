package homework;

public class RectangleApp {

    public static void removeDuplicates(MyArrayList<Rectangle> list, Rectangle obj) {
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i).equals(obj)) {
                list.remove(obj);
            }
        }
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle();
        Rectangle rect3 = new Rectangle(13,14);
        Rectangle rect4 = new Rectangle(13,14);


        System.out.println(rect1);
        System.out.println(rect2);
        System.out.println(rect3);
        System.out.println(rect4);

        System.out.println("rect1 == rect2: " + rect1.equals(rect2));
        System.out.println("rect2 == rect3: " + rect2.equals(rect3));
        System.out.println("rect3 == rect4: " + rect3.equals(rect4));

        MyArrayList<Rectangle> rectangles = new MyArrayList<>();
        rectangles.add(rect1);
        rectangles.add(rect2);
        rectangles.add(rect3);
        rectangles.add(rect4);
        rectangles.add(new Rectangle(13,55));
        rectangles.add(new Rectangle(13,56));
        rectangles.add(new Rectangle(13,57));
        rectangles.add(new Rectangle());

        System.out.println("Rectangles before removing duplicate:");
        System.out.println(rectangles);
        System.out.println("Removing:" + rect1);
        removeDuplicates(rectangles,rect1);
        System.out.println(rectangles);
        System.out.println("Removing:" + rect3);
        removeDuplicates(rectangles,rect3);
        System.out.println(rectangles);
    }
}
