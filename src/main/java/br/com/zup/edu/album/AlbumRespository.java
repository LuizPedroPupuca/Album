package br.com.zup.edu.album;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRespository extends JpaRepository<Album, Long> {
}
