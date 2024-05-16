package it.epicode.Lezione.repository;

import it.epicode.Lezione.bean.Computer;
import it.epicode.Lezione.bean.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer> {

    public List<Computer> findByRamLessThan(int ram);

    @Query(value = "select d from Dispositivo d order by d.nome desc", nativeQuery = true)
    public List<Dispositivo> findAllOrderByNomeDesc();
}

