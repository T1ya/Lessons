package repository;

import model.Role;
import model.User;
import utils.MyArrayList;

public class UserRepositoryImpl implements UserRepository{
    //храним список юзеров в переменной
    private final MyArrayList<User> users;
    private Role role;

    public UserRepositoryImpl() {
        users = new MyArrayList<>();
        addUsers();
    }

    private void addUsers() {
        User admin = new User("1", "1");
        admin.setRole(Role.ADMIN);
        User user = new User("2", "2");
        user.setRole(Role.USER);
        users.addAll(admin, user);
    }

    @Override
    public User addUser(String email, String password) {
        User user = new User(email,password);
        users.add(user);
        return user;
    }

    @Override
    public boolean isEmailExists(String email) {
        for (User u: users)  {
            if (u.getEmail().equals(email)) return true;
        }
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        for (User u: users)  {
            if (u.getEmail().equals(email)) return u;
        }
        return null;
    }

    @Override
    public boolean updatePassword(String email, String newPassword) {
        for (User u: users)  {
            if (u.getEmail().equals(email)) {
                u.setPassword(newPassword);
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteUser(String name) {
        for(User u: users) {
            if (u.getEmail().equals(name)) {
                users.remove(u);
            }
        }
    }
}
