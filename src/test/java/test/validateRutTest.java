package test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.demo.validators.RutValidator;


public class validateRutTest {
	
	@Test
	public void validateRut() {
		assertTrue(RutValidator.isValid("26397219-8"));
	}
	
	@Test
	public void validateInvalidRut() {
		assertFalse(RutValidator.isValid("11111111-3"));
	}
	
	@Test
	public void validateFormatedRut() {
		assertTrue(RutValidator.isValid("26.397.219-8"));
	}
}
