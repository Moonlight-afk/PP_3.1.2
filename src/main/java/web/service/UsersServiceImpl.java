package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.models.Users;
import web.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    private final UserRepository userRepository;

    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> show() {
        return userRepository.getAllUsers();
    }

    public Users showid(int id) {
        return userRepository.readUser(id);
    }

    public void save(Users person) {
        userRepository.createUser(person);
    }

    public void update(int id, Users userUpdate) {
        userRepository.updateUser(userUpdate);
    }

    public void delete(int id) {
        userRepository.deleteUser(id);
    }
}
