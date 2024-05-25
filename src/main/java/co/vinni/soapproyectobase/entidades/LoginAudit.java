package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LOGIN_AUDIT")
public class LoginAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "login_time")
    private LocalDateTime loginTime;

    public LoginAudit() {
    }

    public LoginAudit(String username, LocalDateTime loginTime) {
        this.username = username;
        this.loginTime = loginTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "LoginAudit{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }
}
