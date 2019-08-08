package com.onecode.rule_engine.repository;

import com.onecode.rule_engine.model.OnecodeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//user repository for the one code user (ORM between our entity class and database )
@Repository
public interface UserRepository extends JpaRepository<OnecodeUser, Long> {

    OnecodeUser findByPhonenumberAndIsVerified(String phonenumber,Boolean IsActive);

    OnecodeUser findByOnecodeAndIsVerified(String onecode,Boolean isActive);


    void deleteOnecodeUserById(Long userId);

    OnecodeUser findByIdAndAndIsVerified(Long userid, Boolean isVerified);

}

