import code.snippets.java.SpringDataJpaApplication;
import code.snippets.java.entity.bionetomany.Person;
import code.snippets.java.entity.unonetomany.Car;
import code.snippets.java.entity.unonetomany.CarRepository;
import code.snippets.java.entity.unonetomany.Wheel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilumer
 * Date : 2019-05-20
 * Time : 23:19
 */
@SpringBootTest(classes = SpringDataJpaApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UnidirectionalTest {
	@Autowired
	private CarRepository carRepository;

	@Test
	public void testDSaveCar() {
		Wheel wheel = new Wheel("left");
		Wheel wheel2 = new Wheel("right");
		List<Wheel> wheels = new ArrayList<>();
		wheels.add(wheel);
		wheels.add(wheel2);
		Car car = new Car("test car insert sql", wheels);
		carRepository.save(car);
		//Hibernate: insert into car (name) values (?)
		//Hibernate: insert into wheel (name) values (?)
		//Hibernate: insert into wheel (name) values (?)
		//Hibernate: insert into car_wheels (car_id, wheels_id) values (?, ?)
		//Hibernate: insert into car_wheels (car_id, wheels_id) values (?, ?)
	}

	@Test
	public void testDeleteCar() {
		List<Car> all = carRepository.findAll();
		if (all != null && all.size() > 0) {
			Car car = all.get(0);
			carRepository.delete(car);
		}
		//Hibernate: select car0_.id as id1_0_1_, car0_.name as name2_0_1_, wheels1_.car_id as car_id1_1_3_, wheel2_.id as wheels_i2_1_3_, wheel2_.id as id1_4_0_, wheel2_.name as name2_4_0_ from car car0_ left outer join car_wheels wheels1_ on car0_.id=wheels1_.car_id left outer join wheel wheel2_ on wheels1_.wheels_id=wheel2_.id where car0_.id=?
		//Hibernate: delete from car_wheels where car_id=?
		//Hibernate: delete from wheel where id=?
		//Hibernate: delete from wheel where id=?
		//Hibernate: delete from car where id=?
	}
}
