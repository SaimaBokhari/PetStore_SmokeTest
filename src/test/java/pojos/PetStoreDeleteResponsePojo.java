package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetStoreDeleteResponsePojo {

    private int code;
    private String type;
    private String message;

    public PetStoreDeleteResponsePojo(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public PetStoreDeleteResponsePojo() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PetStoreDeleteResponsePojo{" +
                "code=" + code +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
