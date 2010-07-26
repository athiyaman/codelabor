package org.codelabor.system.remoting.message.dtos;

import java.io.Serializable;

public abstract class HeaderDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3875501284423081822L;

	public abstract byte[] toBytes() throws Exception;

	public abstract void fromBytes(byte[] bytes) throws Exception;

	public abstract int getLength();

	public abstract boolean isError();

}
