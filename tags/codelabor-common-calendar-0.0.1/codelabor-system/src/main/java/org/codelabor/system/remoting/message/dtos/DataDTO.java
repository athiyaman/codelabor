package org.codelabor.system.remoting.message.dtos;

import java.util.Map;

public abstract class DataDTO {

	/**
	 *
	 */
	private static final long serialVersionUID = -8688837742539628554L;

	public abstract void fromBytes(byte[] bytes) throws Exception;

	public abstract byte[] toBytes() throws Exception;

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataDTO)) {
			return false;
		}

		DataDTO target = (DataDTO) obj;
		Map targetMap = target.toMap();
		return this.toMap().equals(targetMap);
	}

	@Override
	public int hashCode() {
		return this.toMap().hashCode();
	}

	public abstract void fromMap(Map<String, Object> input);

	@SuppressWarnings("unchecked")
	public abstract Map toMap();
}
