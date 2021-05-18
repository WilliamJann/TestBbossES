package com.example.testsave.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @Description:
 * @author: fengyufeng
 * @since: 2020/9/18
 */
@Data
@ToString
public class OnlinecarLogReq {

    private String carNo;
    private String startTime;
    private String endTime;
    private String queryType;

}
