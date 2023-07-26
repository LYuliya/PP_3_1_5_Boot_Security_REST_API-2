package ru.kata.spring.boot_security.demo.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.services.UserService;
import javax.annotation.PostConstruct;
import java.util.Set;


@Component
public class DbInit {

    private final UserService userService;
    private final RoleRepository roleRepository;

    @Autowired
    public DbInit(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    private void postConstruct() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        User user = new User("user", "user", 20, "user@gmail.com", "user", Set.of(roleUser));
        User admin = new User("admin", "admin", 20, "admin@gmail.com", "admin", Set.of(roleAdmin, roleUser));
        User yuliya = new User("yuliya", "lyotina", 20, "lyolyoka@gmail.com", "lyolyoka", Set.of(roleUser, roleAdmin));
        userService.save(user);
        userService.save(admin);
        userService.save(yuliya);
    }
}
