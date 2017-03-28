package net.jgp.commons.crypto;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Handles MD5 digesting. 
 * 
 * You can use either by instantiating the class with a String or call the static method digest().
 * 
 * @author jgp
 */
public class MD5 {

	private String digest;

	/**
	 * Constructor taking the String to digest.
	 * 
	 * @param messageToDigest
	 */
	public MD5(String messageToDigest) {
		byte[] bytesOfMessage;
		try {
			bytesOfMessage = messageToDigest.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO log
			this.digest = null;
			return;
		}

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO log
			this.digest = null;
			return;
		}

		byte[] array = md.digest(bytesOfMessage);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; ++i) {
			sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
		}

		this.digest = sb.toString();
	}

	/**
	 * Returns the digest.
	 * 
	 * @return 32 character string containing the digest.
	 */
	public String getDigest() {
		return this.digest;
	}

	/**
	 * Fast method to return a MD5 digest from a String in one operation.
	 * 
	 * @param messageToDigest Message to digest.
	 * @return 32 character string containing the digest.
	 */
	public static String digest(String messageToDigest) {
		return new MD5(messageToDigest).getDigest();
	}

}
