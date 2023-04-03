package web.repository;

import web.models.Users;

import java.util.List;

public interface UserRepository {

    List<Users> getAllUsers();

    void createUser(Users user);

    void updateUser(Users user);

    Users readUser(int id);

    Users deleteUser(int id);
}
