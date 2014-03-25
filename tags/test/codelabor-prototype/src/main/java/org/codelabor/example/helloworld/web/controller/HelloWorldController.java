package org.codelabor.example.helloworld.web.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;
import javax.inject.Named;

import org.codelabor.example.helloworld.service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example/helloworld")
public class HelloWorldController {

	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorldController.class);

	@Inject
	@Named("helloWorldService")
	private HelloWorldService helloWorldService;

	@RequestMapping("/sayHello")
	public ModelAndView sayHello(
			@RequestParam(value = "name", required = false) String name)
			throws Exception {
		logger.debug("sayHello");
		String message = helloWorldService.sayHello(name);
		logger.debug("message: {}", message);
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", message);
		mav.setViewName("/example/helloworld/helloWorld");
		return mav;
	}

	@RequestMapping("/sayHelloByExcel")
	public ModelAndView sayHelloByExcel(
			@RequestParam(value = "name", required = false) String name)
			throws Exception {
		logger.debug("sayHelloByExcel");
		String message = helloWorldService.sayHello(name);
		logger.debug("message: {}", message);
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", message);
		mav.setViewName("helloWorldExcelView");
		return mav;
	}

	/**
	 * @param name
	 * @return
	 * @throws Exception
	 * @deprecated Replaced by
	 *             {@link org.springframework.web.servlet.view.ContentNegotiatingViewResolver}
	 */
	@RequestMapping(value = "/sayHelloByJson", produces = "application/json")
	@ResponseBody
	@Deprecated
	public Object sayHelloByJson(
			@RequestParam(value = "name", required = false) String name)
			throws Exception {
		logger.debug("sayHelloByJson");
		String message = helloWorldService.sayHello(name);
		logger.debug("message: {}", message);
		Map<String, String> messageMap = new ConcurrentHashMap<String, String>();
		messageMap.put("message", message);
		return messageMap;
	}

	@RequestMapping("/sayHelloByPdf")
	public ModelAndView sayHelloByPdf(
			@RequestParam(value = "name", required = false) String name)
			throws Exception {
		logger.debug("sayHelloByPdf");
		String message = helloWorldService.sayHello(name);
		logger.debug("message: {}", message);
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", message);
		mav.setViewName("helloWorldPdfView");
		return mav;
	}

	/**
	 * @param name
	 * @return
	 * @throws Exception
	 * @deprecated Replaced by
	 *             {@link org.springframework.web.servlet.view.ContentNegotiatingViewResolver}
	 */
	@RequestMapping("/sayHelloByXml")
	@Deprecated
	public ModelAndView sayHelloByXml(
			@RequestParam(value = "name", required = false) String name)
			throws Exception {
		logger.debug("sayHelloByXml");
		String message = helloWorldService.sayHello(name);
		logger.debug("message: {}", message);
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", message);
		throw new UnsupportedOperationException("Not yet implemeted.");
		// TODO
		// mav.setViewName("");
		// return mav;
	}

}
