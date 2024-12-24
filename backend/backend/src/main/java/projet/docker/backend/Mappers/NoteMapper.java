package projet.docker.backend.Mappers;

import org.springframework.stereotype.Component;
import projet.docker.backend.DTO.DTONote;
import projet.docker.backend.Entities.NoteEntity;

@Component
public class NoteMapper {
    public NoteEntity MappedToNote(DTONote note){
        NoteEntity NE=new NoteEntity();
        NE.setId(note.getId_note());
        NE.setNom(note.getNom());
        NE.setNote(note.getValue());
        return NE;
    }
    public DTONote MappedToDAONote(NoteEntity note){
        DTONote DN=new DTONote();
        DN.setId_note(note.getId());
        DN.setValue(note.getNote());
        DN.setNom(note.getNom());
        return DN;
    }

}
