package com.puntoCuatro.resproductionList.general.utils;


import org.springframework.http.HttpStatus;

/**
 * Clae de respuesta para los
 * servicios REST
 *
 * @param <T> Clase del objeto respuesta
 */
public class ResponseObject<T>{

    private int code;

    private String message;

    private T body;


    public ResponseObject(T body){
        this.body = body;
        this.code = HttpStatus.OK.value();
        this.message = HttpStatus.OK.getReasonPhrase();
    }

    public ResponseObject(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseObject(int code, String message, T body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
