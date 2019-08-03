package com.onecode.onecodeproject.repository;

import com.onecode.onecodeproject.model.Role;
import com.onecode.onecodeproject.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//role repository for the one code user (ORM between our Role entity class and database )
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(RoleName roleName);
}
