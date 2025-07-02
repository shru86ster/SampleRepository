package constantData;

public enum StatusCode {
    SUCCESS(200,"The request was successful"),
    CREATED(201,"A new resource was created"),
    BAD_REQUEST(404,"Incorrect request was sent"),
    NO_CONTENT(204,"No Content found"),
    UNAUTHORISED(401,"No access to resource"),
    CONTENT_NOT_FOUND(404,"Content not found")
    ;


    public final int code;
    public final String description;

    StatusCode(int i, String s) {
        this.code=i;
        this.description=s;
    }
}
