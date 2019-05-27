package code.snippets.java.entity.bionetomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ilumer
 * Date : 2019-05-20
 * Time : 23:01
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}