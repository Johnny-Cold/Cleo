package sparkles.princess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sparkles.princess.model.entity.cleo.CleoState;

public interface CleoStateRepository extends JpaRepository<CleoState, Long> {
    @Query("select c from CleoState c where max(c.lastActive)")
    CleoState getLastState();
}
