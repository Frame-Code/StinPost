package Entities;

import Enums.Roles;
import ValueObjects.User.*;
import java.util.Objects;

public class User {
    private final UserId userId;
    private final UserDni dni;
    private final UserName firstName;
    private final UserName lastName;
    private final UserEmail email;
    private UserPhone phone;
    private final UserBirthDate birthDate;
    private UserUsername username;
    private final UserPassword password;
    private UserBio bio;
    private final Roles role;

    private User(UserId userId, UserDni dni, UserName firstName, UserName lastName, UserEmail email, UserPhone phone, UserBirthDate birthDate, UserUsername username, UserPassword password, UserBio bio, Roles role) {
        if(userId == null) throw new IllegalArgumentException("El id del usuario no puede ser nulo");
        if(dni == null) throw new IllegalArgumentException("El dni del usuario no puede ser nulo");
        if(firstName == null) throw new IllegalArgumentException("Los nombres del usuario no puede ser nulo");
        if(lastName == null) throw new IllegalArgumentException("Los apellidos del usuario no puede ser nulo");
        if(email == null) throw new IllegalArgumentException("El email del usuario no puede ser nulo");
        if(phone == null) throw new IllegalArgumentException("El teléfono del usuario no puede ser nulo");
        if(birthDate == null) throw new IllegalArgumentException("La fecha de nacimiento del usuario no puede ser nulo");
        if(username == null) throw new IllegalArgumentException("El username del usuario no puede ser nulo");
        if(password == null) throw new IllegalArgumentException("El password del usuario no puede ser nulo");
        if(role == null) throw new IllegalArgumentException("El rol del usuario no puede ser nulo");

        this.userId = userId;
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.username = username;
        this.password = password;
        this.bio = bio;
        this.role = role;
    }

    public static User create(UserId userId, UserDni dni, UserName firstName, UserName lastName, UserEmail email, UserPhone phone, UserBirthDate birthDate, UserUsername username, UserPassword password, UserBio bio, Roles role) {
        return new User(userId, dni, firstName, lastName, email, phone, birthDate, username, password, bio, role);
    }

    public static User restore(UserId userId, UserDni dni, UserName firstName, UserName lastName, UserEmail email, UserPhone phone, UserBirthDate birthDate, UserUsername username, UserPassword password, UserBio bio, Roles role) {
        return new User(userId, dni, firstName, lastName, email, phone, birthDate, username, password, bio, role);
    }

    public String getFullName() {
        return firstName.value() + " " + lastName.value();
    }

    public void editPhone(UserPhone phone) {
        if(phone == null) {
            throw new IllegalArgumentException("El teléfono del usuario no puede ser nulo");
        }
        this.phone = phone;
    }

    public void editUsername(UserUsername username) {
        if(username == null) {
            throw new IllegalArgumentException("El username del usuario no puede ser nulo");
        }
        this.username = username;
    }

    public void editBio(UserBio bio) {
        this.bio = bio;
    }

    public UserId getUserId() {
        return userId;
    }

    public UserDni getDni() {
        return dni;
    }

    public UserName getFirstName() {
        return firstName;
    }

    public UserName getLastName() {
        return lastName;
    }

    public UserEmail getEmail() {
        return email;
    }

    public UserPhone getPhone() {
        return phone;
    }

    public UserBirthDate getBirthDate() {
        return birthDate;
    }

    public UserUsername getUsername() {
        return username;
    }

    public UserPassword getPassword() {
        return password;
    }

    public UserBio getBio() {
        return bio;
    }

    public Roles getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId);
    }
}
