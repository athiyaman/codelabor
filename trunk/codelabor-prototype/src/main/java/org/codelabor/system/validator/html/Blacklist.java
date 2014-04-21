/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codelabor.system.validator.html;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shin Sang-Jae
 *
 */
public class Blacklist {
	public static List<String> none() {
		return new ArrayList<String>();
	}

	public static List<String> anchor() {
		List<String> blacklist = new ArrayList<String>();
		blacklist.add("<a ");
		return blacklist;
	}

	public static List<String> script() {
		List<String> blacklist = new ArrayList<String>();
		blacklist.add("<script");
		blacklist.add("script:");
		blacklist.add("document.cookie");
		blacklist.add("document.location");
		return blacklist;
	}

	public static List<String> form() {
		List<String> blacklist = new ArrayList<String>();
		blacklist.add("<form");
		blacklist.add("<spring:form");
		return blacklist;
	}

	public static List<String> scriptForm() {
		List<String> blacklist = new ArrayList<String>();
		blacklist.add("<script");
		blacklist.add("script:");
		blacklist.add("document.cookie");
		blacklist.add("document.location");
		blacklist.add("<form");
		blacklist.add("<spring:form");
		return blacklist;
	}

	public static List<String> anchorScriptForm() {
		List<String> blacklist = new ArrayList<String>();
		blacklist.add("<a ");
		blacklist.add("<script");
		blacklist.add("script:");
		blacklist.add("document.cookie");
		blacklist.add("document.location");
		blacklist.add("<form");
		blacklist.add("<spring:form");
		return blacklist;
	}

	public static List<String> allTag() {
		List<String> blacklist = new ArrayList<String>();
		blacklist.add("<");
		blacklist.add(">");
		return blacklist;
	}
}
