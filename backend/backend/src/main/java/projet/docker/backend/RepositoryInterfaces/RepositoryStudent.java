package projet.docker.backend.RepositoryInterfaces;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import projet.docker.backend.Entities.StudentEntitie;

public interface RepositoryStudent extends JpaRepository<StudentEntitie,Long> {

}
