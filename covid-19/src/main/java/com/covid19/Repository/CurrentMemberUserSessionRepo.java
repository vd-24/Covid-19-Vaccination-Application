package com.covid19.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentMemberUserSessionRepo extends JpaRepository<CurrentMemberUserSession, Integer>{

	CurrentMemberUserSession findByUuid(String key);

	CurrentMemberUserSession findByMemberId(Integer memberId);

}