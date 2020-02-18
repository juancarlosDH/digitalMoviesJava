package repository;

import com.dh.jc.Primero.JC1.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreJPARepository extends JpaRepository<Genre, Integer> {

}
