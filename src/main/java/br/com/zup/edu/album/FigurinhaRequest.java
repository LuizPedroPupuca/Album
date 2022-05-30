package br.com.zup.edu.album;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class FigurinhaRequest {

    @NotNull
    private Integer pagina;

    @NotBlank
    private String descricao;

    public FigurinhaRequest(Integer pagina, String descricao) {
        this.pagina = pagina;
        this.descricao = descricao;
    }

    public FigurinhaRequest() {
    }

    public Integer getPagina() {
        return pagina;
    }

    public String getDescricao() {
        return descricao;
    }

    public Figurinha toModel(){
        return new Figurinha(pagina, descricao);
    }
}
