package javax.validation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.codelabor.example.validation.dto.PersonDto;
import org.codelabor.example.validation.hibernate.safeHtml.dto.HtmlContents1Dto;
import org.codelabor.example.validation.hibernate.safeHtml.dto.SafeHtmlWhitelistNoneDto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateValidatorTest {

	private static final Logger logger = LoggerFactory
			.getLogger(HibernateValidatorTest.class);
	private static Validator validator;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private PersonDto personDto = null;

	@Before
	public void setUp() throws Exception {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSafehtmlWhitelistNone() throws Exception {
		SafeHtmlWhitelistNoneDto safeHtmlWhitelistNoneDto = new SafeHtmlWhitelistNoneDto();
		safeHtmlWhitelistNoneDto.setStringData1("<td>1234qwer</td>");

		Set<ConstraintViolation<SafeHtmlWhitelistNoneDto>> constraintViolations = validator
				.validate(safeHtmlWhitelistNoneDto);
		logger.error("violation count: {}", constraintViolations.size());

		for (ConstraintViolation<?> violation : constraintViolations) {
			logger.error("");
			logger.error("executableParameters: {}", violation.getExecutableParameters());
			logger.error("executableReturnValue: {}", violation.getExecutableReturnValue());
			logger.error("constraintDescriptor: {}", violation.getConstraintDescriptor());
			logger.error("propertyPath: {}", violation.getPropertyPath());
			logger.error("invalidValue: {}", violation.getInvalidValue());
			logger.error("message: {}", violation.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size());
	}


	@Test
	public final void testSafehtml1() throws Exception {
		HtmlContents1Dto htmlContents1Dto = new HtmlContents1Dto();
		htmlContents1Dto.setStringData1("<h1>heading1</h1>");
		htmlContents1Dto.setStringData2("<h1>heading1</h1>");
		htmlContents1Dto.setStringData3("<h1>heading1</h1>");
		htmlContents1Dto.setStringData4("<h1>heading1</h1>");
		htmlContents1Dto.setStringData5("<h1>heading1</h1>");

		List<String> stringListData = new ArrayList<String>();
		//stringListData.add("<h1>heading1</h1>");
		htmlContents1Dto.setStringListData(stringListData);

		Set<ConstraintViolation<HtmlContents1Dto>> constraintViolations = validator
				.validate(htmlContents1Dto);
		logger.error("violation count: {}", constraintViolations.size());

		for (ConstraintViolation<?> violation : constraintViolations) {
			logger.error("");
			logger.error("executableParameters: {}", violation.getExecutableParameters());
			logger.error("executableReturnValue: {}", violation.getExecutableReturnValue());
			logger.error("constraintDescriptor: {}", violation.getConstraintDescriptor());
			logger.error("propertyPath: {}", violation.getPropertyPath());
			logger.error("invalidValue: {}", violation.getInvalidValue());
			logger.error("message: {}", violation.getMessage());
		}
		Assert.assertEquals(4, constraintViolations.size());
	}


}
