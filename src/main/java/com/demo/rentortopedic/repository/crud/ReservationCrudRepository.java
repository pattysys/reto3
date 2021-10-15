package com.demo.rentortopedic.repository.crud;

import com.demo.rentortopedic.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

    //select count(*) as "total", ortopedicId from reservation group by ortopedicId order by total desc;

    @Query("SELECT c.ortopedic, COUNT(c.ortopedic) from Reservation AS c group by c.ortopedic order by COUNT(c.ortopedic) DESC")
    public List<Object[]> countTotalReservationsByOrtopedic();


    //select clientId, count(*) as "total" from reservation group by clientId order by total desc;
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByClient();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo );

    public List<Reservation>findAllByStatus(String status);
}
