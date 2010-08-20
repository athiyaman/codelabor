<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

				<h5>Administration</h5>
				<ul>
					<li class="none">
						<a href="">Notice</a>
					</li>
					<li class="none">
						<a href="">FAQ</a>
					</li>
					<li class="none">
						<a href="">Business Hours</a>
					</li>
					<li class="none">
						<a href="">Shutdown Hours</a>
					</li>
				</ul>
				<h5>Manage</h5>
				<ul>
					<li class="expanded">
						Authorization
						<ul>
							<li>
								<a href="<c:url value='/system/administration/authorization/reload.do'/>">Reload</a>
							</li>
						</ul>
					</li>
					<li class="none">
						<a href="<c:url value='/system/user.do'/>">User</a>
					</li>
					<li class="none">
						<a href="">Roles</a>
					</li>
					<li class="none">
						<a href="">Menu</a>
					</li>
					<li class="none">
						<a href="">Reference Code</a>
					</li>
					<li class="none">
						<a href="">Appearance</a>
					</li>
				</ul>
				<h5>Report</h5>
				<ul>
					<li class="none">
						<a href="">PKI Certificates</a>
					</li>
					<li class="none">
						<a href="">PKI Sign</a>
					</li>
					<li class="none">
						<a href="">Name Check</a>
					</li>
					<li class="none">
						<a href="">Transaction</a>
					</li>
					<li class="none">
						<a href="">Password Reset</a>
					</li>
					<li class="none">
						<a href="">Dormant Account</a>
					</li>
					<li class="none">
						<a href="">Access</a>
					</li>
				</ul>
				<h5>Monitor</h5>
				<ul>
					<li class="none">
						<a href="">Anyframe</a>
					</li>
				</ul>