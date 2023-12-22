package com.shj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private T data;
    private String msg;

    public static <T> Result<T> success(T data){
        return new Result<>(200, data, "ok");
    }

    public static <T> Result<T> error(String errMsg){
        return new Result<>(500, null, errMsg);
    }
}
