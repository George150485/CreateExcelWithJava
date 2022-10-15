package repository;

import model.AccessModifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModifierRepo extends JpaRepository<AccessModifier, Long > {
}
