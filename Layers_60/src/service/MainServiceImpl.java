package service;

import model.Car;
import model.User;
import repository.CarRepository;
import repository.UserRepository;
import utils.MyList;
import utils.UserValidation;

public class MainServiceImpl implements MainService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private User activeUser;

    @Override
    public User getActiveUser() {
        return activeUser;
    }

    public MainServiceImpl(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(String email, String password) {
        /*
        Что должен делать сервис?
        1 - валидация входящих данных.
        2 - проверить уникальность данных (проще говоря, есть ли такой пользователь)
        3 - создаём пользователя и добавляем в хранилище
        4 - возвращаем созданного пользователя в слой view
        5 - а если не прошли проверки - возвращаем null
         */
        //1
        if (!UserValidation.isEmailValid(email)) {
            System.out.println("Error - invalid email!");
            return null;
        }
        if (!UserValidation.passwordIsValid(password)) {
            System.out.println("Error - invalid password!");
            return null;
        }
        //2
        if (userRepository.isEmailExists(email)){
            System.out.println("User with email "+ email+" already exist!");
            return  null;
        }
        //3. ЗА СОЗДАНИЕ ОБЪЕКТА ОТВЕЧАЕТ РЕПОЗИТОРИЙ!
        //   там должен создаться и сохраниться куда-то в базу объект, который мы вернём в слой view
        return userRepository.addUser(email, password);
    }

    @Override
    public boolean loginUser(String email, String password) {
        /*
        1 - получить из хранилища пользователя с таким емейл
        2 - проверить, совпадает ли пароль пользователя из БД с паролем из параметра
        3 - указать, что в системе есть активный пользователь
        4 - вернуть результат)
         */
        User user = userRepository.getUserByEmail(email);   //1
        if (user == null) return false; //2
        if (user.getPassword().equals(password)) {
            activeUser = user;  //3
            return true;    //4
        }

        return false;
    }

    @Override
    public void logoutUser() {
        activeUser = null;
    }

    @Override
    public boolean takeCar(int carId) {
        return false;
    }

    @Override
    public Car addCar(String model, int year, double price) {
        return null;
    }

    @Override
    public MyList<Car> getAllCars() {
        return null;
    }

    @Override
    public MyList<Car> getCarsByModel(String model) {
        return null;
    }

    @Override
    public MyList<Car> getFreeCar() {
        return null;
    }

    @Override
    public void deleteCarById(int id) {

    }
}
