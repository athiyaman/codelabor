package org.codelabor.system.web.servlet.view.xplatform;

import static org.codelabor.system.web.xplatform.XplatformConstants.OUTPUT_DATA_SET_LIST;
import static org.codelabor.system.web.xplatform.XplatformConstants.OUTPUT_VARIABLE_LIST;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

import com.tobesoft.xplatform.data.DataSetList;
import com.tobesoft.xplatform.data.PlatformData;
import com.tobesoft.xplatform.data.VariableList;
import com.tobesoft.xplatform.tx.HttpPlatformResponse;
import com.tobesoft.xplatform.util.StringUtils;

/**
 * Xplatform View 클래스
 * 
 * @author Shin Sang-jae
 * 
 */
public class XplatformView extends AbstractView {

	/**
	 * 로거
	 */
	private Logger logger = LoggerFactory.getLogger(XplatformView.class);
	/**
	 * 출력 DataSetList 이름
	 */
	private String outputDataSetListName = OUTPUT_DATA_SET_LIST;
	/**
	 * 출력 VariableList 이름
	 */
	private String outputVariableListName = OUTPUT_VARIABLE_LIST;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.view.AbstractView#renderMergedOutputModel
	 * (java.util.Map, javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpPlatformResponse httpPlatformResponse = new HttpPlatformResponse(
				response);
		PlatformData outputPlatformData = new PlatformData();

		DataSetList outputDataSetList = (DataSetList) model
				.get(outputDataSetListName);
		VariableList outputVariableList = (VariableList) model
				.get(outputVariableListName);

		if (outputDataSetList == null) {
			outputDataSetList = new DataSetList();
		}
		if (outputVariableList == null) {
			outputVariableList = new VariableList();
		}

		// log
		logger.debug("outputDataSetList: {}", outputDataSetList);
		logger.debug("outputVariableList: {}", outputVariableList);

		// set platform data
		outputPlatformData.setDataSetList(outputDataSetList);
		outputPlatformData.setVariableList(outputVariableList);
		httpPlatformResponse.setData(outputPlatformData);
		httpPlatformResponse.sendData();
	}

	/**
	 * @param outputDataSetListName
	 *            the outputDataSetListName to set
	 */
	public void setOutputDataSetListName(String outputDataSetListName) {
		if (!StringUtils.isEmpty(outputDataSetListName)) {
			this.outputDataSetListName = outputDataSetListName;
		}
	}

	/**
	 * @param outputVariableListName
	 *            the outputVariableListName to set
	 */
	public void setOutputVariableListName(String outputVariableListName) {
		if (!StringUtils.isEmpty(outputVariableListName)) {
			this.outputVariableListName = outputVariableListName;
		}
	}
}
