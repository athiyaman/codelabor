<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="org.codelabor.system.dtos.MenuItemDTO" %>
<%
// hard-coded navigation menu

// level 2 menu
MenuItemDTO userManageMentMenu = new MenuItemDTO();
userManageMentMenu.setLabelKey("menu.system.manage.userManagement");
MenuItemDTO userRoleMenu = new MenuItemDTO();
userRoleMenu.setLabelKey("menu.system.manage.userRole");
MenuItemDTO appearanceMenu = new MenuItemDTO();
appearanceMenu.setLabelKey("menu.system.manage.appearance");

MenuItemDTO anyframeMenu = new MenuItemDTO();
anyframeMenu.setLabelKey("menu.system.monitor.anyframe");

// level 1 menu
MenuItemDTO manageMenu = new MenuItemDTO();
manageMenu.setLabelKey("menu.system.manage");
manageMenu.addChild(userManageMentMenu);
manageMenu.addChild(userRoleMenu);
manageMenu.addChild(appearanceMenu);

MenuItemDTO monitorMenu = new MenuItemDTO();
monitorMenu.setLabelKey("menu.system.monitor");
monitorMenu.addChild(anyframeMenu);

// root menu
MenuItemDTO rootMenu = new MenuItemDTO();
rootMenu.setLabelKey("menu.system");
rootMenu.addChild(manageMenu);
rootMenu.addChild(monitorMenu);
request.setAttribute("leftMenu", rootMenu);
%>

<c:forEach 
	var="level1MenuItem" 
	items="${leftMenu.childMenuItemDTOList}">
	<h5>
		<c:if test="${!empty level1MenuItem.href}">
		<a href="${level1MenuItem.href}" target="${level1MenuItem.target}">
			<spring:message code="${level1MenuItem.labelKey}"/>
		</a>
		</c:if>
		<c:if test="${empty level1MenuItem.href}">
			<spring:message code="${level1MenuItem.labelKey}"/>
		</c:if>
	</h5>
	<c:if test="${!empty level1MenuItem.childMenuItemDTOList}">
	<ul>
		<c:forEach var="level2MenuItem" items="${level1MenuItem.childMenuItemDTOList}">
		<li class="expanded">
			<c:if test="${!empty level2MenuItem.href}">
			<a href="${level2MenuItem.href}" target="${level2MenuItem.target}">
				<spring:message code="${level2MenuItem.labelKey}"/>
			</a>
			</c:if>
			<c:if test="${empty level2MenuItem.href}">
				<spring:message code="${level2MenuItem.labelKey}"/>
			</c:if>			
		</li>
			<c:if test="${!empty level2MenuItem.childMenuItemDTOList}">
			<ul>
				<c:forEach var="level3MenuItem" items="${level2MenuItem.childMenuItemDTOList}">
				<li class="none">
					<c:if test="${!empty level3MenuItem.href}">
					<a href="${level3MenuItem.href}" target="${level3MenuItem.target}">
						<spring:message code="${level3MenuItem.labelKey}"/>
					</a>
					</c:if>
					<c:if test="${empty level3MenuItem.href}">
						<spring:message code="${level3MenuItem.labelKey}"/>
					</c:if>					
				</li>
				
				</c:forEach>
			</ul>
			</c:if>
		</c:forEach>
	</ul>
	</c:if>
</c:forEach>


				<!-- 
				<h5>Manage</h5>
				<ul>
					<li class="expanded">
						<a href="<c:url value='/system/user.do'/>">User Management</a>
						<ul>
							<li class="none">
								<strong>About</strong>
							</li>
							<li class="none">
								<a href="">Continuous Integration</a>
							</li>
						</ul>
					</li>
					<li class="expanded">
						<a href="">User Roles</a>
					</li>
					<li class="expanded">
						<a href="">Appearance</a>
					</li>									
				</ul>
				 -->
