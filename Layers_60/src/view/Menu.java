package view;

import model.User;
import service.MainService;

import java.util.Scanner;

/*
должен иметь возможность взаимодействовать с сервисным слоем
 */
public class Menu {
    private final MainService service;  //должен иметь возможность взаимодействовать с сервисным слоем
    private final Scanner scanner = new Scanner(System.in); //и с пользователем

    public Menu(MainService service) {
        this.service = service;
    }

    public void start() {
        showMenu();
    }

    private void showMenu() {
        while (true) {
            // меню для пользователя - 1,2,3,...0
            System.out.println("Main page:");
            System.out.println("1. Cars menu");
            System.out.println("2. User menu");
            System.out.println("3. Admin menu");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Exit from app");
                System.exit(0);
            }
            showSubMenu(choice);
        }
    }

    private void showSubMenu(int choice) {
        switch (choice) {
            case 1:
                //TODO - show car menu
                break;
            case 2:
                //TODO - show user menu
                showUserMenu();
                break;
            case 3:
                //TODO - show admin menu
                break;
            default:
                System.out.println("Please choose correct menu");
                waitRead();
        }
    }

    private void showUserMenu() {
        while (true) {
            System.out.println("User menu:");
            System.out.println("1. Login");
            System.out.println("2. Registration");
            System.out.println("3. Log out");
            System.out.println("3. Exit to main menu");

            System.out.println("\nPlease select menu");

            int input = scanner.nextInt();
            scanner.nextLine();

            if (input == 0) break;

            handleUserMenu(input);
        }
    }

    private void waitRead() {
        System.out.println("Press Enter to proceed");
        scanner.nextLine();
    }
    // должен передать полученные данные в сервисный слой!
    void handleUserMenu(int input) {
        switch (input) {
            case 1:
                /*
                Авторизация
                1 - получить данные
                2 - передать данные в сервисный слой
                3 - получить ответ от сервисного слоя - прошёл логин или нет
                4 - передать ответ пользователю
                 */
                break;
            case 2:
                /*
                Регистрация
                1 - получить данные
                2 - передать данные в сервисный слой
                3 - получить ответ от сервисного слоя - зарегистрировался юзер или нет
                4 - передать ответ пользователю
                 */
                System.out.println("регистрация нового пользователя");
                System.out.println("Введите email");
                String email = scanner.nextLine();
                System.out.println("Введите пароль");
                String password = scanner.nextLine();

                User user = service.registerUser(email, password);
                if (user == null) {
                    System.out.println("Не удалось зарегистрировать пользователя");
                }
                else {
                    System.out.println("Регистрация пользователя завершена");
                    waitRead();
                }
                break;
        }
    }

}
