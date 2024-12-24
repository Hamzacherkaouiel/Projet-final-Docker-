package projet.docker.backend.RepositoryInterfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projet.docker.backend.Entities.NoteEntity;

import java.util.List;
import java.util.Optional;

public interface RepositoryNote extends JpaRepository<NoteEntity,Long> {
    @Query("SELECT Note FROM NoteEntity Note WHERE Note.id = ?1 AND Note.student.id = ?2  ")
    Optional<NoteEntity> findbyIdandStudent(Long id_note, Long id_student);

    @Query("SELECT Note FROM NoteEntity  Note WHERE Note.student.id=?1")
    List<NoteEntity> findByStudent(Long id );
    @Query("SELECT Note  FROM NoteEntity Note WHERE Note.student.id=?1 ORDER BY Note.note desc ")
    List<NoteEntity> findAllSorted(Long id );
}
