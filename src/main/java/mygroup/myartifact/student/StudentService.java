package mygroup.myartifact.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service          
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    private StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository; 
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();

        // return List.of(
		// 	new Student(
		// 		1L,
		// 		"myname",
		// 		"mymail.mail",
        //         LocalDate.of(2002, Month.JANUARY, 5),
		// 		21
		// 	)
		// );  
	}

}
