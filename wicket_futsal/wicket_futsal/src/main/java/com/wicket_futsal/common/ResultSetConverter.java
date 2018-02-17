package com.wicket_futsal.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * ResultSetをDTOに詰め替える
 *
 * @author User
 *
 */

public class ResultSetConverter<E> {
	private final Map<String, Method> setters = new HashMap<String, Method>();

	public ResultSetConverter(final ResultSet rs, final Class<E> dtoClass) throws Exception {

    	//引数のResultSetから取得したカラムの数だけ処理を実行する
        for (String column : getColumns(rs)) {
            try {
            	//Mapにカラム名とDTOのsetterメソッドを対応させて詰める
            	setters.put(column, dtoClass.getMethod(toSetterName(column), new Class[] { String.class }));
            } catch (Exception e) {
            	// ignore
            }
        }
	}

    /**
     * ResultSetの値をDTOに詰め替える
     * @param rs
     * @param dto
     * @return ResultSetの値を詰めたDTO
     * @throws SQLException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public E toDTO(final ResultSet rs, final E dto) throws SQLException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Object[] parameter = new Object[1];
        for (String column : setters.keySet()) {
            parameter[0] = rs.getString(column);
            setters.get(column).invoke(dto, parameter);
        }
        return dto;
    }

    /**
     * ResultSetのカラム名をリストに詰めて返す
     * @param rs
     * @return カラム名のリスト
     * @throws SQLException
     */
    private static List<String> getColumns(final ResultSet rs) throws SQLException {
        List<String> list = new ArrayList<String>();
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int columnCount = rsMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            list.add(rsMetaData.getColumnName(i));
        }
        return list;
    }

    /**
     * カラム名を基にしてsetterメソッド名を取得する
     * <br/><br/>
     * set + ColumnName
     * <br/>
     * カラム名は"_"で区切って"_"の次の1文字を大文字にする
     * <br/>
     * 例
     * <br>
     * ・COLUMNNAME → setColumnname
     * <br/>
     * ・Column_Name →setColumnName
     *
     * @param columnName
     * @return
     */
    private static String toSetterName(final String columnName) {
        StringBuilder setterName = new StringBuilder("set");
        for (String part : columnName.split("_")) {
            setterName.append(part.substring(0, 1).toUpperCase());
            setterName.append(part.substring(1).toLowerCase());
        }
        return setterName.toString();
    }
}