package org.peng.web;

public class ResponseMessage<T> {
    private boolean isOk;
    private String message;
    private T data;

    public ResponseMessage(boolean isOk, String message, T data){
        this.isOk = isOk;
        this.message = message;
        this.data = data;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
