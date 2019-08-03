package com.onecode.onecodeproject.repository;

import com.onecode.onecodeproject.model.OnecodeUser;
import com.onecode.onecodeproject.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner,Long> {
    Partner findByOnecodeUserAndIsActive(OnecodeUser userId,Boolean isActive);
}
