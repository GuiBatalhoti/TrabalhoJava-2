/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * Entity MangaList
 *
 * @author - GuiBatalhoti
 * @author - Gabriel Nozawa
 */
@Embeddable
public class MangaListPK implements Serializable {

    /**
     * Attributes
     */
    @Basic(optional = false)
    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)
    @Column(name = "id_manga")
    private int idManga;

    /**
     * Contructors
     */
    public MangaListPK() {
    }

    public MangaListPK(int idUser, int idManga) {
        this.idUser = idUser;
        this.idManga = idManga;
    }

    /**
     * Setters and Getters
     */
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdManga() {
        return idManga;
    }

    public void setIdManga(int idManga) {
        this.idManga = idManga;
    }

    /**
     * HashCode and Equals
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUser;
        hash += (int) idManga;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MangaListPK)) {
            return false;
        }
        MangaListPK other = (MangaListPK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idManga != other.idManga) {
            return false;
        }
        return true;
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        return "Main.Model.MangaListPK[ idUser=" + idUser + ", idManga=" + idManga + " ]";
    }
    
}
