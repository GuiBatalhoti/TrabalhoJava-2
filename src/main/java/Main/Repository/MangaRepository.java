package Main.Repository;

import Main.Model.Manga;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface MangaRepository
 *
 * @author - GuiBatalhoti
 * @author - Gabriel Nozawa
 */
@Repository
public interface MangaRepository extends JpaRepository<Manga, UUID>{

    /**
     * Método que busca um manga pelo id
     * @param id
     * @return Manga
     */
    Manga findByIdManga(long id);
}
