package com.sj.bd_3_exp_prog.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "`AppUserAuthority`")
public class AppUserAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AppUserAuthorityGenerator")
    @SequenceGenerator(name = "AppUserAuthorityGenerator", sequenceName = "`AppUserAuthoritySeq`", allocationSize = 1)
    @Column(name = "`id`")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`user_id`")
    private AppUser appUser;

    @Column(name = "`authority`", length = 50)
    private String authority;

    public AppUserAuthority() {}

    public AppUserAuthority(AppUser appUser, String authority) {
        this.appUser = appUser;
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
