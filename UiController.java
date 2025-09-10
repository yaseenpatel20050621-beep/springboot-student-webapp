package Student.Management.System.Student.Controller;

import Student.Management.System.Student.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {

    private final StudentService studentService;

    public UiController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/ui_allStudent")
    public String getAllStudent(Model model){
        model.addAttribute("students", studentService.getAllStudent());
        return "ui_allStudent";
    }

}
