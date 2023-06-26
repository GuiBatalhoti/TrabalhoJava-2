/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

/**
 *
 * @author Nozawa
 */
@Entity
@Table(name = "manga_list")
//@NamedQueries({
//    @NamedQuery(name = "MangaList.findAll", query = "SELECT m FROM MangaList m"),
//    @NamedQuery(name = "MangaList.findByIdUser", query = "SELECT m FROM MangaList m WHERE m.mangaListPK.idUser = :idUser"),
//    @NamedQuery(name = "MangaList.findByIdManga", query = "SELECT m FROM MangaList m WHERE m.mangaListPK.idManga = :idManga"),
//    @NamedQuery(name = "MangaList.findByDescription", query = "SELECT m FROM MangaList m WHERE m.description = :description"),
//    @NamedQuery(name = "MangaList.findByDue", query = "SELECT m FROM MangaList m WHERE m.due = :due")})
public class MangaList implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MangaListPK mangaListPK;
    @Column(name = "due_chapters")
    private Integer dueChapters;
    @Column(name = "description")
    private String description;
    @Column(name = "due")
    @Temporal(TemporalType.DATE)
    private Date due;
    @JoinColumn(name = "id_manga", referencedColumnName = "id_manga", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Manga manga;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

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

    public void setMangaListPK(MangaListPK mangaListPK) {
        this.mangaListPK = mangaListPK;
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

    @Override
    public String toString() {
        return "Main.Model.MangaList[ mangaListPK=" + mangaListPK + " ]";
    }

    public Integer getDueChapters() {
        return dueChapters;
    }

    public void setDueChapters(Integer dueChapters) {
        this.dueChapters = dueChapters;
    }
    
}
