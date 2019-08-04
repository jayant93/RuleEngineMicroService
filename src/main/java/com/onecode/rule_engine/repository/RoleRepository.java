package com.onecode.rule_engine.repository;

import com.onecode.rule_engine.model.Role;
import com.onecode.rule_engine.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//role repository for the one code user (ORM between our Role entity class and database )
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(RoleName roleName);
}
