package com.arkentos.rocket.entity;


import com.arkentos.rocket.enums.DeletedEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "web_user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long userRoleId;

    @Column(nullable = false)
    private String name;

    @Column
    private DeletedEnum deleted;

    @Column
    private Integer sort;

}