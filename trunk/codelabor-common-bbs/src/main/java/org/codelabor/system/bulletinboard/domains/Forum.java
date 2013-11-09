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
package org.codelabor.system.bulletinboard.domains;

import java.util.Date;

/**
 * @author bomber
 * 
 */
public class Forum {
	private boolean lock;
	private boolean hide;
	private String moderator;
	private String author;
	private String message;
	private Date posted;
	private String ip;
	private long views;
	private long replies;
	
	public boolean isLock() {
		return lock;
	}
	public void setLock(boolean lock) {
		this.lock = lock;
	}
	public boolean isHide() {
		return hide;
	}
	public void setHide(boolean hide) {
		this.hide = hide;
	}
	public String getModerator() {
		return moderator;
	}
	public void setModerator(String moderator) {
		this.moderator = moderator;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getPosted() {
		return posted;
	}
	public void setPosted(Date posted) {
		this.posted = posted;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public long getViews() {
		return views;
	}
	public void setViews(long views) {
		this.views = views;
	}
	public long getReplies() {
		return replies;
	}
	public void setReplies(long replies) {
		this.replies = replies;
	}
}
