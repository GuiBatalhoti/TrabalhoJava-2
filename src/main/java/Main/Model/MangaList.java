/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entity MangaList
 *
 * @author - GuiBatalhoti
 * @author - Gabriel Nozawa
 */
@Entity
@Table(name = "manga_list")
public class MangaList implements Serializable {

    /**
     * Attributes
     */
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MangaListPK mangaListPK;
    @Column(name = "due_chapters")
    private Integer dueChapters;
    @Column(name = "description")
    private String description;
    @Column(name = "due")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date due;
    @JoinColumn(name = "id_manga", referencedColumnName = "id_manga", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Manga manga;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    /**
     * Contructors
     */
    public MangaList() {
    }

    public MangaList(MangaListPK mangaListPK) {
        this.mangaListPK = mangaListPK;
    }

    public MangaList(int idUser, int idManga) {
        this.mangaListPK = new MangaListPK(idUser, idManga);
    }

    public MangaListPK getMangaListPK() {
        return mangaListPK;
    }

    /**
     * Setters and Getters
     */
    public void setMangaListPK(MangaListPK mangaListPK) {
        this.mangaListPK = mangaListPK;
    }

    public Integer getDueChapters() {
        return dueChapters;
    }

    public void setDueChapters(Integer dueChapters) {
        this.dueChapters = dueChapters;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    /**
     * HashCode and Equals
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mangaListPK != null ? mangaListPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MangaList)) {
            return false;
        }
        MangaList other = (MangaList) object;
        if ((this.mangaListPK == null && other.mangaListPK != null) || (this.mangaListPK != null && !this.mangaListPK.equals(other.mangaListPK))) {
            return false;
        }
        return true;
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        return "Main.Model.MangaList[ mangaListPK=" + mangaListPK + " ]";
    }
    
}
