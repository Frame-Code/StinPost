package Ports;

import ValueObjects.User.UserId;

public interface IUserRepository {
    boolean existsById(Long id);
}
