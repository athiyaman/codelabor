package org.codelabor.system.util.xplatform;

import static org.codelabor.system.web.xplatform.XplatformConstants.ERROR_CODE;
import static org.codelabor.system.web.xplatform.XplatformConstants.ERROR_MESSAGE;
import static org.codelabor.system.web.xplatform.XplatformConstants.FAILURE_CODE;
import static org.codelabor.system.web.xplatform.XplatformConstants.SUCCESS_CODE;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.codelabor.system.dto.xinternet.ChangedDataMapListDTO;
import org.codelabor.system.dto.xinternet.ChangedDataObjectArrayListDTO;
import org.codelabor.system.dto.xinternet.ChangedDataObjectListDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tobesoft.xplatform.data.DataSet;
import com.tobesoft.xplatform.data.DataSetList;
import com.tobesoft.xplatform.data.DataTypes;
import com.tobesoft.xplatform.data.Variable;
import com.tobesoft.xplatform.data.VariableList;

/**
 * Xplatform 관련 유틸리티
 * 
 * @author bomber.shin
 * 
 */
public class XplatformUtils {
	/**
	 * 로거
	 */
	static Logger logger = LoggerFactory.getLogger(XplatformUtils.class);

	/**
	 * Java Class 타입에 대응하는 Xplatform 필드 타입을 가져온다.
	 * 
	 * @param clazz
	 *            Java Class
	 * @return Xplatform 필드 타입 상수
	 */
	public static int getXplatformDataTypes(
			@SuppressWarnings("rawtypes") Class clazz) {
		int dataTypes = DataTypes.STRING;
		if (clazz.equals(java.lang.String.class)) {
			dataTypes = DataTypes.STRING;
		} else if (clazz.equals(java.lang.Integer.class)) {
			dataTypes = DataTypes.INT;
		} else if (clazz.equals(java.lang.Boolean.class)) {
			dataTypes = DataTypes.BOOLEAN;
		} else if (clazz.equals(java.lang.Long.class)) {
			dataTypes = DataTypes.LONG;
		} else if (clazz.equals(java.lang.Float.class)) {
			dataTypes = DataTypes.FLOAT;
		} else if (clazz.equals(java.lang.Double.class)) {
			dataTypes = DataTypes.DOUBLE;
		} else if (clazz.equals(java.math.BigDecimal.class)) {
			dataTypes = DataTypes.BIG_DECIMAL;
		} else if (clazz.equals(java.util.Date.class)) {
			dataTypes = DataTypes.DATE_TIME;
		} else if (clazz.equals(byte[].class)) {
			dataTypes = DataTypes.BLOB;
		}
		return dataTypes;
	}

	/**
	 * Java Object에 대응하는 Xplatform 필드 타입을 가져온다.
	 * 
	 * @param obj
	 *            Java Object
	 * @return Xplatform 필드 타입 상수
	 */
	public static int getXplatformDataTypes(Object obj) {
		int dataTypes = DataTypes.STRING;
		if (obj != null) {
			@SuppressWarnings("rawtypes")
			Class clazz = obj.getClass();
			dataTypes = getXplatformDataTypes(clazz);
		}
		return dataTypes;
	}

