import java.util.Arrays;
import java.util.Comparator;

public class ComparatorApp {
    public static void main(String[] args) {
        int[] ints = {1,3,5,2,8,4,12,0,7};
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));

        Car[] cars = new Car[7];
        cars[0] = new Car("BMW", 2010, 200);
        cars[1] = new Car("Opel", 2015, 150);
        cars[2] = new Car("Renault", 2010, 150);
        cars[3] = new Car("Alfa", 2010, 250);
        cars[4] = new Car("Ferrari", 2022, 280);
        cars[5] = new Car("Ferrari", 2023, 280);
        cars[6] = new Car("Ferrari", 2021, 280);

        printCars(cars);
        Arrays.sort(cars);
        System.out.println("Default sort");
        printCars(cars);

        CarSpeedComparator speedComparator = new CarSpeedComparator();
        System.out.println("Sort by speed");
        Arrays.sort(cars,speedComparator);
        printCars(cars);

        System.out.println("Sort by model");
        //можно так
        //Arrays.sort(cars,new CarModelComparator());
        //а можно с анонимным классом - создать класс прямо в параметрах)
        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                int result =  o1.getModel().compareTo(o2.getModel());
                if (result == 0) {
                    result = o2.getYear() - o1.getYear();
                }
                return result;
            }
        });
        printCars(cars);

        //функциональный интерфейс - это интерфейсный класс, который имеет РОВНО ОДИН абстрактный метод
        //Comparator - функциональный интерфейс

        /*
        Сделан он на лямбда-выражениях
        А лямбда-выражения - это компактный синтаксис для реализации анонимных функций в Java

        они во многих случаях могут заменить анонимные классы и реализовывать функциональные интерфейсы "на лету"

        Ситнаксис:
        (parameters)->expression;
        или
        {parameters}->{return statements};
         */

        //отсортируем машины по году в обратном порядке с помощью лямбда выражений
        //eсли пишем в одну строчку - даже return писать не надо
        Arrays.sort(cars,(c1,c2)-> c1.getYear() - c2.getYear());
        System.out.println("Sort by year - Lambda");
        printCars(cars);

        //отсортировать машины по скорости в порядке убывания
        //если скорость совпадает - осортировать по году в порядке убывания
        Comparator<Car> carComparator = (c1, c2)-> {
            //int result = c1.getMasSpeed() - c2.getMasSpeed(); // может быть переполнение типа данных
            int result = Integer.compare(c1.getMasSpeed(), c2.getMasSpeed());   //а так не может)
            if (result == 0) {
                result = c1.getYear() - c2.getYear();
            }
            return result;
        };
        Arrays.sort(cars,carComparator);
        System.out.println("Sort by speed and year - Lambda block");
        printCars(cars);

        //Comparator имеет набор статических и дефолтных методов
        //comparing - позволяет сортировать объекты по ключу

        //cледующий компаратор будет сравнивать объекты по ключу - модели
        Comparator<Car> byModel = Comparator.comparing(car -> car.getModel());
        //или так - сокращённая запись лямбды
        Arrays.sort(cars, Comparator.comparing(Car::getModel));
        printCars(cars);

        //есть обёртки для примитивов (int, double и т п)
        Arrays.sort(cars, Comparator.comparingInt(Car::getYear));
        printCars(cars);

        //метод comparing перегружен. Можно передать второй метод сравнения
        //например, так мы выведем машины по УМЕНЬШЕНИЮ года выпуска
        Arrays.sort(cars, Comparator.comparing(Car::getYear, Comparator.reverseOrder()));
        printCars(cars);

        //попробуем отсортировать по модели, а если модели равны - то по убыванию года выпуска
        Arrays.sort(cars, Comparator.comparing(Car::getModel).thenComparing(Car::getYear, Comparator.reverseOrder()));
        printCars(cars);

        //отсортировать машины по году выпуска. если год равен - отсортировать по модели в обратном порядке
        Arrays.sort(cars, Comparator.comparing(Car::getYear).thenComparing(Car::getModel, Comparator.reverseOrder()));
        System.out.println("Sort by year and reverse model");
        printCars(cars);

        //отсортировать по году в обратном порядке, если год равен - то по максимальной скорости
        Arrays.sort(cars, Comparator.comparing(Car::getYear, Comparator.reverseOrder()).thenComparing(Car::getMasSpeed));
        System.out.println("Sort by reverse year and max speed");
        printCars(cars);
    }




    public static void printCars(Car[] cars) {
        System.out.println("================");
        for (Car c: cars) {
            System.out.println(c);
        }
        System.out.println("================");
    }
}
