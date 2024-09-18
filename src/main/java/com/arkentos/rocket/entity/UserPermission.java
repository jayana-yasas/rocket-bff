package com.arkentos.rocket.entity;


import com.arkentos.rocket.enums.DeletedEnum;
import com.arkentos.rocket.enums.EnabledEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "web_user_permission", uniqueConstraints={
        @UniqueConstraint(columnNames = {"user_role_id", "task_id"})
})

public class UserPermission extends BaseEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private Task task;

    @Column
    private EnabledEnum enabled;

    @Column
    private DeletedEnum deleted;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "section_id")
//    private Section section;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "page_id")
//    private Page page;


}