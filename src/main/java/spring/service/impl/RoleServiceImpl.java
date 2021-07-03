package spring.service.impl;

import org.springframework.stereotype.Service;
import spring.dao.RoleDao;
import spring.exception.DataProcessingException;
import spring.model.Role;
import spring.model.RoleName;
import spring.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(RoleName roleName) {
        return roleDao.getRoleByName(roleName)
                .orElseThrow(() -> new DataProcessingException("Can't get role by name: "
                        + roleName));
    }
}
