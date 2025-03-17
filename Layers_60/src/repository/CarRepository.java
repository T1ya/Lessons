package repository;

import model.Car;
import utils.MyList;

/*
В любом репозитории обязательно должны быть CRUD - операции:
- Create
- Read
- Update
- Delete
 */

public interface CarRepository {
    // Create
    Car addCar(String model, int year, double price);   // add new car

    // Read
    MyList<Car> getAllCars();                          //get cars list
    Car getCarById(int id);                                //get car by its id

    // Update
    void saveCar(Car car);  //Update car state

    // Delete
    void deleteById(int id);    //delete car from cars list by its ID

}
