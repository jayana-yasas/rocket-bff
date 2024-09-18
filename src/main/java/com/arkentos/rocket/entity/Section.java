//package com.arkentos.rocket.entity;
//
//
//import com.arkentos.rocket.enums.DeletedEnum;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "web_section")
//public class Section {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false)
//    private Integer sectionId;
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