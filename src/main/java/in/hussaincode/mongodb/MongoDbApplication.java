package in.hussaincode.mongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class MongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbApplication.class, args);
	}

	CommandLineRunner runner(StudentRepository studentRepository){
		return args ->{
			Address address = new Address("India","Bangalore","848125");
			//noinspection UnresolvedClassReferenceRepair
			Student student = new Student(
					"MS",
					"Hussain",
					"mshussain@gmail.com",
					Gender.MALE,
					address,
					List.of("Compute Science"),
					BigDecimal.TEN,
					ZonedDateTime.now()
			);
			studentRepository.insert(student);
		};
	}
}
