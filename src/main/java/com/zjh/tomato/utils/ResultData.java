package com.zjh.tomato.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResultData {

    private boolean flag;
    private String msg;
    private Object obj;

    public  static  ResultData success() {
        return  new ResultData(true,"成功",null);
    }
    public  static  ResultData success(Object obj) {
        return  new ResultData(true,"成功",obj);
    }
    public  static  ResultData fail() {
        return  new ResultData(false,"失败",null);
    }
    public  static  ResultData fail(String msg) {
        return  new ResultData(false,msg,null);
    }

}
