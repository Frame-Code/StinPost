package Persistence.spring;

import Persistence.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryJpa extends JpaRepository<PostEntity, Long> {
    @Query("select u.id from post u order by u.id desc")
    Long findLastId();
}
