package com.nash.examportal.model;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @Name("user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @Name("role_id")
    private Role role;
}
