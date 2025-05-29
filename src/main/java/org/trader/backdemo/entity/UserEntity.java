package org.trader.backdemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "app_user")

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    private String email;

    private String name;

    private String password;

    @OneToMany(mappedBy = "user" , fetch = FetchType.LAZY)
    private Set<AgentEntity> agents = new HashSet<>();
}
