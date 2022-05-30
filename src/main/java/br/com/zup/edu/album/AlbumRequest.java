package br.com.zup.edu.album;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlbumRequest {

    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String descricao;

    @NotNull
    @Min(10)
    @Max(100)
    private Integer numeroPaginas;

    @NotEmpty
    private List<FigurinhaRequest> figurinhas = new ArrayList<>();;

    public AlbumRequest(String titulo, String descricao, Integer numeroPaginas, List<FigurinhaRequest> figurinhas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.numeroPaginas = numeroPaginas;
        this.figurinhas = figurinhas;
    }

    public AlbumRequest() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public List<FigurinhaRequest> getFigurinhas() {
        return figurinhas;
    }

    public Album toModel() {
        Album album = new Album(titulo, descricao, numeroPaginas);
        figurinhas.forEach((f) -> {
            album.adiciona(f.toModel());
        });
        return album;
    }
}
