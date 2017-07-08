package com.yue.common.encode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class Md5PwdImpl implements Md5Pwd {

	// 加密
	public String encode(String password) {
		String algorithm = "MD5";
		// 加盐
		// password ="xx?x11"+password+"sss+asd+wwqd";
		MessageDigest instance = null;
		try {
			instance = MessageDigest.getInstance(algorithm);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 加密
		byte[] digest = instance.digest(password.getBytes());

		// 十六进制加密
		char[] encodeHex = Hex.encodeHex(digest);

		// String md5=new String(digest);
		String md5 = new String(encodeHex);

		return md5;
	}
}
