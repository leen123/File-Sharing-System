//package com.example.demo2.security;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.sun.istack.NotNull;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
////import javax.validation.constraints.NotEmpty;
//import java.util.Collection;
//import java.util.Date;
//

//@Document(collection = "users")
//public class AppUser implements UserDetails{
//
//    @Id
//    private String id;
//
//    @NotNull
//    private String email;
//
//    @NotNull
//    private String name;
//
//    @NotNull
//    @JsonIgnore
//    private String password;
//
//    private Date created;
//
//
//    public AppUser() {}
//
//    public AppUser(@NotNull String email, @NotNull String password, @NotNull String name) {
//        this.email = email;
//        this.password = password;
//        this.name = name;
//        this.created = new Date();
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public Date getCreated() {
//        return created;
//    }
//
//    public void setCreated(Date created) {
//        this.created = created;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//}
