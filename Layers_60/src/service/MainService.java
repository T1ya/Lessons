package service;

import model.Car;
import model.User;
import utils.MyList;

/*
Тут должна быть вся реализация.
 */
public interface MainService {
    public User registerUser(String email, String password);

    boolean loginUser(String email, String password);

    void logoutUser();

    boolean takeCar(int carId);

    Car addCar(String model, int year, double price);

    MyList<Car> getAllCars();
    MyList<Car> getCarsByModel(String model);
    MyList<Car> getFreeCar();

    void deleteCarById(int id);
    User getActiveUser();
}
