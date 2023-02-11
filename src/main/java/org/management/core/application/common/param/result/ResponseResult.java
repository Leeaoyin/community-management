package org.management.core.application.common.param.result;

import lombok.*;
import org.management.core.domain.event.Const;
import org.management.core.application.common.enums.HttpCodeEnum;

import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult<T> implements Serializable {

    /**
     * data
     */
    private T data;

    /**
     * message
     */
    private String message;

    /**
     * code
     */
    private Integer code;

    public static <T> ResponseResult<T> success(T t) {
         return new ResponseResult<>(t, "success", Const.SUCCESS_CODE);
    }

    public static <T> ResponseResult<T> error(Integer errorCode, String errorMessage) {
        return new ResponseResult<>(null, errorMessage, errorCode);
    }

    public static <T> ResponseResult<T> error(HttpCodeEnum exceptionEnum) {
        return new ResponseResult<>(null, exceptionEnum.getMessage(), exceptionEnum.getCode());
    }
}
