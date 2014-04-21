package javax.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.codelabor.example.validation.hibernate.safeHtml.dto.SafeHtmlWhitelistNoneDto;
import org.codelabor.example.validation.hibernate.safeHtml.dto.SafeHtmlWhitelistRelexedAdditionalTagsDto;
import org.codelabor.example.validation.hibernate.safeHtml.dto.SafeHtmlWhitelistRelexedDto;
import org.codelabor.example.validation.hibernate.safeHtml.dto.StringListDto;
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
	public final void testSafehtmlWhitelistRelexed() throws Exception {
		SafeHtmlWhitelistRelexedDto safeHtmlWhitelistRelexedDto = new SafeHtmlWhitelistRelexedDto();
		safeHtmlWhitelistRelexedDto.setStringData1("<div>1234qwer</div>");

		Set<ConstraintViolation<SafeHtmlWhitelistRelexedDto>> constraintViolations = validator
				.validate(safeHtmlWhitelistRelexedDto);
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

		safeHtmlWhitelistRelexedDto.setStringData1("<span>1234qwer</span>");

		constraintViolations = validator
				.validate(safeHtmlWhitelistRelexedDto);
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
	public final void testSafehtmlWhitelistRelexedAdditionalTags() throws Exception {
		SafeHtmlWhitelistRelexedAdditionalTagsDto safeHtmlWhitelistRelexedAdditionalTagsDto = new SafeHtmlWhitelistRelexedAdditionalTagsDto();
		safeHtmlWhitelistRelexedAdditionalTagsDto.setStringData1("<div>1234qwer</div>");

		Set<ConstraintViolation<SafeHtmlWhitelistRelexedAdditionalTagsDto>> constraintViolations = validator
				.validate(safeHtmlWhitelistRelexedAdditionalTagsDto);
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
		Assert.assertEquals(0, constraintViolations.size());

		safeHtmlWhitelistRelexedAdditionalTagsDto.setStringData1("<span>1234qwer</span>");

		constraintViolations = validator
				.validate(safeHtmlWhitelistRelexedAdditionalTagsDto);
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
		Assert.assertEquals(0, constraintViolations.size());
	}


	@Test
	public final void testNotEmpty1() throws Exception {
		StringListDto stringListDto = new StringListDto();

		List<String> stringListData = new ArrayList<String>();
		stringListData.add("<h1>heading1</h1>");
		stringListDto.setStringListData(stringListData);

		Set<ConstraintViolation<StringListDto>> constraintViolations = validator
				.validate(stringListDto);
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
		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public final void testNotEmpty2() throws Exception {
		StringListDto stringListDto = new StringListDto();

		List<String> stringListData = new ArrayList<String>();
		stringListDto.setStringListData(stringListData);

		Set<ConstraintViolation<StringListDto>> constraintViolations = validator
				.validate(stringListDto);
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
	public final void testNotEmpty3() throws Exception {
		StringListDto stringListDto = new StringListDto();

		List<String> stringListData = null;
		stringListDto.setStringListData(stringListData);

		Set<ConstraintViolation<StringListDto>> constraintViolations = validator
				.validate(stringListDto);
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


}
