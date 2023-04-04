package web.service;

import web.models.Users;


import java.util.List;


public interface UsersService {
    List<Users> show();

    void save(Users person);

    Users showid(int id);

    void update(int id, Users userUpdate);

    void delete(int id);

}
