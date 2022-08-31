package com.educative.ecommerce.Common;

import java.time.LocalDate;

public class ApiResponce {
    private final boolean success;
    private final String messege;
public String getTimestamp(){
    return LocalDate.now().toString();
}

    public ApiResponce(boolean success, String messege) {
        this.success = success;
        this.messege = messege;
    }
}
