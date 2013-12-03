package javax.validation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.codelabor.example.validation.dto.PersonDto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidatorTest {

	private static Logger logger = LoggerFactory.getLogger(ValidatorTest.class);
	private static Validator validator;
	private PersonDto personDto = null;

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
	public final void testValidateSource() throws Exception {
		String username = "ob1";
		String password = "1234qwer";
		String firstName = "Obi-Wan";
		String lastName = "Kenobi";
		String email = "xxxx@xxx.xxx";
		String phone = "+82-10-1111-1111";
		String zipCode = "000000";
		Date birthDate = (new SimpleDateFormat("yyyy-MM-dd"))
				.parse("1900-01-01");

		personDto = new PersonDto();
		personDto.setUsername(username);
		personDto.setPassword(password);
		personDto.setFirstName(firstName);
		personDto.setLastName(lastName);
		personDto.setEmail(email);
		personDto.setPhone(phone);
		personDto.setZipCode(zipCode);
		personDto.setBirthDate(birthDate);

		Set<ConstraintViolation<PersonDto>> constraintViolations = validator
				.validate(personDto);

		logger.debug("violation count: {}", constraintViolations.size());

		for (ConstraintViolation<?> violation : constraintViolations) {
			logger.debug("message: {}", violation.getMessage());
		}

		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public final void testValidateSource2() throws Exception {
		String username = "ob1ob1ob1";
		String password = "1234qwer";
		String firstName = "Obi-Wan";
		String lastName = "Kenobi";
		String email = "xxxx@xxx.xxx";
		String phone = "+82-10-1111-1111";
		String zipCode = "000000";
		Date birthDate = (new SimpleDateFormat("yyyy-MM-dd"))
				.parse("2020-01-01");

		personDto = new PersonDto();
		personDto.setUsername(username);
		personDto.setPassword(password);
		personDto.setFirstName(firstName);
		personDto.setLastName(lastName);
		personDto.setEmail(email);
		personDto.setPhone(phone);
		personDto.setZipCode(zipCode);
		personDto.setBirthDate(birthDate);

		Set<ConstraintViolation<PersonDto>> constraintViolations = validator
				.validate(personDto);

		logger.debug("violation count: {}", constraintViolations.size());

		for (ConstraintViolation<?> violation : constraintViolations) {
			logger.debug("message: {}", violation.getMessage());
		}

		Assert.assertEquals(2, constraintViolations.size());
	}

}
