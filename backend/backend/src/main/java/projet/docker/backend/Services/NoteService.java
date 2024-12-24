package projet.docker.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.docker.backend.DTO.DTONote;
import projet.docker.backend.Entities.NoteEntity;
import projet.docker.backend.Entities.StudentEntitie;
import projet.docker.backend.Mappers.NoteMapper;
import projet.docker.backend.RepositoryInterfaces.RepositoryNote;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    RepositoryNote RN;
    @Autowired
    NoteMapper NM;
    public List<DTONote> getNotes(Long id){
        List<NoteEntity> Notes=this.RN.findByStudent(id);
        List<DTONote> NotesDTO=new ArrayList<>();
        for(int i=0;i<Notes.size();i++){
            NotesDTO.add(this.NM.MappedToDAONote(Notes.get(i)));
        }
        return NotesDTO;

    }
    public List<DTONote> getNotesSorted(Long id){
        List<NoteEntity> Notes=this.RN.findAllSorted(id);
        List<DTONote> NotesDTO=new ArrayList<>();
        for(int i=0;i<Notes.size();i++){
            NotesDTO.add(this.NM.MappedToDAONote(Notes.get(i)));
        }
        return NotesDTO;
    }
    public DTONote getSingleNote(Long id_note,Long id_etudiant){
        return this.NM.MappedToDAONote(this.RN.findbyIdandStudent(id_note,id_etudiant).get());
    }
    public void CreateNote(DTONote Note,Long idStudent){
        NoteEntity note=this.NM.MappedToNote(Note);
        StudentEntitie SE=new StudentEntitie();
        SE.setId(idStudent);
        note.setStudent(SE);
        this.RN.save(note);
    }
    public void UpdateNote(DTONote Note,Long idnote,Long idstudent){
        NoteEntity NE=this.NM.MappedToNote(Note);
        NE.setId(idnote);
        StudentEntitie SE=new StudentEntitie();
        SE.setId(idstudent);
        NE.setStudent(SE);
        this.RN.save(NE);
    }
    public void DeleteNote(Long id){
        this.RN.deleteById(id);
    }
    public boolean Exits(long id){
        return this.RN.existsById(id);
    }
}
