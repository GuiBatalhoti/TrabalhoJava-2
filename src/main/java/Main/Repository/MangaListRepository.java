package Main.Repository;

import Main.Model.MangaList;
import Main.Model.MangaListPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaListRepository extends JpaRepository<MangaList, MangaListPK>{
    MangaList findByMangaListPK(MangaListPK id);
}
