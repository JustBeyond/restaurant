package com.furseal.restaurant.common.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hejishan
 */
public class BeanUtil {
    public static <T, V> V convert(T object, Class<V> targetType) {
        if (object == null || targetType == null) {
            return null;
        }
        V v = BeanUtils.instantiateClass(targetType);
        BeanUtils.copyProperties(object, v);
        return v;
    }

    public static <T, V> List<V> convertList(List<T> objectList, Class<V> targetType) {
        List<V> ttList = null;
        if (objectList != null && objectList.size() > 0) {
            ttList = new ArrayList<V>();
            for (T t : objectList) {
                V convert = convert(t, targetType);
                ttList.add(convert);
            }
        }
        return ttList;
    }
}
