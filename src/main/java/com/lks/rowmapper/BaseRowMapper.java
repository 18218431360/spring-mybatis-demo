package com.lks.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import javax.xml.crypto.Data;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName BaseRowMapper
 * @Description 通用结果集映射器
 * @Author lks
 * @Date 2020/4/17 22:28
 * @Version 1.0
 */
public class BaseRowMapper<T> implements RowMapper {

    private Class<?> targetClazz;
    private Map<String, Field> fieldMap;

    public BaseRowMapper(Class<?> targetClazz) {
        this.targetClazz = targetClazz;
        fieldMap = new HashMap<String, Field>();
        Field[] fields = targetClazz.getDeclaredFields();
        for (Field field : fields) {
            fieldMap.put(field.getName(), field);
        }
    }

    @Override
    public Object mapRow(ResultSet rs, int org) throws SQLException {
        T obj = null;

        try {
            // 通过反射实例化对象
            obj = (T) targetClazz.newInstance();
            // 获取返回结果集的数据
            final ResultSetMetaData metaData = rs.getMetaData();
            // 获取返回结果集的条数
            int columnCount = metaData.getColumnCount();
            String columnName = null;
            // 循环结果集，映射每个字段
            for (int i = 1; i <= columnCount; i++) {
                // 获取每条结果集的名字
                columnName = metaData.getColumnName(i);
                // 根据结果集名称从fieldMap中获取字段的类型
                Class classType = fieldMap.get(camel(columnName)).getType();
                // 根据结果集名称从fieldMap中获取字段
                Field field = fieldMap.get(camel(columnName));
                // 防止字段是私有类型不能访问
                field.setAccessible(true);
                // 给对象匹配字段类型病组装
                if (classType == int.class || classType == Integer.class) { // int 或 Integer
                    field.set(obj, rs.getInt(columnName));
                } else if (classType == boolean.class || classType == Boolean.class) { // boolean 或 Boolean
                    field.set(obj, rs.getBoolean(columnName));
                } else if (classType == String.class) { // String
                    field.set(obj, rs.getString(columnName));
                } else if (classType == short.class || classType == Short.class) { // short 或 Short
                    field.set(obj, rs.getShort(columnName));
                } else if (classType == float.class) { // float
                    field.set(obj, rs.getShort(columnName));
                } else if (classType == double.class || classType == Double.class) { // double 或 Double
                    field.set(obj, rs.getDouble(columnName));
                } else if (classType == BigDecimal.class) { // bigdecimal
                    field.set(obj, rs.getBigDecimal(columnName));
                } else if (classType == Date.class) { // date
                    field.set(obj, rs.getDate(columnName));
                } else if (classType == Timestamp.class) { // timestamp
                    field.set(obj, rs.getTimestamp(columnName));
                } else if (classType == long.class || classType == Long.class) { // long 或 Long
                    field.set(obj, rs.getLong(columnName));
                }

                field.setAccessible(false);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 下划线转驼峰
     *
     * @Param:
     * @return:
     */
    public static String camel(String str) {
        // 创建一个匹配模式
        Pattern pattern = Pattern.compile("_(\\w)");
        // 全程匹配字符串
        Matcher matcher = pattern.matcher(str);
        // 创建一个字符容器存存放转换之后的字符串
        StringBuffer sb = new StringBuffer(str);
        if (matcher.find()) {
            // 存放有匹配成功后以及修改之后的字符串
            sb = new StringBuffer();
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
            // 将后面的字符串直接在尾部拼上
            matcher.appendTail(sb);
        } else {
            return sb.toString();
        }
        // 有多处匹配成功的采用递归遍历
        return camel(sb.toString());
    }

    public static void main(String[] args) {
        String str = "b_id_ic_ib";
        String wqw = camel(str);
        System.out.println(wqw);
    }
}
