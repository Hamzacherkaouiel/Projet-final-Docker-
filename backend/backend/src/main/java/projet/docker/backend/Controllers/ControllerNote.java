package projet.docker.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projet.docker.backend.DTO.DTONote;
import projet.docker.backend.Services.NoteService;

import java.util.List;

@RestController
public class ControllerNote {
    @Autowired
    NoteService NS;
    @RequestMapping("/Students/{id}/Notes")
    public ResponseEntity<List<DTONote>> getNotes(@PathVariable Long id,@RequestParam(value="sort",defaultValue = "normal") String sort){
        List<DTONote> Notes;
        if(sort.equals("normal")){
            return ResponseEntity.ok(this.NS.getNotes(id));

        }
        return ResponseEntity.ok(this.NS.getNotesSorted(id));
    }
    @RequestMapping("/Students/{id}/Notes/{idNote}")
    public ResponseEntity<DTONote> getSingleNote(@PathVariable("id") Long id1,@PathVariable("idNote") Long id2){
        if(!this.NS.Exits(id2)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(this.NS.getSingleNote(id2,id1));
    }
    @RequestMapping(method = RequestMethod.POST,value = "/Students/{id}/Notes")
    public  ResponseEntity<DTONote> CreateNote(@RequestBody DTONote Note, @PathVariable Long id){
        this.NS.CreateNote(Note,id);
        return ResponseEntity.status(HttpStatus.CREATED).body(Note);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/Students/{id}/Notes/{idNote}")
    public ResponseEntity<DTONote> UpdateNote(@RequestBody DTONote note,@PathVariable("id")Long id1,@PathVariable("idNote") Long  id2){
        if(!this.NS.Exits(id2)){
            return ResponseEntity.notFound().build();
        }
        this.NS.UpdateNote(note,id2,id1);
        return ResponseEntity.ok(note);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/Students/{id}/Notes/{idnote}")
    public ResponseEntity DeleteNote(@PathVariable("idnote") Long id){
        if(!this.NS.Exits(id)){
            return ResponseEntity.notFound().build();
        }
        this.NS.DeleteNote(id);
        return ResponseEntity.noContent().build();
    }
}
