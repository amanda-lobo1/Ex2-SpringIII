package com.mercadolivre.dh.concessionariadeveiculos.service;

import com.mercadolivre.dh.concessionariadeveiculos.model.Vehicle;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IVehicle {
    public List<Vehicle> getAllDate(Date initialDate, Date endDate);
    public List<Vehicle> getAllPrice(double minimumPrice, double maximumPrice);
    public Optional<Vehicle> getById(int id);
    public List<Vehicle> getAll();
    void addVehicle(Vehicle veiculo);
}
