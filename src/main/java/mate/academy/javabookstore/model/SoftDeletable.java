package mate.academy.javabookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class SoftDeletable {
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;
}
