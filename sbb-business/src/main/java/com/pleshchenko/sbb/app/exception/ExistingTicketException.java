package com.pleshchenko.sbb.app.exception;

/**
 * Created by РОМАН on 28.05.2017.
 */
public class ExistingTicketException extends Exception {


    public ExistingTicketException() {
    }

    public ExistingTicketException(String message) {
        super(message);
    }
}
