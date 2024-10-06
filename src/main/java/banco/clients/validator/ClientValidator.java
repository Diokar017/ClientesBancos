package banco.clients.validator;

import banco.clients.exceptions.ClientExceptionBadRequest;

public class ClientValidator {

    public String validateString(String cadena, String campo) throws ClientExceptionBadRequest {
        String cadenaTrim = cadena.trim();
        if(cadenaTrim.isEmpty() || cadenaTrim.isBlank() || cadenaTrim == null){
            throw new ClientExceptionBadRequest("El "+ campo +" del cliente es incorrecto");
        }else {
            return cadenaTrim;
        }
    }

    public String validateEmail(String email) throws ClientExceptionBadRequest {
        //redex para un email que tenga cualquier caracter alfanumerico, guion y punto, seguido de un arroba, seguido de cualquier caracter alfanumerico y guion, seguido de un punto, seguido de cualquier caracter alfanumerico seguido de un punto , seguido de 2 a 4 caracteres alfabeticass
        String redex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,4}$";
        String emailTrim = email.trim();
        if(emailTrim.isEmpty() || emailTrim.isBlank() || emailTrim == null){
            throw new ClientExceptionBadRequest("El email del cliente no puede estar en blanco");
        }else if ( emailTrim.matches(redex)){
            return emailTrim;
        }else {
            throw new ClientExceptionBadRequest("El email del cliente no es valido");
        }
    }

}