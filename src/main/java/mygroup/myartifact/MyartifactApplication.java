package mygroup.myartifact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @RestController
public class MyartifactApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyartifactApplication.class, args);
	}

	// @GetMapping
	// public String hello() {
	// 	return "1st project with JSB";
	// }

	// @GetMapping
	// public List<String> hello() {
	// 	return List.of("what is", "list of");
	// }

	// @GetMapping
	// public List<Student> hello() {
	// 	return List.of(
	// 		new Student(
	// 			1L,
	// 			"myname",
	// 			"mymail.mail",
	// 			LocalDate.of(2002, Month.JANUARY, 5),
	// 			21
	// 		)
	// 	);
	// }

}
