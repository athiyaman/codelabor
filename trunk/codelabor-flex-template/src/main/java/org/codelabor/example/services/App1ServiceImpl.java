package org.codelabor.example.services;

import org.codelabor.example.managers.Biz1Manager;
import org.codelabor.example.managers.Biz2Manager;
import org.codelabor.system.services.BaseServiceImpl;

public class App1ServiceImpl extends BaseServiceImpl implements App1Service {

	Biz1Manager biz1Manager = null;
	Biz2Manager biz2Manager = null;

	/**
	 * 10 success, 11 success => 10, 11 success
	 * 
	 * @throws Exception
	 */
	public void method1011() throws Exception {
		biz1Manager.method10();
		biz1Manager.method11();
	}

	/**
	 * 12 success, 13 failure => 12, 13 failure
	 * 
	 * @throws Exception
	 */
	public void method1213() throws Exception {
		biz1Manager.method12();
		biz1Manager.method13();
	}

	/**
	 * 14 success, 15 failure => 14 success, 15 failure
	 * 
	 * @throws Exception
	 */
	public void method1415() throws Exception {
		biz1Manager.method14();
		biz1Manager.method15();
	}

	/**
	 * 16 success, 13 failure, 17 success => 16 failure, 13 failure, 17 failure
	 * 
	 * @throws Exception
	 */
	public void method161317() throws Exception {
		biz1Manager.method16();
		try {
			biz1Manager.method13();
		} catch (Exception e) {
			e.printStackTrace();
		}
		biz1Manager.method17();
	}

	/**
	 * 18 success, 15 failure, 19 success => 18 success, 15 failure, 19 success
	 * 
	 * @throws Exception
	 */
	public void method181519() throws Exception {
		biz1Manager.method18();
		try {
			biz1Manager.method15();
		} catch (Exception e) {
			e.printStackTrace();
		}
		biz1Manager.method19();
	}

	/**
	 * 20 success, 13 failure => 20 success, 13 failure
	 * 
	 * @throws Exception
	 */
	public void method2013() throws Exception {
		biz2Manager.method20();
		biz1Manager.method13();
	}

	/**
	 * 21 success, 15 failure => 21 success, 15 failure
	 * 
	 * @throws Exception
	 */
	public void method2115() throws Exception {
		biz2Manager.method21();
		biz1Manager.method15();
	}

	/**
	 * 22 success, 13 failure, 23 success => 22 failure, 13 failure, 23 failure
	 * 
	 * @throws Exception
	 */
	public void method221323() throws Exception {
		biz2Manager.method22();
		try {
			biz1Manager.method13();
		} catch (Exception e) {
			e.printStackTrace();
		}
		biz2Manager.method23();
	}

	/**
	 * 24 success, 15 failure, 25 success => 24 success, 15 failure, 25 success
	 * 
	 * @throws Exception
	 */
	public void method241525() throws Exception {
		biz2Manager.method24();
		try {
			biz1Manager.method15();
		} catch (Exception e) {
			e.printStackTrace();
		}
		biz2Manager.method25();
	}

	public void setBiz1Manager(Biz1Manager biz1Manager) {
		this.biz1Manager = biz1Manager;
	}

	public void setBiz2Manager(Biz2Manager biz2Manager) {
		this.biz2Manager = biz2Manager;
	}

}
