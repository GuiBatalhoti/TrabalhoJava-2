package Main.Repository;

import Main.Model.Manga;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepository extends JpaRepository<Manga, UUID>{
    Manga findByIdManga(long id);
}
