package com.mercadolivre.dh.concessionariadeveiculos.controller;

import com.mercadolivre.dh.concessionariadeveiculos.model.Vehicle;
import com.mercadolivre.dh.concessionariadeveiculos.service.IVehicle;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/api/veiculos/")
public class VehicleController {

    @Autowired
    private IVehicle service;

    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle){
        this.service.addVehicle(vehicle);
        return new ResponseEntity(vehicle, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Vehicle> getAllVehicle(){
        List<Vehicle> vehicleList = this.service.getAll();
        return new ResponseEntity(vehicleList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable int id){
        Optional<Vehicle> vehicleOptional = this.service.getById(id);
        return vehicleOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().body(null));
    }

    @GetMapping("/dates")
    public ResponseEntity<List<Vehicle>> getDate(@RequestParam("since") Date since, @RequestParam("to") Date to) {

        if (since == null || to == null) {
            return ResponseEntity.badRequest().body(null);
        }
        if (since.after(to)) {
            return ResponseEntity.badRequest().body(null);
        }

        List<Vehicle> vehicleList = this.service.getAllDate(since, to);

        return new ResponseEntity(vehicleList, HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<Vehicle>> getPrice(@RequestParam("since") double since, @RequestParam("to") double to) {
        if (since > to){
            return ResponseEntity.badRequest().body(null);
        }

        List<Vehicle> vehicleList = this.service.getAllPrice(since, to);

        return new ResponseEntity(vehicleList, HttpStatus.OK);
    }
}
