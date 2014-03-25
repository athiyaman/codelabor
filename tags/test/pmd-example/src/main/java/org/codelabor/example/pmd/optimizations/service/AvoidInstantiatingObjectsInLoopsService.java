package org.codelabor.example.pmd.optimizations.service;

import java.util.List;
import java.util.Map;

public interface AvoidInstantiatingObjectsInLoopsService {

	public abstract List<String> avoidInstantiatingObjectsInLoops1();

	public abstract List<Object> avoidInstantiatingObjectsInLoops2();

	public abstract List<Map<String, String>> avoidInstantiatingObjectsInLoops3();

}