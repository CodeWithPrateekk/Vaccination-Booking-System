package com.example.VaccinationBookingSystems.exception;

public class VaccinationCenterNotFoundException extends RuntimeException{
    public VaccinationCenterNotFoundException(String message){
        super(message);
    }
}
