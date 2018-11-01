package com.clinicapp.users.impl.command.datatypes.entity;

import com.clinicapp.libs.constants.Role;
import com.clinicapp.libs.constants.TableDefs;
import com.clinicapp.libs.entity.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = TableDefs.ColumnNames.User.ROLE)
@Table(name = TableDefs.TablesNames.USERS, schema = TableDefs.SCHEMA_NAME)
public abstract class User extends BaseEntity {

    @Column(name = TableDefs.ColumnNames.User.FIRST_NAME)
    private String firstName;

    @Column(name = TableDefs.ColumnNames.User.FAMILY_NAME)
    private String familyName;

    @Column(name = TableDefs.ColumnNames.User.LOGIN)
    private String login;

    @Column(name = TableDefs.ColumnNames.User.PASSWORD)
    private String password;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = TableDefs.ColumnNames.User.ROLE, insertable = false, updatable = false)
    private Role role;

    @Column(name = TableDefs.ColumnNames.User.EMAIL)
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> permissions = new HashSet<String>();

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
