package Student.Management.System.Student.Mapping;

import Student.Management.System.Student.Dto.StudentDto;
import Student.Management.System.Student.Entity.StudentEntity;

public class StudentMapping {

    public static StudentDto studentDto(StudentEntity entity){
        return new StudentDto(entity.getId(),
                entity.getName(),
                entity.getDiv(),
                entity.getRollNo(),
                entity.getEmails());
    }

    public static StudentEntity studentEntity(StudentDto studentDto){
        return new StudentEntity(studentDto.getId(),
                studentDto.getName(),
                studentDto.getDiv(),
                studentDto.getRollNo(),
                studentDto.getEmails());
    }
}
