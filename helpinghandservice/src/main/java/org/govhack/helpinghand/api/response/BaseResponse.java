package org.govhack.helpinghand.api.response;

/**
 * Created by James on 30-Jul-16.
 */
public class BaseResponse implements IResponse {

    String message;
    String status;

    public BaseResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public BaseResponse() {
        this.message = "success";
        this.status = "200";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}