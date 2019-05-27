package code.snippets.java.entity.bionetomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ilumer
 * Date : 2019-05-20
 * Time : 22:59
 */
@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
}