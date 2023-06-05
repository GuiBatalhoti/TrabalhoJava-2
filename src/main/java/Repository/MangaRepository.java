/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Model.Manga;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Nozawa
 */
public interface MangaRepository extends CrudRepository<Manga, String>{
    Manga findByIdEvento(long id);
}
