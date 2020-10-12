package com.furseal.restaurant.common.utils;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author hejishan
 */
@Component
public class DateUtil {

    private static final SimpleDateFormat defaultSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private JdbcTemplate jt;
    private static JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = this.jt;
    }

    public static Date getNowDate() {
        String sql = "select now() as SystemTime";
        Map<String, Object> resultMap = jdbcTemplate.queryForMap(sql);
        if (resultMap != null && resultMap.size() > 0) {
            Date systemTime = (Date) resultMap.get("SystemTime");
            return systemTime;
        }
        return null;
    }

    public static String getNowDateString(String format) {
        try {
            Date nowDate = getNowDate();
            SimpleDateFormat sdf = defaultSdf;
            if (StringUtils.isNotEmpty(format)) {
                sdf = new SimpleDateFormat(format);
            }
            return sdf.format(nowDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String formatDate(Date date, String format) {
        try {
            SimpleDateFormat sdf = defaultSdf;
            if (StringUtils.isNotEmpty(format)) {
                sdf = new SimpleDateFormat(format);
            }
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
