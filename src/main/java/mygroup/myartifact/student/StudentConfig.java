package mygroup.myartifact.student;

import static java.time.Month.JANUARY;

import java.time.LocalDate;
import java.util.List;

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
					LocalDate.of(2000, JANUARY, 5)
					// 21
				);  

				Student yourname = new Student(
					"yourname",
					"yourname@mail.com",
					LocalDate.of(1988, JANUARY, 5)
					// 22
				);  	 

				repository.saveAll(
					List.of(myname, yourname)
				);
		};
	}
}
