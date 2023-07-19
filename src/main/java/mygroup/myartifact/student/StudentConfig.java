package mygroup.myartifact.student;

import static java.time.Month.JANUARY;
import static java.util.List.of;

import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(
        StudentRepository repository) {
            return args-> {
				Student myname = new Student(
					"myname",
					"mymail@mail.com",
					LocalDate.of(2002, JANUARY, 5),
					21
				);  

				Student yourname = new Student(
					"yourname",
					"yourname@mail.com",
					LocalDate.of(2001, JANUARY, 5),
					22
				);  	 

				repository.saveAll(
					of(myname, yourname)
				);
		};
	}
}
