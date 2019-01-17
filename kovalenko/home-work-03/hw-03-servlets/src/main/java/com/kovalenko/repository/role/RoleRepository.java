package com.kovalenko.repository.role;

import com.kovalenko.entity.user.role.Role;
import com.kovalenko.entity.user.role.RoleType;

public interface RoleRepository {

    Role findByRoleType(RoleType roleType);
}
