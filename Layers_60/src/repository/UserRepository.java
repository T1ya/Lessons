package repository;

/*
В любом репозитории обязательно должны быть CRUD - операции:
- Create
- Read
- Update
- Delete
 */

import model.User;

public interface UserRepository {
    // Create
    User addUser(String email, String password);

    // Read
    boolean isEmailExists(String email);
    User getUserByEmail(String email);

    // Update
    boolean updatePassword(String email, String newPassword);

    // Delete
    void deleteUser(String name);
}
