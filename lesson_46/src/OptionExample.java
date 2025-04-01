import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionExample {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("John",101,35));
        users.add(new User("Jane",102,18));
    }

    public static void main(String[] args) {
        //Optional<T> - это враппер, который может содержать значение типа Т, а может не содержать))))
        //зачем? - уменьшить количество null pointer exeption
        //используется в основном как возвращаемый параметр из метода. НЕ как поле класса и НЕ как аргумент метожда

        Optional<User> optUser = getById(101);

        //мы можем проверить, есть ли в обёртке значение - boolean isPresent()
        if (optUser.isPresent()) {
            //get() "распапковывает" опционал и позволяет работать с его значением
            //get нельзя вызывать на пустом опционале - будет ошибка!
            User user  = optUser.get();
            System.out.println(user.getName());
            System.out.println(user.getAge());
        }
        else {
            System.out.println("Пользователь не найден");
        }
        System.out.println(optUser);

        //boolean isEmpty() вернёт true если опционал пуст
        //orElse(T defaultValue) - распакует объект из опционала, если его нет - вернёт значение по умолчанию
    }


    //Обёртка Optional указывает на необходимость проверки на null
    /*
    Как создать?
        1. Optional.of(value) - создаёт объект optional, содержащий значение.
           но если передать null - будет ошибка!
           для возврата пустого значения используем Optional.empty()

           либо использовать Option.ofNullable() - может вернуть либо оптионал, либо пустое значение
     */
    public static Optional<User> getById(int id) {
        //переберём всех пользователей и сравним их id
        for (User u:users) {
            if (u.getId() == id)
                return Optional.of(u);
        }
        return Optional.empty();
    }

    public static Optional<User> getById2(int id) {
        //переберём всех пользователей и сравним их id
        User result = null;
        for (User u:users) {
            if (u.getId() == id)
               result = u;
        }
        return Optional.ofNullable(result);
    }
}
