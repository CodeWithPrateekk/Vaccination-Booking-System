package com.example.VaccinationBookingSystems.exception;

public class DoseAlreadyTakenException extends  RuntimeException{

    public DoseAlreadyTakenException(String message){
        super(message);
    }
}
