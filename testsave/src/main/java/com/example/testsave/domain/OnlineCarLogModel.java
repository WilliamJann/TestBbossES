package com.example.testsave.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @author: fengyufeng
 * @since: 2020/7/29
 */
@Data
public class OnlineCarLogModel {

    private Long id;
    /**
     * 车牌号
     */
    private String carNo;
    /**
     * 经度
     */
    private BigDecimal lon;
    /**
     * 纬度
     */
    private BigDecimal lat;
    /**
     * 速度
     */
    private BigDecimal speed;
    /**
     * 方向
     */
    private Integer angle;
    /**
     * 时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;
    /**
     * 传送标识 0实时上传 1补传
     */
    private Integer source;
    /**
     * 	电量
     */
    private Integer soc;
    /**
     * 充电状态
     */
    private Integer socStatus;
    /**
     * 终端IP
     */
    private String ip;
    /**
     * IC卡号
     */
    private String iccId;
    /**
     * 当前电量可行驶里程 km
     */
    private BigDecimal mileage;
    /**
     * 状态位
     */
    private Long carState;
    /**
     * 报警位
     */
    private Long alarmState;
    /**
     * 司机从业资格证号
     */
    private String certificateId;


}
