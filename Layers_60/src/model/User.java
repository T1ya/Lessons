package model;

import utils.MyArrayList;
import utils.MyList;

import java.util.Objects;

public class User {
    private String email;
    private String password;
    private final MyList<Car> userCars;

    public Role getRole() {
        return role;
    }

    private Role role;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        userCars = new MyArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MyList<Car> getUserCars() {
        return userCars;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email +
                "cars=" + userCars.size()
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }

    public void setRole(Role role) {
    }
}
