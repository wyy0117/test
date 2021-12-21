package com.wyy.testtranaction;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Date: 2021/12/17
 * @Author: wyy
 */
@Component
@ConfigurationProperties(prefix = "logic.debug")
@PropertySource(value = "classpath:config.properties")
public class DebugProperty {

    private int meetingId;

    @Override
    public String toString() {
        return "DebugProperty{" +
                "meetingId='" + meetingId + '\'' +
                '}';
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }
}
