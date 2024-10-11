package uniCircle.backend.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role roles;

    @Column(nullable = false)
    private String password;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "last_seen")
    private LocalDateTime lastSeen;

    @OneToMany(mappedBy = "user")
    private List<CircleUser> circleUsers;

    @Builder
    public User(Long userId, String name, String nickname, String email, Role roles, String password, LocalDateTime createdAt, LocalDateTime lastSeen) {
        this.userId = userId;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.createdAt = createdAt;
        this.lastSeen = lastSeen;
    }

    public User() {
    }

}