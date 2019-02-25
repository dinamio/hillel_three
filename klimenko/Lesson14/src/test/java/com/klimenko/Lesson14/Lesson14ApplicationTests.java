package com.klimenko.Lesson14;

import com.klimenko.Lesson14.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Lesson14ApplicationTests {

	private Validator validator;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	@Test
	public void testContactSuccess() {

		User user = new User();
		user.setEmail("Ivan@");
		user.setName("Ivan");
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		Assert.assertFalse(violations.isEmpty());
	}

}

