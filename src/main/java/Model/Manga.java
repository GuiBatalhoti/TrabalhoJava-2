package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class Manga implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idManga;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String autor;
    @NotEmpty
    private String data;

    public Manga(){
        
    }
    
    public long getIdManga() {
        return idManga;
    }

    public void setIdManga(long idManga) {
        this.idManga = idManga;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
    
}
