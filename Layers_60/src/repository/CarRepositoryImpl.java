package repository;

import model.Car;
import utils.MyArrayList;
import utils.MyList;

import java.util.concurrent.atomic.AtomicInteger;

public class CarRepositoryImpl implements CarRepository {
    // все машины будут храниться в памяти нашего приложения
    private final MyList<Car> cars;
    // объект, отвечающий за генерацию уникальных ID - исключает "гонку за ресурсы" и доступ из разных потоков
    private final AtomicInteger currentID = new AtomicInteger(1);


    public CarRepositoryImpl () {
        this.cars = new MyArrayList<>();
    }

    private void addStartCar() {
        cars.addAll(
                new Car(currentID.getAndIncrement(),"VW Golf", 2021,20000),
                new Car(currentID.getAndIncrement(),"VW Passat", 2022,30000),
                new Car(currentID.getAndIncrement(),"VW Passat", 2020,24300),
                new Car(currentID.getAndIncrement(),"VW Tiguan", 2023,35000),
                new Car(currentID.getAndIncrement(),"VW Golf", 2020,18500)
        );
    }

    @Override
    public Car addCar(String model, int year, double price) {
        // слой репозитория НЕ ДОЛЖЕН делать никаких проверок
        // это задача сервисного слоя
        // считаем что в репозиторий приходят проверенные данные
        Car car = new Car(currentID.getAndIncrement(),model,year,price);
        cars.add(car);
        return car;
    }

    @Override
    public MyList<Car> getAllCars() {
        return cars;
    }

    @Override
    public Car getCarById(int id) {
        for (Car c: cars) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    @Override
    public Car getCarByModel(String model) {
        for (Car c: cars) {
            if (c.getModel().contains(model)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void saveCar(Car car) {

    }

    @Override
    public void deleteById(int id) {

    }
}
