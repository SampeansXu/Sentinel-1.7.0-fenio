package com.alibaba.csp.sentinel.dashboard.repository.influxDB;

import org.influxdb.InfluxDB;
import org.influxdb.dto.Pong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author by fenio for metrics save to influxdb
 */
@Component
public class InfluxDBUtils {

    @Autowired
    public InfluxDB influxDB;

    /**
     * 测试连接是否正常
     * @return true 正常
     */
    public boolean ping() {
        boolean isConnected = false;
        Pong pong;
        try {
            pong = influxDB.ping();
            if (pong != null) {
                isConnected = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isConnected;
    }
}
