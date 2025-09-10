package Student.Management.System.Student.Service.Imls;

import Student.Management.System.Student.Dto.StudentDto;
import Student.Management.System.Student.Entity.StudentEntity;
import Student.Management.System.Student.Exception.ResourceNotFound;
import Student.Management.System.Student.Mapping.StudentMapping;
import Student.Management.System.Student.Repository.StudentRepository;
import Student.Management.System.Student.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImls implements StudentService {

    private final StudentRepository studentRepositoty;

    public StudentServiceImls(StudentRepository studentRepositoty) {
        this.studentRepositoty = studentRepositoty;
    }


    @Override
    public StudentDto postStudent(StudentDto studentDto) {
       StudentEntity entity= StudentMapping.studentEntity(studentDto);
        StudentEntity entity1=studentRepositoty.save(entity);
        return StudentMapping.studentDto(entity1);
    }

    @Override
    public StudentDto getStudent(long StudentId) {
        StudentEntity entity=studentRepositoty.findById(StudentId).orElseThrow(()->new ResourceNotFound("not found "+StudentId));
        return StudentMapping.studentDto(entity);
    }

    @Override
    public List<StudentDto> getAllStudent() {
      List<StudentEntity> entity= studentRepositoty.findAll();
      return entity.stream().map((StudentEntity)->StudentMapping.studentDto(StudentEntity)).collect(Collectors.toList());
    }

    @Override
    public StudentDto delete(long id) {
       StudentEntity studentEntity= studentRepositoty.findById(id).orElseThrow(()-> new ResourceNotFound("not found "+id));
        studentRepositoty.delete(studentEntity);
        return null;
    }

    @Override
    public StudentDto postStudent(Long id, StudentDto studentDto) {
        StudentEntity studentEntity=  studentRepositoty.findById(id).orElseThrow(()-> new ResourceNotFound("not found"+id));

        studentEntity.setName(studentDto.getName());
        studentEntity.setDiv(studentDto.getDiv());
        studentEntity.setRollNo(studentDto.getRollNo());
        studentEntity.setEmails(studentDto.getEmails());

        StudentEntity student= studentRepositoty.save(studentEntity);
        return StudentMapping.studentDto(student);
    }

}
