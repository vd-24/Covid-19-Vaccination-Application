package com.covid19.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentAdminUserSessionRepo extends JpaRepository<CurrentAdminUserSession, Integer>{

	CurrentAdminUserSession findByUuid(String key);

	CurrentAdminUserSession findByAdminId(Integer adminId);

}