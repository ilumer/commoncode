import code.snippets.java.SpringDataJpaApplication;
import code.snippets.java.entity.bionetomany.House;
import code.snippets.java.entity.bionetomany.Person;
import code.snippets.java.entity.bionetomany.PersonRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilumer
 * Date : 2019-05-20
 * Time : 23:18
 */
@SpringBootTest(classes = SpringDataJpaApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BidirectionalTest {
	@Autowired
	private PersonRepository personRepository;

	@Test
	public void testDSavePerson() {
		House leftHouse = new House("left");
		House rightHouse = new House("right");
		List<House> houses = new ArrayList<>();
		houses.add(leftHouse);
		houses.add(rightHouse);
		Person person = new Person("ilumer", 10, houses);
		houses.forEach(i->i.setPerson(person));
		personRepository.save(person);
		//Hibernate: insert into person (age, name) values (?, ?)
		//Hibernate: insert into house (name, person_id) values (?, ?)
		//Hibernate: insert into house (name, person_id) values (?, ?)
	}

	@Test
	public void testDeletePerson() {
		List<Person> all = personRepository.findAll();
		if (all != null && all.size() > 0) {
			Person person = all.get(0);
			personRepository.delete(person.getId());
			//Hibernate: select person0_.id as id1_3_0_, person0_.age as age2_3_0_, person0_.name as name3_3_0_ from person person0_ where person0_.id=?
			//Hibernate: select housecolle0_.person_id as person_i3_2_0_, housecolle0_.id as id1_2_0_, housecolle0_.id as id1_2_1_, housecolle0_.name as name2_2_1_, housecolle0_.person_id as person_i3_2_1_ from house housecolle0_ where housecolle0_.person_id=?
			//Hibernate: delete from house where id=?
			//Hibernate: delete from house where id=?
			//Hibernate: delete from person where id=?
		}
	}
}
