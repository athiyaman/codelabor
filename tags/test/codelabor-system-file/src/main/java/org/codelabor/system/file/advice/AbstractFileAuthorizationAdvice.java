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

package org.codelabor.system.file.advice;

import org.aspectj.lang.JoinPoint;
import org.springframework.core.Ordered;

/**
 * 파일 입출력 권한 처리 어드바이스
 * 
 * @author Shin Sang-jae
 * 
 */
public abstract class AbstractFileAuthorizationAdvice implements Ordered {

	/**
	 * 어드바이스 순서
	 */
	protected int order;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.Ordered#getOrder()
	 */
	public int getOrder() {
		return this.order;
	}

	/**
	 * 어드바이스 순서를 설정한다.
	 * 
	 * @param order
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * 파일 정보 삭제 시 권한 확인을 한다.
	 * 
	 * @param joinPoint
	 */
	public abstract void deleteFile(JoinPoint joinPoint);

	/**
	 * 파일 정보 입력 시 권한 확인을 한다.
	 * 
	 * @param joinPoint
	 *            조인 포인트
	 */
	public abstract void insertFile(JoinPoint joinPoint);

	/**
	 * 모든 파일 정보 검색 시 권한 확인을 한다.
	 * 
	 * @param joinPoint
	 *            조인 포인트
	 */
	public abstract void selectFile(JoinPoint joinPoint);

	/**
	 * 파일 저장 방식에 따른 파일 정보 검색 시 권한 확인을 한다.
	 * 
	 * @param joinPoint
	 *            조인 포인트
	 */
	public abstract void selectFileByRepositoryType(JoinPoint joinPoint);

	/**
	 * 파일 ID에 따른 파일 정보 검색 시 권한 확인을 한다.
	 * 
	 * @param joinPoint
	 *            조인 포인트
	 */
	public abstract void selectFileByFileId(JoinPoint joinPoint);

	/**
	 * 매핑 ID에 따른 파일 정보 검색 시 권한 확인을 한다.
	 * 
	 * @param joinPoint
	 *            조인 포인트
	 */
	public abstract void selectFileByMapId(JoinPoint joinPoint);

}
