package bg.tarataiki.tarataiki.repostiroy;

import bg.tarataiki.tarataiki.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
