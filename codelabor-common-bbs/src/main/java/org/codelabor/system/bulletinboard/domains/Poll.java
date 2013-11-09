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

import java.util.List;

/**
 * @author bomber
 * 
 */
public class Poll {
	private String subject;
	private String question;
	private List<String> choice;
	private boolean isMultipleVotesAllowed;
	private boolean isRepliesAllowed;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getChoice() {
		return choice;
	}
	public void setChoice(List<String> choice) {
		this.choice = choice;
	}
	public boolean isMultipleVotesAllowed() {
		return isMultipleVotesAllowed;
	}
	public void setMultipleVotesAllowed(boolean isMultipleVotesAllowed) {
		this.isMultipleVotesAllowed = isMultipleVotesAllowed;
	}
	public boolean isRepliesAllowed() {
		return isRepliesAllowed;
	}
	public void setRepliesAllowed(boolean isRepliesAllowed) {
		this.isRepliesAllowed = isRepliesAllowed;
	}
}
