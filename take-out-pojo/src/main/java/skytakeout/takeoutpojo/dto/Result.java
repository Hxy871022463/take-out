package skytakeout.takeoutpojo.dto;

import lombok.Data;

@Data
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    public static<T> Result<T> success() {
        Result<T> result = new Result<>();
        result.code = 200;
        return result;
    }


    public static<T> Result<T> success(T object) {
        Result<T> result = new Result<>();
        result.code = 200;
        result.data = object;
        return result;
    }

    public static<T> Result<T> success(String msg) {
        Result<T> result = new Result<>();
        result.msg = msg;
        result.code = 400;
        return result;
    }
}
