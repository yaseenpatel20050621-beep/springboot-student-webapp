package Student.Management.System.Student.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private long id;
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "div is required")
    private String div;
    @NotBlank(message = "roll_no is required")
    private String rollNo;
    @NotBlank(message = "email is required")
    @Email(message = "invalid email format")
    private String emails;
}
