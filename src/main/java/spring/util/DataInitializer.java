package spring.util;

import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import spring.model.Role;
import spring.model.RoleName;
import spring.model.User;
import spring.service.RoleService;
import spring.service.UserService;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setName(RoleName.ROLE_ADMIN);
        roleService.add(adminRole);

        Role userRole = new Role();
        userRole.setName(RoleName.ROLE_USER);
        roleService.add(userRole);

        User bob = new User();
        bob.setEmail("bob@i.ua");
        bob.setPassword("123");
        bob.setRoles(Set.of(adminRole));
        userService.add(bob);

        User alice = new User();
        alice.setEmail("alice@i.ua");
        alice.setPassword("1234");
        alice.setRoles(Set.of(userRole));
        userService.add(alice);
    }
}
