package org.codelabor.edu;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;
import org.springframework.util.StopWatch;

public class SnifferAdvice implements Ordered {
	protected int order;
	protected Log log = LogFactory.getLog(this.getClass());

	public SnifferAdvice() {
	}
	
	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}	

	public void dumpArguments(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("args: ");
		for (int i = 0; i < args.length; i++) {
			stringBuilder.append(args[i]);
			if (i != (args.length - 1)) {
				stringBuilder.append(", ");
			}
		}
		log.debug(stringBuilder.toString());
	}

	public void dumpReturn(JoinPoint joinPoint, Object returnObject) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("return: ");
		stringBuilder.append(returnObject);
		log.debug(stringBuilder.toString());
	}


	public Object getElapsedTime(ProceedingJoinPoint joinPoint)
			throws Throwable {
		StopWatch stopWatch = new StopWatch(getClass().getName());
		stopWatch.start(joinPoint.toShortString());
		Object returnValue = joinPoint.proceed();
		stopWatch.stop();

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("total time (millis): ").append(
				stopWatch.getTotalTimeMillis());
		log.debug(stringBuilder.toString());
		return returnValue;
	}
}
