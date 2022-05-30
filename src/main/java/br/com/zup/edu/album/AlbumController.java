package br.com.zup.edu.album;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/album")
public class AlbumController {

    private final AlbumRespository albumRespository;

    public AlbumController(AlbumRespository albumRespository) {
        this.albumRespository = albumRespository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastra(@RequestBody @Valid AlbumRequest albumRequest, UriComponentsBuilder uri){

        Album album = albumRequest.toModel();

        albumRespository.save(album);

        URI location = uri.path("/album/{id}")
                .buildAndExpand(album.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
