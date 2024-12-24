package projet.docker.backend.Mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import projet.docker.backend.DTO.DTONote;
import projet.docker.backend.DTO.DTOStudent;
import projet.docker.backend.Entities.NoteEntity;
import projet.docker.backend.Entities.StudentEntitie;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {
    @Autowired
    NoteMapper NM;
    public StudentEntitie MappedToStudent(DTOStudent student){
        StudentEntitie SE=new StudentEntitie();
        SE.setId(student.getId_student());
        SE.setDate(student.getDate());
        SE.setName(student.getNom());
       /* if(student.getNotes()!=null){
            List<NoteEntity> Notes=new ArrayList<>();
            for(int i=0;i<student.getNotes().size();i++){
                Notes.add(this.NM.MappedToNote(student.getNotes().get(i)));
            }
            SE.setNotes(Notes);
        }*/

        return SE;
    }
    public DTOStudent MappedToDAOStudent(StudentEntitie Student){
        DTOStudent DS=new DTOStudent();
        DS.setId_student(Student.getId());
        DS.setDate(Student.getDate());
        DS.setNom(Student.getName());
        /*if(Student.getNotes()!=null){
            List<DTONote> Notes=new ArrayList<>();
            for(int i=0;i<Student.getNotes().size();i++){
                Notes.add(this.NM.MappedToDAONote(Student.getNotes().get(i)));
            }
            DS.setNotes(Notes);
        }*/

        return DS;
    }
}
