package code.snippets.java.entity.unonetomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ilumer
 * Date : 2019-05-20
 * Time : 23:02
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}