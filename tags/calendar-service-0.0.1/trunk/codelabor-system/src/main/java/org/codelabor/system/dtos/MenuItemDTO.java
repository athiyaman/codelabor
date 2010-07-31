/**
 * 
 */
package org.codelabor.system.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bomber
 * 
 */
public class MenuItemDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3253325473887636189L;
	private String id;
	private String href;

	public List<MenuItemDTO> getChildMenuItemDTOList() {
		return childMenuItemDTOList;
	}

	private String labelKey;
	private String target = "_blank";
	private boolean isEnable = true;
	private final List<MenuItemDTO> childMenuItemDTOList = new ArrayList<MenuItemDTO>();

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void addChild(MenuItemDTO menuItemDTO) {
		childMenuItemDTOList.add(menuItemDTO);
	}

	public MenuItemDTO removeChild(int index) {
		return childMenuItemDTOList.remove(index);
	}

	public MenuItemDTO getChild(int index) {
		return childMenuItemDTOList.get(index);
	}
}
