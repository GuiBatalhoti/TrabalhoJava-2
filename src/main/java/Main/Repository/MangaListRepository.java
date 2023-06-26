package Main.Repository;

import Main.Model.MangaList;
import Main.Model.MangaListPK;
import Main.Model.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaListRepository extends JpaRepository<MangaList, MangaListPK>{
    MangaList findByMangaListPK(MangaListPK id);
    
    List<MangaList> findByUsers(Users user);
}
