package com.nash.examportal.model;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USER_ROLES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @Name("USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @Name("ROLE_ID")
    private Role role;
}
