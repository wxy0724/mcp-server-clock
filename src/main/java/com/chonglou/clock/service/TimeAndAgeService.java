package com.chonglou.clock.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 提供时间相关工具的服务类
 */
@Service
public class TimeAndAgeService {

    /**
     * 获取当前时间
     * @return 当前时间字符串，格式为 yyyy-MM-dd HH:mm:ss
     */
    @Tool(description = "获取当前时间，返回格式是yyyy-MM-dd HH:mm:ss")
    public String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    /**
     * 根据出生日期计算年龄
     * @param birthDate 出生日期，格式为 yyyy-MM-dd
     * @return 年龄
     */
    @Tool(description = "根据出生日期计算年龄")
    public int calculateAge(String birthDate) {
        try {
            LocalDate birthLocalDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate currentDate = LocalDate.now();
            return (int) ChronoUnit.YEARS.between(birthLocalDate, currentDate);
        } catch (Exception e) {
            throw new IllegalArgumentException("日期格式错误，请使用 yyyy-MM-dd 格式");
        }
    }
}