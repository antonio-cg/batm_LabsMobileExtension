package com.generalbytes.batm.server.extensions.extra.examples.LabsMobile;

public class LabsMobileResponse {
    int code;
    String message;
    String subId;
    /**
     * 
     * @param code codigo de respuesta a una peticion de enviar mensaje 
     * @param message le mensjae de respuesta
     * @param subId  si el mensaje se envio correctamente se le asignara un id 
     */
    public LabsMobileResponse(int code, String message, String subId) {
        this.code = code;
        this.message = message;
        this.subId = subId;
    }

    public LabsMobileResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public LabsMobileResponse() {
    }
    
    
    

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }
    
    
}