package net.javaguides.springbootrestapi.controllers;

import net.javaguides.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
//http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(
                 1,
         "Tanya",
        "Shree"
    );
        return student;
    }
    @GetMapping("/students")
public List<Student> getStudents(){
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"Tanya","Shree"));
        students.add(new Student(2,"Raj","Shree"));
        students.add(new Student(3,"Anand","Rajan"));
        return students;
}
// Spring Boot Rest API Path Variable
    //{}id - URI Template variable
    //http://localhost:8080/students/1
    @GetMapping("/students/{id}")
    public Student studentPathVariable(@PathVariable int id){
       return new Student(id, getStudent().getFirstName(), getStudent().getLastName());
        //return new Student(getStudent());

    }

    //passing multiple values to PathVariable
    @GetMapping("/students/{id}/{first-name}/{last-name}")
   public Student StudentPathVariable(@PathVariable int id ,@PathVariable("first-name") String firstName ,
                          @PathVariable("last-name") String lastName) {
        return new Student(id, firstName, lastName) ;
   }

   //Spring Boot Rest API with @RequestParamm
    //http://localhost:8080/student/query?id=1&firstName=Tanya&lastName=shree
    @GetMapping("/student/query")
    public Student studentRequestVariable(@RequestParam int id ,
                                          @RequestParam String firstName,@RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }
    @PostMapping ("/createStudent")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
    //Spring Boot REST API that handles the HTTP PUT Request - updating existing resource

@PutMapping("/students/{id}/update")
    public Student updateStudent(@RequestBody Student student ,@PathVariable("id") int studentId){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
    //Spring Boot REST API that handles the HTTP DELETE Request - DELETing existing resource
    @DeleteMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return "Student Deleted Successfully";
    }
}
