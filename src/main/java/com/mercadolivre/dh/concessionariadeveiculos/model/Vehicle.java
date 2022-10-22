package com.mercadolivre.dh.concessionariadeveiculos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private Date manufacturingDate;
    private Integer numberOfKilometers;
    private int doors;
    private double price;
    private int countOfOwners;
    private List<Services> servicesList;

}
