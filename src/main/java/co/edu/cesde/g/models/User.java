package co.edu.cesde.g.models;

public class User {
    private Long userId;
    private String username;
    private String email;
    private String passwordHash;
    private Boolean status;
    private String createdAt;

    public User() {
    }

    public User(Long userId, String username, String email, String passwordHash, Boolean status, String createdAt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    @Override
    public String toString() {
        return "User {userId=" + userId +
                ", username=" + username +
                ", email=" + email +
                ", passwordHash=" + passwordHash +
                ", status=" + status +
                ", createdAt=" + createdAt +
                "}";
    }
}


