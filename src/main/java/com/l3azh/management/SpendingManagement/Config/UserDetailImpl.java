package com.l3azh.management.SpendingManagement.Config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.l3azh.management.SpendingManagement.Entities.AccountEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserDetailImpl implements UserDetails {

    public enum AccCusRole {
        USER("USER"), ADMIN("ADMIN");

        private final String value;

        private AccCusRole(String theValue) {
            this.value = theValue;
        }

        public String getValue() {
            return value;
        }
    }

    private String email;
    private String firstName;
    private String lastName;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailImpl(String email, String firstName, String lastName, String password, Collection<? extends GrantedAuthority> authorities) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailImpl create(AccountEntity accountEntity, AccCusRole theRole) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(theRole.getValue()));
        return new UserDetailImpl(accountEntity.getEmail(), accountEntity.getFirstName(), accountEntity.getLastName(), accountEntity.getPassword(), authorityList);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        UserDetailImpl user = (UserDetailImpl) o;
        return Objects.equals(email, user.getEmail());
    }
}
