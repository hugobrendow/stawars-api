package br.com.hugobrendow.starwars.repository;

import br.com.hugobrendow.starwars.model.Rebelde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RebeldeRepository extends JpaRepository<Rebelde, UUID> {

    @Query("select rebelde from Rebelde rebelde where rebelde.acusacoes >= 3")
    List<Rebelde> listarTraidores();
}
