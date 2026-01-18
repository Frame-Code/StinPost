package Persistence.entities;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class BaseEntity {

    @NotBlank(message = "La fecha de creación es obligatorio")
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    @NotBlank(message = "El id del usuario creador es obligatorio")
    @Column(name = "idUserCreator", nullable = false)
    private Long idUserCreator;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "idUserUpdater")
    private Long idUserUpdater;

    @Column(name = "isActive", nullable = false)
    private boolean isActive;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.isActive = true;
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
