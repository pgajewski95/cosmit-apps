package com.akadamie.cosmitapp.commons.swagger.security;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")

    private Integer roleId;

    private String role;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<UserApp> users = new HashSet<>();


}
