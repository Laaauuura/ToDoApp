package bo.edu.ucb.tasks.dto;

public class ResponseDto {
    private String code;
    private Object result;
    private String message;
    private Long userId;

 public ResponseDto() {
        // Constructor vacío
    }

    public ResponseDto(Object result) {
        this.code = "TASK-0000";
        this.result = result;
        //this.userId = userId;   
    }

    public ResponseDto(String code,  String message, Long userId) {
        this.code = code;
        this.message = message;
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
            "code='" + code + '\'' +
            ", result=" + result +
            ", message='" + message + '\'' +
            ", userId='" + userId + '\'' +
            '}';
    }

}