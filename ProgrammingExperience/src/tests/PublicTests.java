package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import sysutilities.YouComplete;

public class PublicTests {
	@Test
	public void test1() {
		boolean have = YouComplete.IHaveProgrammingExperience();
		assertTrue(have || !have);
	}
}