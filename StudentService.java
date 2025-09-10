package Student.Management.System.Student.Service;

import Student.Management.System.Student.Dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto postStudent(StudentDto studentDto);

    StudentDto getStudent(long StudentId);

    List<StudentDto> getAllStudent();

    StudentDto delete(long id);


    StudentDto postStudent(Long id, StudentDto studentDto);
}
