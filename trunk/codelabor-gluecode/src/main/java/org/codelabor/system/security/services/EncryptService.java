package org.codelabor.system.security.services;

import org.codelabor.system.security.HashFunctionType;

public interface EncryptService {
	public String encrypt(String plainData) throws Exception;

	public byte[] encrypt(byte[] plainData) throws Exception;

	public String decrypt(String encryptedData) throws Exception;

	public byte[] decrypt(byte[] encryptedData) throws Exception;

	public String encrypt64(String plainData) throws Exception;

	public byte[] encrypt64(byte[] plainData) throws Exception;

	public String decrypt64(String encryptedData) throws Exception;

	public byte[] decrypt64(byte[] encryptedData) throws Exception;

	public String hash64(String plainData, HashFunctionType hashFunction)
			throws Exception;

	public byte[] hash64(byte[] plainData, HashFunctionType hashFunction)
			throws Exception;

	public String hash64(String plainData) throws Exception;

	public byte[] hash64(byte[] plainData) throws Exception;

}
