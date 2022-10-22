package com.mercadolivre.dh.concessionariadeveiculos.repository;

import com.mercadolivre.dh.concessionariadeveiculos.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Data
@AllArgsConstructor
public class VehicleRepository {

    private List<Vehicle> vehicleList;

    public void vehicleSave (Vehicle vehicle){
        this.vehicleList.add(vehicle);
    }

    public Optional<Vehicle> getById(int id) {
        Optional<Vehicle> vehicle = this.vehicleList.stream()
                .filter(v -> v.getId() == id)
                .findFirst();
        return vehicle;
    }
    public List<Vehicle> getAll() {
        return this.vehicleList;
    }
}
