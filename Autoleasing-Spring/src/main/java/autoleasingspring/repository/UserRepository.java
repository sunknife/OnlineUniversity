package autoleasingspring.repository;

import autoleasingspring.entity.Status;
import autoleasingspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);

    @Modifying
    @Query("update User u set u.status = ?1 where u.id = ?2")
    void updateUserStatusById(Status status, Long id);
}
