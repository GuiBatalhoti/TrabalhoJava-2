/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entity class Manga
 *
 * @author - GuiBatalhoti
 * @author - Gabriel Nozawa
 */
@Entity
@Table(name = "manga")
public class Manga implements Serializable {

    /**
     * Attributes
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_manga")
    private Integer idManga;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "publication_date")
//    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;
    @Column(name = "num_chapter")
    private Integer numChapter;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manga")
    private Collection<MangaList> mangaListCollection;
    
    @Column(name = "description")
    private String description;

    /**
     * Constructors
     */
    public Manga() {
    }

    public Manga(Integer idManga) {
        this.idManga = idManga;
    }

    /**
     * Getters and Setters
     */
    public Integer getIdManga() {
        return idManga;
    }

    public void setIdManga(Integer idManga) {
        this.idManga = idManga;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Integer getNumChapter() {
        return numChapter;
    }

    public void setNumChapter(Integer numChapter) {
        this.numChapter = numChapter;
    }

    public Collection<MangaList> getMangaListCollection() {
        return mangaListCollection;
    }

    public void setMangaListCollection(Collection<MangaList> mangaListCollection) {
        this.mangaListCollection = mangaListCollection;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Hashcode and Equals
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idManga != null ? idManga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manga)) {
            return false;
        }
        Manga other = (Manga) object;
        if ((this.idManga == null && other.idManga != null) || (this.idManga != null && !this.idManga.equals(other.idManga))) {
            return false;
        }
        return true;
    }

    /**
     * toString
     * @return string
     */
    @Override
    public String toString() {
        return "Main.Model.Manga[ idManga=" + idManga + " ]";
    }
    
}
