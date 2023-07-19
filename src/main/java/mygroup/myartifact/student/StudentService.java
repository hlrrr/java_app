package mygroup.myartifact.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service          
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
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
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email exists");
        }
        studentRepository.save(student);
        // System.out.println(student);
    }
    public void deleteStudent(Long studentID) {
        boolean exists = studentRepository.existsById(studentID);
        if (!exists){
            throw new IllegalStateException("student with id "+studentID+" does not exists");
        }
        studentRepository.deleteById(studentID);
    }
    @Transactional
    public void updateStudent(Long studentID, String name, String email) {
        Student student = studentRepository.findById(studentID).orElseThrow(() -> new IllegalStateException("student with id "+studentID+" does not exists"));
        
        if (name != null && name.length()>0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email exists");
            }
            student.setEmail(email);
        }
    }
}
