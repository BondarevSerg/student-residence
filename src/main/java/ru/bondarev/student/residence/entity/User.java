package ru.bondarev.student.residence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class User {

    /**
     * id пользователя
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Логин
     */
    @Column(name = "login")
    private String login;

    /**
     * пароль
     */
    @Column(name = "password")
    private String password;

    /**
     * роль
     */
    @Column(name = "role")
    private String role;



//    @ManyToMany(fetch=FetchType.EAGER)
//    @JoinTable(name = "user_roles",joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
//    private Set<Role> roles;
}
