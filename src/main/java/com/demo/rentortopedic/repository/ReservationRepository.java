package com.demo.rentortopedic.repository;

import com.demo.rentortopedic.model.Ortopedic;
import com.demo.rentortopedic.repository.crud.ReservationCrudRepository;
import com.demo.rentortopedic.model.Client;
import com.demo.rentortopedic.model.Reservation;
import com.demo.rentortopedic.model.custom.CountOrtopedic;
import com.demo.rentortopedic.model.custom.CountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public  List<CountOrtopedic> getTopOrtopedics(){
        List<CountOrtopedic>res=new ArrayList<>();
        List<Object[]>report=reservationCrudRepository.countTotalReservationsByOrtopedic();
        for(int i=0;i<report.size();i++){
            res.add(new CountOrtopedic((Long)report.get(i)[1],(Ortopedic) report.get(i)[0]));
        }
        return res;
    }


    public  List<CountClient> getTopClients(){
        List<CountClient>res=new ArrayList<>();
        List<Object[]>report=reservationCrudRepository.countTotalReservationsByClient();
        for(int i=0;i<report.size();i++){
            res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }

    public List<Reservation> getReservationPeriod(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }

    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

}
