package com.arkentos.rocket.entity;


import com.arkentos.rocket.enums.DeletedEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "web_task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long taskId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String eventName;

    @Column
    private DeletedEnum deleted;

    @Column
    private Integer sort;

}