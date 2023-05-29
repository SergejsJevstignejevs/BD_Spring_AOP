package com.sj.bd_3_exp_prog.repositories;

import com.sj.bd_3_exp_prog.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);
    AppUser findAppUserById(Long id);

}
