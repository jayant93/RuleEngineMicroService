package com.onecode.rule_engine.repository;

import com.onecode.rule_engine.model.OnecodeUser;
import com.onecode.rule_engine.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner,Long> {
    Partner findByOnecodeUserAndIsActive(OnecodeUser userId, Boolean isActive);
}
