package com.mercadolivre.dh.concessionariadeveiculos.service;

import com.mercadolivre.dh.concessionariadeveiculos.model.Vehicle;
import com.mercadolivre.dh.concessionariadeveiculos.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class VehicleService implements IVehicle{
    @Autowired
    private VehicleRepository vehicleRepository;

    public void save (Vehicle vehicle){
        vehicleRepository.vehicleSave(vehicle);
    }

    @Override
    public List<Vehicle> getAllDate(Date initialDate, Date endDate) {
        List<Vehicle> vehicleList = this.vehicleRepository.getAll();
        return vehicleList.stream()
                .filter((v -> v.getManufacturingDate().before(initialDate) ||
                        v.getManufacturingDate().after(endDate))).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> getAllPrice(double minimumPrice, double maximumPrice) {
        List<Vehicle> vehicleList = this.vehicleRepository.getAll();
        return vehicleList.stream()
                .filter((v -> v.getPrice() >= maximumPrice &&
                        v.getPrice() <= maximumPrice)).collect(Collectors.toList());
    }

    @Override
    public Optional<Vehicle> getById(int id) {
        return this.vehicleRepository.getById(id);
    }

    @Override
    public List<Vehicle> getAll() {
        Stream<Vehicle> vehicleStream  = this.vehicleRepository.getAll().stream();
        vehicleStream.map((v) -> {v.setServicesList(null); return v;});
        return vehicleStream.collect(Collectors.toList());
    }
}
