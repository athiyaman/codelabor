package org.codelabor.example.security.xss.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

public class ValidParameterDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7155160076852589436L;
	
	@SafeHtml(whitelistType=WhiteListType.NONE)
	private String param1;

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParamDto [param1=").append(param1).append("]");
		return builder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((param1 == null) ? 0 : param1.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ValidParameterDto)) {
			return false;
		}
		ValidParameterDto other = (ValidParameterDto) obj;
		if (param1 == null) {
			if (other.param1 != null) {
				return false;
			}
		} else if (!param1.equals(other.param1)) {
			return false;
		}
		return true;
	}
}
