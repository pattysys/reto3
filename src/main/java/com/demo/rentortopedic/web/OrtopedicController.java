package com.demo.rentortopedic.web;

import com.demo.rentortopedic.model.Ortopedic;
import com.demo.rentortopedic.service.OrtopedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Ortopedic")
public class OrtopedicController {

    @Autowired
    private OrtopedicService ortopedicService;
    @GetMapping("/all")
    public List<Ortopedic> getOrtopedics(){
        return ortopedicService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Ortopedic> getOrtopedic(@PathVariable("id") int ortopedicId) {
        return ortopedicService.getOrtopedic(ortopedicId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic save(@RequestBody Ortopedic ortopedic) {
        return ortopedicService.save(ortopedic);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic update(@RequestBody Ortopedic ortopedic) {
        return ortopedicService.update(ortopedic);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int ortopedicId) {
        return ortopedicService.deleteOrtopedic(ortopedicId);
    }



}
