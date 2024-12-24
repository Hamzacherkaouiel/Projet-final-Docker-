package projet.docker.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projet.docker.backend.DTO.DTOStudent;
import projet.docker.backend.Entities.StudentEntitie;
import projet.docker.backend.Services.ServiceStudent;

import java.util.List;

@RestController
public class ControllerStudent {
    @Autowired
    ServiceStudent SS;
    @RequestMapping("/Students")
    public ResponseEntity<List<DTOStudent>> getAllStudents(@RequestParam(value = "sort",defaultValue = "normal",required = false) String sort){
        List<DTOStudent> Students;
        if(sort.equals("normal")){
            Students=this.SS.getAllStudents();
        }
        else{
            Students=this.SS.getStudentsOrderByAverage();
        }
        return ResponseEntity.ok(Students);
    }

    @RequestMapping("/Students/{id}")
    public ResponseEntity<DTOStudent> getStudent(@PathVariable Long id){
        if(!this.SS.Exists(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(this.SS.getStudent(id));
    }
    @RequestMapping(method = RequestMethod.POST,value = "/Students")
    public ResponseEntity<DTOStudent> addStudent(@RequestBody DTOStudent student){
        this.SS.CreateStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/Students/{id}")
    public ResponseEntity<DTOStudent> updateStudent(@RequestBody DTOStudent student,@PathVariable Long id){
        if(!this.SS.Exists(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        this.SS.UpdateStudent(student,id);
        return ResponseEntity.ok(student);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/Students/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        if(!this.SS.Exists(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        this.SS.DeleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
