package com.leinadb.trains.exceptions;

import java.util.Date;

public class ExceptionResponse {
    private String description;
    private Date date;

    public ExceptionResponse(String description, Date date) {
        this.description = description;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
