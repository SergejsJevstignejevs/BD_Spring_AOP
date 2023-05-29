package com.sj.bd_3_exp_prog.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "`AppUser`")
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AppUserGenerator")
    @SequenceGenerator(name = "AppUserGenerator", sequenceName = "`AppUserSeq`", allocationSize = 1)
    @Column(name = "`id`")
    private Long id;
    @NotEmpty(message = "Username is required!")
    @Size(min = 2, max = 30, message = "Username must be >=2 and <=30 in size!")
    @Column(name = "`name`")
    private String name;
    @NotEmpty(message = "Email is required!")
    @Email(message = "Invalid email format!")
    @Column(name = "`email`")
    private String email;

    @NotEmpty(message = "Password is required!")
    @Size(min = 8, message = "Password must be >=8 in size!")
    @Column(name = "`password`")
    private String password;

    @Column(name = "`balance`")
    private Float balance = 100F;

    @Column(name = "`enabled`")
    private boolean enabled = true;

    @Column(name = "`account_non_expired`")
    private boolean accountNonExpired = true;

    @Column(name = "`credentials_non_expired`")
    private boolean credentialsNonExpired = true;

    @Column(name = "`account_non_locked`")
    private boolean accountNonLocked = true;

    @OneToMany(
            mappedBy = "appUser",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<AppUserAuthority> appUserAuthorities = new HashSet<>();

    public AppUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    //UserDetails methods

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (AppUserAuthority appUserAuthority : appUserAuthorities) {
            authorities.add(new SimpleGrantedAuthority(appUserAuthority.getAuthority()));
        }
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }
}
