package StudentApi;

import com.example.demo.RestApiApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class StudentController {


    public static void main(String[] args) {
        SpringApplication.run(StudentController.class, args);
    }

}
