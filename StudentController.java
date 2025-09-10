package Student.Management.System.Student.Controller;

import Student.Management.System.Student.Dto.StudentDto;
import Student.Management.System.Student.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping
    public ResponseEntity<StudentDto> postStudent(@Valid @RequestBody StudentDto studentDto){
      StudentDto studentDto1=  studentService.postStudent(studentDto);
      return new ResponseEntity<>(studentDto1 , HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") long studentId){
        StudentDto studentDto= studentService.getStudent(studentId);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping("/allStudent")
    public ResponseEntity<List<StudentDto>> getAllStudent(){
     List<StudentDto> studentDtos= studentService.getAllStudent();
    return ResponseEntity.ok(studentDtos);

    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
      studentService.delete(id);
       return ResponseEntity.ok("Delete Successfully");
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentDto> putDetails(@PathVariable("id")Long id,
                                                 @RequestBody StudentDto studentDto){
      StudentDto studentDto1=  studentService.postStudent(id,studentDto);
      return ResponseEntity.ok(studentDto1);
    }
}
