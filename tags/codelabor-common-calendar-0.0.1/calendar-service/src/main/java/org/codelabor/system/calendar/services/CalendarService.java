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

package org.codelabor.system.calendar.services;

import java.util.Date;

/**
 * 휴일, 영업일 관리 서비스
 * 
 * <p>
 * 기준일에 대해 며칠 전, 며칠 후의 영업일이나 휴일을 구하는 서비스
 * </p>
 * 
 * @author Shin Sangjae
 * 
 */
public interface CalendarService {
	/**
	 * 기준일 이전, 이후의 영업일을 가져온다.
	 * 
	 * @param date
	 *            기준일
	 * @param amount
	 *            이전, 이후 일수 (예: -1, 0, 1)
	 * @return 기준일 이전, 이후의 영업일
	 * @throws Exception
	 */
	public Date getBusinessdayDate(Date date, int amount) throws Exception;

	/**
	 * 기준일 이전, 이후의 휴일을 가져온다.
	 * 
	 * @param date
	 *            기준일
	 * @param amount
	 *            이전, 이후 일수 (예: -1, 0, 1)
	 * @return 기준일 이전, 이후의 휴일
	 * @throws Exception
	 */
	public Date getHolidayDate(Date date, int amount) throws Exception;

	/**
	 * 영업일 여부를 확인한다.
	 * 
	 * @param date
	 *            기준일
	 * @return 영업일 여부
	 * @throws Exception
	 */
	public boolean isBusinessday(Date date) throws Exception;

	/**
	 * 영업일 여부를 확인한다.
	 * 
	 * @param date
	 *            기준일
	 * @return 영업일 여부
	 * @throws Exception
	 */
	public boolean isBusinessday(String date) throws Exception;

	/**
	 * 휴일 여부를 확인한다.
	 * 
	 * @param date
	 *            기준일
	 * @return 휴일 여부
	 * @throws Exception
	 */
	public boolean isHoliday(Date date) throws Exception;

	/**
	 * 휴일 여부를 확인한다.
	 * 
	 * @param date
	 *            기준일
	 * @return 휴일 여부
	 * @throws Exception
	 */
	public boolean isHoliday(String date) throws Exception;

	/**
	 * 휴일 상세 정보를 가져온다.
	 * 
	 * @param date
	 *            기준일
	 * @return 휴일 상세 정보
	 * @throws Exception
	 */
	public String getHolidayDescription(Date date) throws Exception;

	/**
	 * 휴일 상세 정보를 가져온다.
	 * 
	 * @param date
	 *            기준일
	 * @return 휴일 상세 정보
	 * @throws Exception
	 */
	public String getHolidayDescription(String date) throws Exception;
}
