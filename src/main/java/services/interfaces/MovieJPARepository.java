package services.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dh.jc.Primero.JC1.models.Movie;

@Repository
public interface MovieJPARepository extends JpaRepository<Movie, Integer> {
	
}
