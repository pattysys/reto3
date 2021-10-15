package com.demo.rentortopedic.repository.crud;


import com.demo.rentortopedic.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {

}
