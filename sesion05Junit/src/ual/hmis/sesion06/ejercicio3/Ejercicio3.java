package ual.hmis.sesion06.ejercicio3;

public class Ejercicio3 {
    public String maskPassword(String password) {
        int length = password.length();

        String maskedPassword = "";

        if(password.length() < 5){
            maskedPassword = "password demasiado corto";
        } else if(password.length() >= 5 && password.length() < 8){
            maskedPassword = "********";
        } else if(password.length() >= 12 && password.length() < 40){
            maskedPassword = "************";
        } else if(password.length() >= 40){
            maskedPassword = "password demasiado largo";
        }
        return maskedPassword;
    }
} 