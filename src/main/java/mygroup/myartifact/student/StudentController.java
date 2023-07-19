package mygroup.myartifact.student;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
    
    private final StudentService studentService;
    
    // @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
// autowired 불필요?

	@GetMapping
	public List<Student> getStudents() {
        return studentService.getStudents();
	}

}
