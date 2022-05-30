package br.com.zup.edu.album;

import javax.persistence.*;

@Entity
public class Figurinha {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer pagina;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    private Album album;

    public Figurinha(Integer pagina, String descricao) {
        this.pagina = pagina;
        this.descricao = descricao;
    }

    @Deprecated
    public Figurinha() {
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
