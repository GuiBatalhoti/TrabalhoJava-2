package Repository;

import Model.Manga;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepository extends CrudRepository<Manga, String>{
    Manga findByIdEvento(long id);
}
