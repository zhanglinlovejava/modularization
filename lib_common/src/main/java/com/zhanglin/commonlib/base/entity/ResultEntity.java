package com.zhanglin.commonlib.base.entity;

/**
 * Created by zhanglin on 2017/7/25.
 */
public class ResultEntity<T> {

    /**
     * 0 表示请求成功
     **/
    public int error_code;
    public String error_msg;
    public long server_time;
    public T data;

    @Override
    public String toString() {
        return "ResultEntity{" +
                "error_code=" + error_code +
                ", error_msg='" + error_msg + '\'' +
                ", server_time=" + server_time +
                ", data=" + data +
                '}';
    }
}
