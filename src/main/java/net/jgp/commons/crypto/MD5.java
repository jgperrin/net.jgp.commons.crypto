package net.jgp.commons.crypto;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	private String digest;

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

	public String getDigest() {
		return this.digest;
	}

	public static String digest(String messageToDigest) {
		return new MD5(messageToDigest).getDigest();
	}

}
