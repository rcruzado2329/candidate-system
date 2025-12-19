package repository;


import entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    /**
     * Devuelve todos los clientes ordenados por fecha de creación
     */
    List<Client> findAllByOrderByCreatedAtDesc();

    /**
     * Obtiene solo las edades de los clientes (optimizado para métricas)
     */
    @Query("SELECT c.age FROM Client c")
    List<Integer> findAllAges();

    /**
     * Verifica si existe un cliente por nombre y apellido
     * Útil para validaciones de negocio
     */
    boolean existsByNameAndLastName(String name, String lastName);

}
