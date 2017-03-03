package net.jgp.commons.crypto;

import static org.junit.Assert.*;

import org.junit.Test;

public class MD5Test {

	@Test
	public void testString1() {
		String toTest = "toto";
		MD5 m = new MD5(toTest);
		String s = m.getDigest();
		System.out.println(s + " ... [" + s.length() + "]");
		assertEquals("f71dbe52628a3f83a77ab494817525c6", s);
	}

	@Test
	public void testString2() {
		String toTest = "toto";
		String s = MD5.digest(toTest);
		System.out.println(s + " ... [" + s.length() + "]");
		assertEquals("f71dbe52628a3f83a77ab494817525c6", s);
	}
}
