package com.sj.bd_3_exp_prog.services;

import com.sj.bd_3_exp_prog.entities.AppUser;
import com.sj.bd_3_exp_prog.entities.AppUserAuthority;
import com.sj.bd_3_exp_prog.repositories.AppUserRepository;
import com.sj.bd_3_exp_prog.utilities.SQLScriptWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private UserAuthorityService userAuthorityService;

    @Autowired
    private SQLScriptWriter sqlScriptWriter;

    public void createUser(AppUser user) {

        String userScript = String.format(
            "INSERT INTO \"AppUser\"" +
            "(\"id\", \"name\", \"email\", \"password\")" +
            "VALUES (nextval('AppUserSeq'), '%s', '%s', '%s');\n",
            user.getUsername(), user.getEmail(), user.getPassword()
        );
        String userAuthorityScript = String.format(
            "INSERT INTO \"AppUserAuthority\"" +
            "(\"id\", \"authority\", \"user_id\")" +
            "VALUES (nextval('AppUserAuthoritySeq'), '%s', " +
            "(SELECT \"id\" FROM \"AppUser\" WHERE \"email\" = '%s'));\n",
            "ROLE_USER", user.getEmail()
        );
        try {
            sqlScriptWriter.writeResource("/sql/data-added.sql", userScript);
            sqlScriptWriter.writeResource("/sql/data-added.sql", userAuthorityScript);
        } catch (IOException e) {
            e.printStackTrace();
        }

        appUserRepository.save(user);
        userAuthorityService.saveAuthority(new AppUserAuthority(user,"ROLE_USER"));
    }

    public AppUser findByEmail(String email){
        return appUserRepository.findByEmail(email);
    };

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(email);
        if (appUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return appUser;
    }

}
