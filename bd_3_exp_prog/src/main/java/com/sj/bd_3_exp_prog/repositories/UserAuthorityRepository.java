package com.sj.bd_3_exp_prog.repositories;

import com.sj.bd_3_exp_prog.entities.AppUserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthorityRepository extends JpaRepository<AppUserAuthority, Long> {
}
