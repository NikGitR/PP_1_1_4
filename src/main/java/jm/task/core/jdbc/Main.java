package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("Гротов", "Дмитрий", (byte) 36);
        userService.saveUser("Евгений", "Грономов", (byte) 88);
        userService.saveUser("Александр", "Протонов", (byte) 59);
        userService.saveUser("Егоро", "Денис", (byte) 43);

        userService.removeUserById(8);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
