package com.sj.bd_3_exp_prog.services;

import com.sj.bd_3_exp_prog.entities.AppUserAuthority;
import com.sj.bd_3_exp_prog.repositories.UserAuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthorityService {

    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    public void saveAuthority(AppUserAuthority authority){

        userAuthorityRepository.save(authority);

    };

}