	/**
	 * Java Bean의 정보를 기반으로 Xplatform DataSet에 컬럼 헤더 정보를 설정한다.<br/>
	 * Xplatform에서 지원하지 않는 Java Class 타입에 대해서는 무조건 Xplatform에서의 STRING 타입으로
	 * 설정된다.
	 * 
	 * @param clazz
	 *            컬럼 명을 property로 가지는 Java Bean Class
	 * @param targetDataSet
	 *            컬럼 헤더 정보를 설정할 DataSet
	 */
	@SuppressWarnings("rawtypes")
	public static void setColumnHeaderByJavaBeanClass(Class clazz,
			DataSet targetDataSet) {
		PropertyDescriptor[] propertyDescriptors = PropertyUtils
				.getPropertyDescriptors(clazz);
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			String propertyName = propertyDescriptor.getName();
			Class propertyType = propertyDescriptor.getPropertyType();
			if (!propertyName.equals("class")) {
				targetDataSet.addColumn(propertyName,
						getXplatformDataTypes(propertyType));
			}
		}
	}

	/**
	 * Map에 담긴 객체 정보를 기반으로 Xplatform DataSet에 컬럼 헤더 정보를 설정한다.<br/>
	 * Xplatform에서 지원하지 않는 Java Class 타입에 대해서는 무조건 Xplatform에서의 STRING 타입으로
	 * 설정된다.<br/>
	 * Map의 value가 null인 경우, Java Class 타입을 알 수 없으므로 무조건 Xplatform에서의 STRING
	 * 타입으로 설정된다.<br/>
	 * 
	 * @param sourceMap
	 *            컬럼 명을 key로, 컬럼 값을 value로 가지는 Map
	 * @param targetDataSet
	 *            컬럼 헤더 정보를 설정할 DataSet
	 */
	public static void setColumnHeaderByMap(Map<String, Object> sourceMap,
			DataSet targetDataSet) {
		Set<String> keySet = sourceMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object value = sourceMap.get(key);
			targetDataSet.addColumn(key, getXplatformDataTypes(value));
		}
	}

	/**
	 * Map을 DataSet의 특정 row 데이터로 변환한다.
	 * 
	 * @param sourceMap
	 *            컬럼 명을 key로, 컬럼 값을 value로 가지는 Map
	 * @param targetDataSet
	 *            Map의 데이터를 받을 DataSet
	 * @param rowIndex
	 *            DataSet의 row 위치
	 */
	public static void convertMapToDataSetRow(Map<String, Object> sourceMap,
			DataSet targetDataSet, int rowIndex) {
		targetDataSet.newRow();
		Set<String> keySet = sourceMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object value = sourceMap.get(key);
			logger.debug("key: {}, value: {}", key, value);
			targetDataSet.set(rowIndex, key, value);
		}
	}

	/**
	 * Map을 DataSet의 특정 row 데이터로 변환한다.<br/>
	 * Xplatform에서 지원하지 않는 Java Class 타입에 대해서는 무조건 Xplatform에서의 STRING 타입으로
	 * 설정된다.<br/>
	 * Map의 value가 null인 경우, Java Class 타입을 알 수 없으므로 무조건 Xplatform에서의 STRING
	 * 타입으로 설정된다.<br/>
	 * 
	 * @param sourceMap
	 *            컬럼 명을 key로, 컬럼 값을 value로 가지는 Map
	 * @return Map의 데이터를 받을 DataSet
	 */
	public static DataSet convertMapToDataSet(Map<String, Object> sourceMap) {
		DataSet targetDataSet = new DataSet();
		setColumnHeaderByMap(sourceMap, targetDataSet);
		targetDataSet.newRow();
		Set<String> keySet = sourceMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object value = sourceMap.get(key);
			logger.debug("key: {}, value: {}", key, value);
			targetDataSet.set(0, key, value);
		}
		return targetDataSet;
	}

	/**
	 * Map을 DataSet의 특정 row 데이터로 변환한다.<br/>
	 * Xplatform에서 지원하지 않는 Java Class 타입에 대해서는 무조건 Xplatform에서의 STRING 타입으로
	 * 설정된다.<br/>
	 * Map의 value가 null인 경우, Java Class 타입을 알 수 없으므로 무조건 Xplatform에서의 STRING
	 * 타입으로 설정된다.<br/>
	 * 
	 * @param sourceMap
	 *            컬럼 명을 key로, 컬럼 값을 value로 가지는 Map
	 * @param dataSetName
	 *            생성할 DataSet 이름
	 * @return Map의 데이터를 받을 DataSet
	 */
	public static DataSet convertMapToDataSet(Map<String, Object> sourceMap,
			String dataSetName) {
		DataSet targetDataSet = convertMapToDataSet(sourceMap);
		targetDataSet.setName(dataSetName);
		return targetDataSet;
	}

	/**
	 * DataSet의 특정 row 데이터를 Map으로 변환한다.
	 * 
	 * @param sourceDataSet
	 *            DataSet
	 * @param targetMap
	 *            DataSet의 특정 row 데이터를 받을 Map
	 * @param rowIndex
	 *            DataSet의 row 위치
	 */
	public static void convertDataSetRowToMap(DataSet sourceDataSet,
			Map<String, Object> targetMap, int rowIndex) {
		int columnCount = sourceDataSet.getColumnCount();
		for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
			String colunmName = sourceDataSet.getColumn(columnIndex).getName();
			Object columnValue = sourceDataSet.getObject(rowIndex, columnIndex);
			logger.debug("colunmName: {}, columnValue: {}", colunmName,
					columnValue);
			targetMap.put(colunmName, columnValue);
			logger.debug("targetMap: {}", targetMap);
		}
	}

	/**
	 * DataSet의 삭제된 데이터 중, 특정 row 데이터를 Map으로 변환한다.
	 * 
	 * @param sourceDataSet
	 *            DataSet
	 * @param targetMap
	 *            DataSet의 특정 row 데이터를 받을 Map
	 * @param rowIndex
	 *            DataSet의 삭제된 데이터 row 위치
	 */
	public static void convertDeletedDataSetRowToMap(DataSet sourceDataSet,
			Map<String, Object> targetMap, int rowIndex) {
		int columnCount = sourceDataSet.getColumnCount();
		for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
			String colunmName = sourceDataSet.getColumn(columnIndex).getName();
			Object columnValue = sourceDataSet.getRemovedData(rowIndex,
					columnIndex);
			logger.debug("colunmName: {}, columnValue: {}", colunmName,
					columnValue);
			targetMap.put(colunmName, columnValue);
			logger.debug("targetMap: {}", targetMap);
		}
	}

	/**
	 * DataSet의 특정 row 데이터를 Map으로 변환한다.
	 * 
	 * @param sourceDataSet
	 *            DataSet
	 * @param rowIndex
	 *            DataSet의 row 위치
	 * @return DataSet의 특정 row 데이터를 받을 Map
	 */
	public static Map<String, Object> convertDataSetRowToMap(
			DataSet sourceDataSet, int rowIndex) {
		int columnCount = sourceDataSet.getColumnCount();
		Map<String, Object> targetMap = new LinkedHashMap<String, Object>();
		for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
			String colunmName = sourceDataSet.getColumn(columnIndex).getName();
			Object columnValue = sourceDataSet.getObject(rowIndex, columnIndex);
			logger.debug("colunmName: {}, columnValue: {}", colunmName,
					columnValue);
			targetMap.put(colunmName, columnValue);
			logger.debug("targetMap: {}", targetMap);
		}
		return targetMap;
	}

	public static Object[] convertDataSetRowToObjectArray(
			DataSet sourceDataSet, int rowIndex) {
		List<Object[]> paramList = new ArrayList<Object[]>();
		int columnCount = sourceDataSet.getColumnCount();
		for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
			String colunmName = sourceDataSet.getColumn(columnIndex).getName();
			Object columnValue = sourceDataSet.getObject(rowIndex, columnIndex);
			logger.debug("colunmName: {}, columnValue: {}", colunmName,
					columnValue);
			Object[] param = new Object[] { colunmName, columnValue };
			paramList.add(param);
		}
		return paramList.toArray();
		// TODO
	}

	/**
	 * DataSet의 삭제된 데이터 중, 특정 row 데이터를 Map으로 변환한다.
	 * 
	 * @param sourceDataSet
	 *            DataSet
	 * @param rowIndex
	 *            DataSet의 삭제된 데이터 row 위치
	 * @return DataSet의 특정 row 데이터를 받을 Map
	 */
	public static Map<String, Object> convertDeletedDataSetRowToMap(
			DataSet sourceDataSet, int rowIndex) {
		int columnCount = sourceDataSet.getColumnCount();
		Map<String, Object> targetMap = new LinkedHashMap<String, Object>();
		for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
			String colunmName = sourceDataSet.getColumn(columnIndex).getName();
			Object columnValue = sourceDataSet.getRemovedData(rowIndex,
					columnIndex);
			logger.debug("colunmName: {}, columnValue: {}", colunmName,
					columnValue);
			targetMap.put(colunmName, columnValue);
			logger.debug("targetMap: {}", targetMap);
		}
		return targetMap;
	}

	public static Object[] convertDeletedDataSetRowToObjectArray(
			DataSet sourceDataSet, int rowIndex) {
		List<Object[]> paramList = new ArrayList<Object[]>();
		int columnCount = sourceDataSet.getColumnCount();
		for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
			String colunmName = sourceDataSet.getColumn(columnIndex).getName();
			Object columnValue = sourceDataSet.getRemovedData(rowIndex,
					columnIndex);
			logger.debug("colunmName: {}, columnValue: {}", colunmName,
					columnValue);
			Object[] param = new Object[] { colunmName, columnValue };
			paramList.add(param);
		}
		return paramList.toArray();
		// TODO
	}

	/**
	 * DataSet의 특정 row 데이터를 Java Bean으로 변환한다.
	 * 
	 * @param sourceDataSet
	 *            DataSet
	 * @param targetJavaBean
	 *            DataSet의 특정 row 데이터를 받을 Java Bean
	 * @param rowIndex
	 *            DataSet의 row 위치
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public static void convertDataSetRowToJavaBean(DataSet sourceDataSet,
			Object targetJavaBean, int rowIndex) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		int columnCount = sourceDataSet.getColumnCount();
		for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
			String colunmName = sourceDataSet.getColumn(columnIndex).getName();
			Object columnValue = sourceDataSet.getObject(rowIndex, columnIndex);
			logger.debug("colunmName: {}, columnValue: {}", colunmName,
					columnValue);
			PropertyUtils.setSimpleProperty(targetJavaBean, colunmName,
					columnValue);
			logger.debug("targetBean: {}", targetJavaBean);
		}
	}

	/**
	 * DataSet의 삭제된 데이터 중, 특정 row 데이터를 Java Bean으로 변환한다.
	 * 
	 * @param sourceDataSet
	 *            DataSet
	 * @param targetJavaBean
	 *            DataSet의 특정 row 데이터를 받을 Java Bean
	 * @param rowIndex
	 *            DataSet의 삭제된 데이터 row 위치
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public static void convertDeletedDataSetRowToJavaBean(
			DataSet sourceDataSet, Object targetJavaBean, int rowIndex)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		int columnCount = sourceDataSet.getColumnCount();
		for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
			String colunmName = sourceDataSet.getColumn(columnIndex).getName();
			Object columnValue = sourceDataSet.getRemovedData(rowIndex,
					columnIndex);
			logger.debug("colunmName: {}, columnValue: {}", colunmName,
					columnValue);
			PropertyUtils.setSimpleProperty(targetJavaBean, colunmName,
					columnValue);
			logger.debug("targetBean: {}", targetJavaBean);
		}
	}

	/**
	 * DataSet을 Java Bean의 List로 변환한다.
	 * 
	 * @param dataSet
	 *            DataSet
	 * @param javaBeanList
	 *            Java Bean의 List
	 * @param javaBeanClass
	 *            Java Bean의 Class
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("rawtypes")
	public static void convertDataSetToJavaBeanList(DataSet dataSet,
			List<Object> javaBeanList, Class javaBeanClass)
			throws SecurityException, IllegalArgumentException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		int rowCount = dataSet.getRowCount();
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			Object javaBean = convertDataSetRowToJavaBean(dataSet,
					javaBeanClass, rowIndex);
			javaBeanList.add(javaBean);
		}
	}

	@SuppressWarnings("rawtypes")
	public static ChangedDataObjectListDTO convertDataSetToChangedDataObjectListDTO(
			DataSet dataSet, Class javaBeanClass) throws SecurityException,
			IllegalArgumentException, NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		ChangedDataObjectListDTO changedDataDTO = new ChangedDataObjectListDTO();
		List<Object> insertList = new ArrayList<Object>();
		List<Object> updateList = new ArrayList<Object>();
		List<Object> deleteList = new ArrayList<Object>();

		int rowCount = dataSet.getRowCount();
		logger.debug("rowCount: {}", rowCount);
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			int rowType = dataSet.getRowType(rowIndex);
			switch (rowType) {
			case DataSet.ROW_TYPE_INSERTED:
				insertList.add(convertDataSetRowToJavaBean(dataSet,
						javaBeanClass, rowIndex));
				break;
			case DataSet.ROW_TYPE_UPDATED:
				updateList.add(convertDataSetRowToJavaBean(dataSet,
						javaBeanClass, rowIndex));
				break;
			}
		}

		int removedRowCount = dataSet.getRemovedRowCount();
		logger.debug("removedRowCount: {}", removedRowCount);
		for (int rowIndex = 0; rowIndex < removedRowCount; rowIndex++) {
			deleteList.add(convertDeletedDataSetRowToJavaBean(dataSet,
					javaBeanClass, rowIndex));
		}

		changedDataDTO.setInsertedDataList(insertList);
		changedDataDTO.setUpdatedDataList(updateList);
		changedDataDTO.setDeletedDataList(deleteList);
		return changedDataDTO;
	}

	public static ChangedDataMapListDTO convertDataSetToChangedDataMapListDTO(
			DataSet dataSet) throws SecurityException,
			IllegalArgumentException, NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		ChangedDataMapListDTO changedDataMapListDTO = new ChangedDataMapListDTO();
		List<Map<String, Object>> insertList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> updateList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> deleteList = new ArrayList<Map<String, Object>>();

		int rowCount = dataSet.getRowCount();
		logger.debug("rowCount: {}", rowCount);
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			int rowType = dataSet.getRowType(rowIndex);
			switch (rowType) {
			case DataSet.ROW_TYPE_INSERTED:
				insertList.add(convertDataSetRowToMap(dataSet, rowIndex));
				break;
			case DataSet.ROW_TYPE_UPDATED:
				updateList.add(convertDataSetRowToMap(dataSet, rowIndex));
				break;
			}
		}

		int removedRowCount = dataSet.getRemovedRowCount();
		logger.debug("removedRowCount: {}", removedRowCount);
		for (int rowIndex = 0; rowIndex < removedRowCount; rowIndex++) {
			deleteList.add(convertDeletedDataSetRowToMap(dataSet, rowIndex));
		}

		changedDataMapListDTO.setInsertedDataList(insertList);
		changedDataMapListDTO.setUpdatedDataList(updateList);
		changedDataMapListDTO.setDeletedDataList(deleteList);
		return changedDataMapListDTO;
		// TODO
	}

	public static ChangedDataObjectArrayListDTO convertDataSetToChangedDataObjectArrayListDTO(
			DataSet dataSet) throws SecurityException,
			IllegalArgumentException, NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		ChangedDataObjectArrayListDTO changedDataObjectArrayListDTO = new ChangedDataObjectArrayListDTO();
		List<Object[]> insertList = new ArrayList<Object[]>();
		List<Object[]> updateList = new ArrayList<Object[]>();
		List<Object[]> deleteList = new ArrayList<Object[]>();

		int rowCount = dataSet.getRowCount();
		logger.debug("rowCount: {}", rowCount);
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			int rowType = dataSet.getRowType(rowIndex);
			switch (rowType) {
			case DataSet.ROW_TYPE_INSERTED:
				insertList
						.add(convertDataSetRowToObjectArray(dataSet, rowIndex));
				break;
			case DataSet.ROW_TYPE_UPDATED:
				updateList
						.add(convertDataSetRowToObjectArray(dataSet, rowIndex));
				break;
			}
		}

		int removedRowCount = dataSet.getRemovedRowCount();
		logger.debug("removedRowCount: {}", removedRowCount);
		for (int rowIndex = 0; rowIndex < removedRowCount; rowIndex++) {
			deleteList.add(convertDeletedDataSetRowToObjectArray(dataSet,
					rowIndex));
		}

		changedDataObjectArrayListDTO.setInsertedDataList(insertList);
		changedDataObjectArrayListDTO.setUpdatedDataList(updateList);
		changedDataObjectArrayListDTO.setDeletedDataList(deleteList);
		return changedDataObjectArrayListDTO;
		// TODO
	}

	/**
	 * DataSet을 Java Bean의 List로 변환한다.
	 * 
	 * @param dataSet
	 *            DataSet
	 * @param javaBeanClass
	 *            Java Bean의 Class
	 * @return Java Bean의 List
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("rawtypes")
	public static List<Object> convertDataSetToJavaBeanList(DataSet dataSet,
			Class javaBeanClass) throws SecurityException,
			IllegalArgumentException, NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		List<Object> javaBeanList = new ArrayList<Object>();
		int rowCount = dataSet.getRowCount();
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			Object javaBean = convertDataSetRowToJavaBean(dataSet,
					javaBeanClass, rowIndex);
			javaBeanList.add(javaBean);
		}
		return javaBeanList;
	}

	/**
	 * DataSet을 Map의 List로 변환한다.
	 * 
	 * @param dataSet
	 *            DataSet
	 * @param mapList
	 *            Map의 List
	 */
	public static void convertDataSetToMapList(DataSet dataSet,
			List<Map<String, Object>> mapList) {
		int rowCount = dataSet.getRowCount();
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			Map<String, Object> dataMap = convertDataSetRowToMap(dataSet,
					rowIndex);
			mapList.add(dataMap);
		}
	}

	/**
	 * DataSetList를 Java Bean List의 Map으로 변환한다.<br/>
	 * Map의 key는 DataSet의 이름이고 Map의 value는 Java Bean의 List이다.
	 * 
	 * @param dataSetList
	 *            DataSetList
	 * @param targetJavaBeanClass
	 *            Java Bean의 Class
	 * @return Java Bean의 List
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, List<Object>> convertDataSetListToJavaBeanListMap(
			DataSetList dataSetList, Class targetJavaBeanClass)
			throws SecurityException, IllegalArgumentException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		Map<String, List<Object>> javaBeanListMap = new LinkedHashMap<String, List<Object>>();
		int dataSetListCount = dataSetList.size();
		for (int dataSetListIndex = 0; dataSetListIndex < dataSetListCount; dataSetListIndex++) {
			DataSet dataSet = dataSetList.get(dataSetListIndex);
			String dataSetName = dataSet.getName();
			List<Object> javaBeanList = convertDataSetToJavaBeanList(dataSet,
					targetJavaBeanClass);
			logger.debug("dataSetName: {}, javaBeanList: {}", dataSetName,
					javaBeanList);
			javaBeanListMap.put(dataSetName, javaBeanList);
		}
		return javaBeanListMap;
		// TODO
	}

	/**
	 * DataSetList를 Map List의 Map으로 변환한다.<br/>
	 * Map의 key는 DataSet의 이름이고 Map의 value는 Map의 List이다.
	 * 
	 * @param dataSetList
	 *            DataSetList
	 * @return
	 */
	public static Map<String, List<Map<String, Object>>> convertDataSetListToMapListMap(
			DataSetList dataSetList) {
		Map<String, List<Map<String, Object>>> mapListMap = new LinkedHashMap<String, List<Map<String, Object>>>();
		int dataSetListCount = dataSetList.size();
		for (int dataSetListIndex = 0; dataSetListIndex < dataSetListCount; dataSetListIndex++) {
			DataSet dataSet = dataSetList.get(dataSetListIndex);
			String dataSetName = dataSet.getName();
			List<Map<String, Object>> mapList = convertDataSetToMapList(dataSet);
			logger.debug("dataSetName: {}, mapList: {}", dataSetName, mapList);
			mapListMap.put(dataSetName, mapList);
		}
		return mapListMap;
		// TODO
	}

	/**
	 * DataSet을 Map의 List로 변환한다.
	 * 
	 * @param dataSet
	 *            DataSet
	 * @return Map의 List
	 */
	public static List<Map<String, Object>> convertDataSetToMapList(
			DataSet dataSet) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		int rowCount = dataSet.getRowCount();
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			Map<String, Object> dataMap = convertDataSetRowToMap(dataSet,
					rowIndex);
			mapList.add(dataMap);
		}
		return mapList;
	}

	/**
	 * Java Bean의 List를 DataSet으로 변환한다.
	 * 
	 * @param javaBeanList
	 *            Java Bean의 List
	 * @param dataSet
	 *            DataSet
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static void convertJavaBeanListToDataSet(List<Object> javaBeanList,
			DataSet dataSet) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		int beanCount = javaBeanList.size();
		for (int beanIndex = 0; beanIndex < beanCount; beanIndex++) {
			Object bean = javaBeanList.get(beanIndex);
			convertJavaBeanToDataSetRow(bean, dataSet, beanIndex);
		}
	}

	/**
	 * Java Bean의 List를 DataSet으로 변환한다.
	 * 
	 * @param javaBeanList
	 *            Java Bean의 List
	 * @return DataSet
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static DataSet convertJavaBeanListToDataSet(List<Object> javaBeanList)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		DataSet dataSet = new DataSet();
		int beanCount = javaBeanList.size();
		for (int beanIndex = 0; beanIndex < beanCount; beanIndex++) {
			Object bean = javaBeanList.get(beanIndex);
			if (beanIndex == 0) {
				XplatformUtils.setColumnHeaderByJavaBeanClass(bean.getClass(),
						dataSet);
			}
			convertJavaBeanToDataSetRow(bean, dataSet, beanIndex);
		}
		return dataSet;
	}

	/**
	 * Java Bean의 List를 DataSet으로 변환한다.
	 * 
	 * @param javaBeanList
	 *            Java Bean의 List
	 * @param dataSetName
	 *            DataSet의 이름
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static DataSet convertJavaBeanListToDataSet(
			List<Object> javaBeanList, String dataSetName)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		DataSet dataSet = convertJavaBeanListToDataSet(javaBeanList);
		dataSet.setName(dataSetName);
		return dataSet;
	}

	/**
	 * Java Bean의 List를 DataSetList에 추가한다.
	 * 
	 * @param javaBeanList
	 *            Java Bean의 List
	 * @param dataSetName
	 *            DataSet의 이름
	 * @param dataSetList
	 *            DataSetList
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static void addJavaBeanListToDataSetList(List<Object> javaBeanList,
			String dataSetName, DataSetList dataSetList)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		DataSet dataSet = convertJavaBeanListToDataSet(javaBeanList);
		dataSet.setName(dataSetName);
		dataSetList.add(dataSet);
		// TODO
	}

	/**
	 * Map의 List를 DataSet으로 변환한다.
	 * 
	 * @param mapList
	 *            Map의 List
	 * @param dataSet
	 *            DataSet
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static void convertMapListToDataSet(
			List<Map<String, Object>> mapList, DataSet dataSet)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		int mapCount = mapList.size();
		for (int mapIndex = 0; mapIndex < mapCount; mapIndex++) {
			Map<String, Object> dataMap = mapList.get(mapIndex);
			convertMapToDataSetRow(dataMap, dataSet, mapIndex);
		}
	}

	/**
	 * Map의 List를 DataSet으로 변환한다.
	 * 
	 * @param mapList
	 *            Map의 List
	 * @return DataSet
	 */
	public static DataSet convertMapListToDataSet(
			List<Map<String, Object>> mapList) {
		DataSet dataSet = new DataSet();
		int mapCount = mapList.size();
		for (int mapIndex = 0; mapIndex < mapCount; mapIndex++) {
			Map<String, Object> dataMap = mapList.get(mapIndex);
			if (mapIndex == 0) {
				setColumnHeaderByMap(dataMap, dataSet);
			}
			convertMapToDataSetRow(dataMap, dataSet, mapIndex);
		}
		return dataSet;
	}

	/**
	 * Map의 List를 DataSet으로 변환한다.
	 * 
	 * @param mapList
	 *            Map의 List
	 * @param dataSetName
	 *            DataSet의 이름
	 * @return DataSet
	 */
	public static DataSet convertMapListToDataSet(
			List<Map<String, Object>> mapList, String dataSetName) {
		DataSet dataSet = convertMapListToDataSet(mapList);
		dataSet.setName(dataSetName);
		return dataSet;
	}

	public static void addMapListToDataSetList(
			List<Map<String, Object>> mapList, String dataSetName,
			DataSetList dataSetList) {
		DataSet dataSet = convertMapListToDataSet(mapList);
		dataSet.setName(dataSetName);
		dataSetList.add(dataSet);
	}

	/**
	 * DataSet의 특정 row 데이터를 Java Bean으로 변환한다.
	 * 
	 * @param sourceDataSet
	 *            DataSet
	 * @param targetJavaBeanClass
	 *            DataSet의 특정 row 데이터를 받을 Java Bean의 Class
	 * @param rowIndex
	 *            DataSet의 row 위치
	 * @return DataSet의 특정 row 데이터를 받을 Java Bean
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object convertDataSetRowToJavaBean(DataSet sourceDataSet,
			Class targetJavaBeanClass, int rowIndex) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		Constructor constructor = targetJavaBeanClass
				.getConstructor(new Class[] {});
		Object targetJavaBean = constructor.newInstance(new Object[] {});
		int columnCount = sourceDataSet.getColumnCount();
		for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
			String colunmName = sourceDataSet.getColumn(columnIndex).getName();
			Object columnValue = sourceDataSet.getObject(rowIndex, columnIndex);
			logger.debug("colunmName: {}, columnValue: {}", colunmName,
					columnValue);
			PropertyUtils.setSimpleProperty(targetJavaBean, colunmName,
					columnValue);
			logger.debug("targetBean: {}", targetJavaBean);
		}
		return targetJavaBean;
	}

	/**
	 * DataSet의 삭제된 데이터 중, 특정 row 데이터를 Java Bean으로 변환한다.
	 * 
	 * @param sourceDataSet
	 *            DataSet
	 * @param targetJavaBeanClass
	 *            DataSet의 특정 row 데이터를 받을 Java Bean의 Class
	 * @param rowIndex
	 *            DataSet의 삭제된 데이터 row 위치
	 * @return DataSet의 특정 row 데이터를 받을 Java Bean
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object convertDeletedDataSetRowToJavaBean(
			DataSet sourceDataSet, Class targetJavaBeanClass, int rowIndex)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		Constructor constructor = targetJavaBeanClass
				.getConstructor(new Class[] {});
		Object targetJavaBean = constructor.newInstance(new Object[] {});
		int columnCount = sourceDataSet.getColumnCount();
		for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
			String colunmName = sourceDataSet.getColumn(columnIndex).getName();
			Object columnValue = sourceDataSet.getRemovedData(rowIndex,
					columnIndex);
			logger.debug("colunmName: {}, columnValue: {}", colunmName,
					columnValue);
			PropertyUtils.setSimpleProperty(targetJavaBean, colunmName,
					columnValue);
			logger.debug("targetBean: {}", targetJavaBean);
		}
		return targetJavaBean;
	}

	/**
	 * Java Bean을 DataSet의 특정 row 데이터로 변환한다.
	 * 
	 * @param sourceJavaBean
	 *            컬럼 명을 property로 가지는 Java Bean
	 * @param targetDataSet
	 *            DataSet
	 * @param rowIndex
	 *            DataSet의 row 위치
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public static void convertJavaBeanToDataSetRow(Object sourceJavaBean,
			DataSet targetDataSet, int rowIndex) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		@SuppressWarnings("unchecked")
		Map<String, Object> propertiesMap = PropertyUtils
				.describe(sourceJavaBean);
		propertiesMap.remove("class");
		convertMapToDataSetRow(propertiesMap, targetDataSet, rowIndex);
	}

	/**
	 * Java Bean을 DataSet의 특정 row 데이터로 변환한다.
	 * 
	 * @param sourceJavaBean
	 *            컬럼 명을 property로 가지는 Java Bean
	 * @return DataSet
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static DataSet convertJavaBeanToDataSet(Object sourceJavaBean)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		DataSet targetDataSet = new DataSet();
		setColumnHeaderByJavaBeanClass(sourceJavaBean.getClass(), targetDataSet);
		@SuppressWarnings("unchecked")
		Map<String, Object> propertiesMap = PropertyUtils
				.describe(sourceJavaBean);
		propertiesMap.remove("class");
		convertMapToDataSetRow(propertiesMap, targetDataSet, 0);
		return targetDataSet;
	}

	/**
	 * Java Bean을 DataSet의 특정 row 데이터로 변환한다.
	 * 
	 * @param sourceJavaBean
	 *            컬럼 명을 property로 가지는 Java Bean
	 * @param dataSetName
	 *            생성할 DataSet 이름
	 * @return DataSet
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static DataSet convertJavaBeanToDataSet(Object sourceJavaBean,
			String dataSetName) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		DataSet targetDataSet = convertJavaBeanToDataSet(sourceJavaBean);
		targetDataSet.setName(dataSetName);
		return targetDataSet;
	}

	/**
	 * Java Bean을 Variable List로 변환한다.
	 * 
	 * @param sourceJavaBean
	 *            컬럼 명을 property로 가지는 Java Bean
	 * @param targetVariableList
	 *            Variable List
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static void addJavaBeanToVariableList(Object sourceJavaBean,
			VariableList targetVariableList) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		@SuppressWarnings("unchecked")
		Map<String, Object> propertiesMap = PropertyUtils
				.describe(sourceJavaBean);
		propertiesMap.remove("class");
		addMapToVariableList(propertiesMap, targetVariableList);
	}

	/**
	 * Java Bean을 Variable List로 변환한다.
	 * 
	 * @param sourceJavaBean
	 *            컬럼 명을 property로 가지는 Java Bean
	 * @return Variable List
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static VariableList convertJavaBeanToVariableList(
			Object sourceJavaBean) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		VariableList targetVariableList = new VariableList();
		@SuppressWarnings("unchecked")
		Map<String, Object> propertiesMap = PropertyUtils
				.describe(sourceJavaBean);
		propertiesMap.remove("class");
		addMapToVariableList(propertiesMap, targetVariableList);
		return targetVariableList;
	}

	/**
	 * Variable List의 데이터를 Map으로 변환한다.
	 * 
	 * @param sourceVariableList
	 *            Variable List
	 * @param targetMap
	 *            Variable List의 데이터를 받을 Map
	 */
	public static void convertVariableListToMap(
			VariableList sourceVariableList, Map<String, Object> targetMap) {
		int variableCount = sourceVariableList.size();
		for (int variableIndex = 0; variableIndex < variableCount; variableIndex++) {
			Variable variable = sourceVariableList.get(variableIndex);
			String variableName = variable.getName();
			Object variableValue = variable.getObject();
			logger.debug("variableName: {}, variableValue: {}", variableName,
					variableValue);
			targetMap.put(variableName, variableValue);
			logger.debug("targetMap: {}", targetMap);
		}
	}

	/**
	 * Variable List의 데이터를 Map으로 변환한다.
	 * 
	 * @param sourceVariableList
	 *            Variable List
	 * @return Variable List의 데이터를 받을 Map
	 */
	public static Map<String, Object> convertVariableListToMap(
			VariableList sourceVariableList) {
		Map<String, Object> targetMap = new LinkedHashMap<String, Object>();
		int variableCount = sourceVariableList.size();
		for (int variableIndex = 0; variableIndex < variableCount; variableIndex++) {
			Variable variable = sourceVariableList.get(variableIndex);
			String variableName = variable.getName();
			Object variableValue = variable.getObject();
			logger.debug("variableName: {}, variableValue: {}", variableName,
					variableValue);
			targetMap.put(variableName, variableValue);
			logger.debug("targetMap: {}", targetMap);
		}
		return targetMap;
	}

	/**
	 * Map을 Variable List로 변환한다.
	 * 
	 * @param sourceMap
	 *            Map
	 * @param targetVariableList
	 *            Map의 데이터를 받을 Variable List
	 */
	public static void addMapToVariableList(Map<String, Object> sourceMap,
			VariableList targetVariableList) {
		Set<String> keySet = sourceMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object value = sourceMap.get(key);
			logger.debug("key: {}, value: {}", key, value);
			targetVariableList.add(key, value);
		}
	}

	/**
	 * Map을 Variable List로 변환한다.
	 * 
	 * @param sourceMap
	 *            Map
	 * @return Map의 데이터를 받을 Variable List
	 */
	public static VariableList convertMapToVariableList(
			Map<String, Object> sourceMap) {
		VariableList targetVariableList = new VariableList();
		Set<String> keySet = sourceMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object value = sourceMap.get(key);
			logger.debug("key: {}, value: {}", key, value);
			targetVariableList.add(key, value);
		}
		return targetVariableList;
	}

	/**
	 * Variable List의 데이터를 Java Bean으로 변환한다.
	 * 
	 * @param sourceVariableList
	 *            Variable List
	 * @param targetJavaBean
	 *            Variable List의 데이터를 받을 Java Bean
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public static void convertVariableListToJavaBean(
			VariableList sourceVariableList, Object targetJavaBean)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		int variableCount = sourceVariableList.size();
		logger.debug("variableCount: {}", variableCount);
		for (int variableIndex = 0; variableIndex < variableCount; variableIndex++) {
			Variable variable = sourceVariableList.get(variableIndex);
			logger.debug("variable: {}", variable);
			String variableName = variable.getName();
			Object variableValue = variable.getObject();
			logger.debug("variableName: {}, variableValue: {}", variableName,
					variableValue);
			PropertyUtils.setSimpleProperty(targetJavaBean, variableName,
					variableValue);
			logger.debug("targetBean: {}", targetJavaBean);
		}
	}

	/**
	 * Variable List의 데이터를 Java Bean으로 변환한다.
	 * 
	 * @param sourceVariableList
	 *            Variable List
	 * @param targetJavaBeanClass
	 *            Variable List의 데이터를 받을 Java Bean의 Class
	 * @return Variable List의 데이터를 받을 Java Bean의 Object
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object convertVariableListToJavaBean(
			VariableList sourceVariableList, Class targetJavaBeanClass)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, IllegalArgumentException,
			InstantiationException {
		Constructor constructor = targetJavaBeanClass
				.getConstructor(new Class[] {});
		Object targetJavaBean = constructor.newInstance(new Object[] {});
		int variableCount = sourceVariableList.size();
		logger.debug("variableCount: {}", variableCount);
		for (int variableIndex = 0; variableIndex < variableCount; variableIndex++) {
			Variable variable = sourceVariableList.get(variableIndex);
			logger.debug("variable: {}", variable);
			String variableName = variable.getName();
			Object variableValue = variable.getObject();
			logger.debug("variableName: {}, variableValue: {}", variableName,
					variableValue);
			PropertyUtils.setSimpleProperty(targetJavaBean, variableName,
					variableValue);
			logger.debug("targetBean: {}", targetJavaBean);
		}
		return targetJavaBean;
	}

	/**
	 * 에러 코드와 에러 메시지가 설정된 Variable List를 가져온다.
	 * 
	 * @param code
	 *            에러 코드
	 * @param message
	 *            에러 메시지
	 * @return 에러 코드와 에러 메시지가 설정된 Variable List
	 */
	public static VariableList getVariableList(int code, String message) {
		VariableList variableList = new VariableList();
		setMessage(code, message, variableList);
		return variableList;
	}

	/**
	 * Variable List에 에러 코드와 에러 메시지를 설정한다.
	 * 
	 * @param code
	 *            에러 코드
	 * @param message
	 *            에러 메시지
	 * @param variableList
	 *            에러 코드와 에러 메시지를 설정할 Variable List
	 */
	public static void setMessage(int code, String message,
			VariableList variableList) {
		variableList.add(ERROR_CODE, code);
		variableList.add(ERROR_MESSAGE, message);
	}

	/**
	 * Variable List에 에러 코드를 설정한다.
	 * 
	 * @param code
	 *            에러 코드
	 * @param variableList
	 *            에러 코드를 설정할 Variable List
	 */
	public static void setMessage(int code, VariableList variableList) {
		variableList.add(ERROR_CODE, code);
	}

	/**
	 * Variable List에 에러 메시지를 설정한다.
	 * 
	 * @param message
	 *            에러 메시지
	 * @param variableList
	 *            에러 메시지를 설정할 Variable List
	 */
	public static void setMessage(String message, VariableList variableList) {
		variableList.add(ERROR_MESSAGE, message);
	}

	/**
	 * Variable List에 성공 메시지를 설정한다.<br/>
	 * 에러 코드는 기본적으로 0을 사용한다.
	 * 
	 * @param message
	 *            성공 메시지
	 * @param variableList
	 *            성공 메시지를 설정할 Variable List
	 */
	public static void setSuccessMessage(String message,
			VariableList variableList) {
		variableList.add(ERROR_CODE, SUCCESS_CODE);
		variableList.add(ERROR_MESSAGE, message);
	}

	/**
	 * Variable List에 실패 메시지를 설정한다.<br/>
	 * 에러 코드는 기본적으로 -1을 사용한다.
	 * 
	 * @param message
	 *            실패 메시지
	 * @param variableList
	 *            실패 메시지를 설정할 Variable List
	 */
	public static void setFailureMessage(String message,
			VariableList variableList) {
		variableList.add(ERROR_CODE, FAILURE_CODE);
		variableList.add(ERROR_MESSAGE, message);
	}
}
