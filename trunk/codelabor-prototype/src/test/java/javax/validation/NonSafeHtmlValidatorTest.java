package javax.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.codelabor.example.validation.hibernate.safeHtml.dto.NonSafeHtmlBlacklistScriptDto;
import org.codelabor.example.validation.hibernate.safeHtml.dto.SafeHtmlWhitelistNoneDto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NonSafeHtmlValidatorTest {

	private static final Logger logger = LoggerFactory
			.getLogger(NonSafeHtmlValidatorTest.class);
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
	public final void testNonSafehtmlBlacklist() throws Exception {
		NonSafeHtmlBlacklistScriptDto nonSafeHtmlBlacklistScriptDto = new NonSafeHtmlBlacklistScriptDto();
		nonSafeHtmlBlacklistScriptDto.setStringData1("<script>1234qwer</script>");
		Set<ConstraintViolation<NonSafeHtmlBlacklistScriptDto>> constraintViolations = validator
				.validate(nonSafeHtmlBlacklistScriptDto);
		logger.error("violation count: {}", constraintViolations.size());

		for (ConstraintViolation<?> violation : constraintViolations) {
			logger.error("");
			logger.error("executableParameters: {}",
					violation.getExecutableParameters());
			logger.error("executableReturnValue: {}",
					violation.getExecutableReturnValue());
			logger.error("constraintDescriptor: {}",
					violation.getConstraintDescriptor());
			logger.error("propertyPath: {}", violation.getPropertyPath());
			logger.error("invalidValue: {}", violation.getInvalidValue());
			logger.error("message: {}", violation.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size());


		nonSafeHtmlBlacklistScriptDto = new NonSafeHtmlBlacklistScriptDto();
		nonSafeHtmlBlacklistScriptDto.setStringData1("<form>1234qwer</form>");
		constraintViolations = validator
				.validate(nonSafeHtmlBlacklistScriptDto);
		logger.error("violation count: {}", constraintViolations.size());

		for (ConstraintViolation<?> violation : constraintViolations) {
			logger.error("");
			logger.error("executableParameters: {}",
					violation.getExecutableParameters());
			logger.error("executableReturnValue: {}",
					violation.getExecutableReturnValue());
			logger.error("constraintDescriptor: {}",
					violation.getConstraintDescriptor());
			logger.error("propertyPath: {}", violation.getPropertyPath());
			logger.error("invalidValue: {}", violation.getInvalidValue());
			logger.error("message: {}", violation.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size());


		nonSafeHtmlBlacklistScriptDto = new NonSafeHtmlBlacklistScriptDto();
		List<String> stringListData1 = new ArrayList<String>();
		stringListData1.add("<script>1234qwer</script>");
		stringListData1.add("<form>1234qwer</form>");
		nonSafeHtmlBlacklistScriptDto.setStringListData1(stringListData1);
		constraintViolations = validator
				.validate(nonSafeHtmlBlacklistScriptDto);
		logger.error("violation count: {}", constraintViolations.size());

		for (ConstraintViolation<?> violation : constraintViolations) {
			logger.error("");
			logger.error("executableParameters: {}",
					violation.getExecutableParameters());
			logger.error("executableReturnValue: {}",
					violation.getExecutableReturnValue());
			logger.error("constraintDescriptor: {}",
					violation.getConstraintDescriptor());
			logger.error("propertyPath: {}", violation.getPropertyPath());
			logger.error("invalidValue: {}", violation.getInvalidValue());
			logger.error("message: {}", violation.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size());
	}

}
