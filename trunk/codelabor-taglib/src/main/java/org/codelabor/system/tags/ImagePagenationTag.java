package org.codelabor.system.tags;

public class ImagePagenationTag extends TextPagenationTag {
	private String previousUnitPageImage = null;
	private String previousPageImage = null;
	private String nextPageImage = null;
	private String nextUnitPageImage = null;

	private String createImageTag(String src) {
		StringBuilder sb = new StringBuilder();
		sb.append("<img src='");
		sb.append(src);
		sb.append("'/>");
		return sb.toString();
	}

	protected String getPageIndexBody(String body, String styleId,
			String styleClass) {
		// TODO Auto-generated method stub
		return super.getPageIndexBody(body, styleId, styleClass);
	}

	public String getPreviousUnitPageImage() {
		return previousUnitPageImage;
	}

	public void setPreviousUnitPageImage(String previousUnitPageImage) {
		this.previousUnitPageImage = previousUnitPageImage;
	}

	public String getPreviousPageImage() {
		return previousPageImage;
	}

	public void setPreviousPageImage(String previousPageImage) {
		this.previousPageImage = previousPageImage;
	}

	public String getNextPageImage() {
		return nextPageImage;
	}

	public void setNextPageImage(String nextPageImage) {
		this.nextPageImage = nextPageImage;
	}

	public String getNextUnitPageImage() {
		return nextUnitPageImage;
	}

	public void setNextUnitPageImage(String nextUnitPageImage) {
		this.nextUnitPageImage = nextUnitPageImage;
	}

}
