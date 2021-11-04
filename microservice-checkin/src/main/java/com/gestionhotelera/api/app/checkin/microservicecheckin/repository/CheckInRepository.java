package com.gestionhotelera.api.app.checkin.microservicecheckin.repository;

import com.gestionhotelera.cammons.habitaciones.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author jhonc
 * @version 1.0
 * @since 28/10/2021
 */

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn,Long> {

    @Query("select c from CheckIn c left join fetch c.usuario u where c.id=?1")
    CheckIn getCheckInOf(Long id);

    //@Query(value = "SELECT * FROM",nativeQuery = true)
    @Query("select c from CheckIn  c left  join fetch  c.usuario u where u.cedula=?1")
    CheckIn getCheckByCedulaOfUser(String cedula);

}
