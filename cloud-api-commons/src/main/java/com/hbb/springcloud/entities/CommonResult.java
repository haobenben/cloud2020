package com.hbb.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ahthor yj
 * @date 2020/3/19
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

  private Integer code;

  private String message;

  private T data;

  public CommonResult(Integer code,String message){
    this(code, message,null);
  }
}
