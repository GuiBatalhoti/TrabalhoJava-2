package Main.Repository;

import Main.Model.MangaList;
import Main.Model.MangaListPK;
import Main.Model.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface para o repositório de MangaList, com as funções de procurar uma
 * MangaList pelo seu id e procurar todas as MangaLists de um usuário.
 *
 * @author - GuiBatalhoti
 * @author - Gabriel Nozawa
 */
@Repository
public interface MangaListRepository extends JpaRepository<MangaList, MangaListPK>{

    /**
     * Procura uma MangaList pelo seu id.
     * @param id
     * @return lista de Manga
     */
    MangaList findByMangaListPK(MangaListPK id);


    /**
     * Procura todas as MangaLists de um usuário.
     * @param user
     * @return lista de MangaList
     */
    List<MangaList> findByUsers(Users user);
}
