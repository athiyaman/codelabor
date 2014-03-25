package org.codelabor.system.remoting.message.dtos;

public abstract class HeaderDTO {

	public abstract byte[] toBytes() throws Exception;

	public abstract void fromBytes(byte[] bytes) throws Exception;

	public abstract int getLength();

	public abstract boolean isError();

}
