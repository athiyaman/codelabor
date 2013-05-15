package org.codelabor.example.pmd.optimizations;

import org.codelabor.example.pmd.optimizations.service.AvoidInstantiatingObjectsInLoopsService;
import org.codelabor.example.pmd.optimizations.service.impl.AvoidInstantiatingObjectsInLoopsServiceImpl;
import org.junit.Test;

public class AvoidInstantiatingObjectsInLoopsServiceTest {

	AvoidInstantiatingObjectsInLoopsService avoidInstantiatingObjectsInLoopsService = new AvoidInstantiatingObjectsInLoopsServiceImpl();

	@Test
	public void testAvoidInstantiatingObjectsInLoops1() {
		avoidInstantiatingObjectsInLoopsService
				.avoidInstantiatingObjectsInLoops1();
	}

	@Test
	public void testAvoidInstantiatingObjectsInLoops2() {
		avoidInstantiatingObjectsInLoopsService
				.avoidInstantiatingObjectsInLoops2();
	}

	@Test
	public void testAvoidInstantiatingObjectsInLoops3() {
		avoidInstantiatingObjectsInLoopsService
				.avoidInstantiatingObjectsInLoops3();
	}

}
