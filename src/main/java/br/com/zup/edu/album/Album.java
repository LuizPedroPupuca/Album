package br.com.zup.edu.album;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String descricao;

    @Column(nullable = false)
    private Integer numeroPaginas;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "album")
    private List<Figurinha> figurinhas = new ArrayList<>();

    public Album() {
    }

    public Album(String titulo, String descricao, Integer numeroPaginas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.numeroPaginas = numeroPaginas;
    }

    public Long getId() {
        return id;
    }

    public void adiciona(Figurinha figurinha) {
        figurinha.setAlbum(this);
        this.figurinhas.add(figurinha);
    }
}
