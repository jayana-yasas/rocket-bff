//package com.arkentos.rocket.entity;
//
//
//import com.arkentos.rocket.enums.DeletedEnum;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "web_page")
//public class Page {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false)
//    private Integer pageId;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column
//    private DeletedEnum deleted;
//
//    @Column
//    private Integer sort;
//
//}