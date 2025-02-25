public class MainCats {
    public static void main(String[] args) {
        Cat cat = new Cat();
        //acces to public state:
        cat.name = "Whiskas";
        cat.age = 4;
        cat.introduce();

        //and methods
        cat.run();

        //make another cat with constructor
        Cat secondCat = new Cat("Buck");
        secondCat.introduce();

        //and third cat)
        Cat thirdCat = new Cat("Daizy", "Red",2);
        thirdCat.introduce();

        //make a link
        Cat barsik = thirdCat;
        barsik.introduce();
        //this will change the original!
        barsik.name = "barsik";
        barsik.introduce();
        thirdCat.introduce();
        //erase the link
        barsik = null;
    }
}
