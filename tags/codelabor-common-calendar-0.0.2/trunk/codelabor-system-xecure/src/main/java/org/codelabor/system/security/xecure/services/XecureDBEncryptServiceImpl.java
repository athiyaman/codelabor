package org.codelabor.system.security.xecure.services;

import org.codelabor.system.security.HashFunctionType;
import org.codelabor.system.security.services.EncryptService;

import com.softforum.xdbe.XdspClient;
import com.softforum.xdbe.XdspNative;

public class XecureDBEncryptServiceImpl implements EncryptService {
	public void setCharsetName(String charsetName) {
		this.charsetName = charsetName;
	}

	private String charsetName = "EUC-KR";
	private HashFunctionType hashFunctionType = HashFunctionType.SHA1;
	private String pool;
	private String database;
	private String owner;
	private String table;
	private String column;
	private XdspClient xdspClient;

	public void setHashFunction(String hashFunction) {
		hashFunction.trim().toUpperCase();
		this.hashFunctionType = HashFunctionType.valueOf(hashFunction.trim()
				.toUpperCase());
	}

	public void setPool(String pool) {
		this.pool = pool;
		xdspClient = new XdspClient(this.pool);
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String decrypt(String encryptedData) throws Exception {
		return new String(xdspClient.decrypt(database, owner, table, column,
				encryptedData.getBytes(charsetName)), charsetName);
	}

	public byte[] decrypt(byte[] encryptedData) throws Exception {
		return xdspClient
				.decrypt(database, owner, table, column, encryptedData);
	}

	public String decrypt64(String encryptedData) throws Exception {
		return new String(xdspClient.decrypt64(database, owner, table, column,
				encryptedData), charsetName);
	}

	public byte[] decrypt64(byte[] encryptedData) throws Exception {
		return xdspClient.decrypt64(database, owner, table, column, new String(
				encryptedData, charsetName));
	}

	public String encrypt(String plainData) throws Exception {
		return new String(xdspClient.encrypt(database, owner, table, column,
				plainData.getBytes(charsetName)), charsetName);
	}

	public byte[] encrypt(byte[] plainData) throws Exception {
		return xdspClient.encrypt(database, owner, table, column, plainData);
	}

	public String encrypt64(String plainData) throws Exception {
		return xdspClient.encrypt64(database, owner, table, column, plainData
				.getBytes(charsetName));
	}

	public byte[] encrypt64(byte[] plainData) throws Exception {
		return xdspClient.encrypt64(database, owner, table, column, plainData)
				.getBytes(charsetName);
	}

	public String hash64(String plainData, HashFunctionType hashFunctionType)
			throws Exception {
		return XdspNative.hash64(decodeType(hashFunctionType), plainData
				.getBytes(charsetName));
	}

	public byte[] hash64(byte[] plainData, HashFunctionType hashFunctionType)
			throws Exception {
		return XdspNative.hash64(decodeType(hashFunctionType), plainData)
				.getBytes(charsetName);
	}

	public String hash64(String plainData) throws Exception {
		return this.hash64(plainData, hashFunctionType);
	}

	public byte[] hash64(byte[] plainData) throws Exception {
		return this.hash64(plainData, hashFunctionType);
	}

	private int decodeType(HashFunctionType hashFunctionType) {
		switch (hashFunctionType) {
		case MD2:
			return 1;
		case MD5:
			return 2;
		case SHA1:
			return 3;
		case HAS160:
			return 4;
		default:
			throw new IllegalArgumentException("Unsupported hash function type");
		}
	}

}
