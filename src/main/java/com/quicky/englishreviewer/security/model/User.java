package com.quicky.englishreviewer.security.model;

import com.quicky.englishreviewer.data.model.Vocabulary;
import com.quicky.englishreviewer.data.model.VocabularyCollection;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "'user'")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String roles;
    private String email;
    private Date dateOfBirth;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<VocabularyCollection> collections = new HashSet<>();

    public void addCollections(VocabularyCollection... vocabularyCollection) {
        for (VocabularyCollection vol : vocabularyCollection) {
            collections.add(vol);
            vol.setUser(this);
        }
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public User(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User(String username, String password, String roles, String email, Date dateOfBirth) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
