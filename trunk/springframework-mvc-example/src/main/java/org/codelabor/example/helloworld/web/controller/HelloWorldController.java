package org.codelabor.example.helloworld.web.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.codelabor.example.helloworld.service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example/helloworld")
public class HelloWorldController {

	private Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@Inject
	@Named("helloWorldService")
	private HelloWorldService helloWorldService;

	@RequestMapping("/sayHello")
	public ModelAndView sayHello(
			@RequestParam(value = "name", required = false) String name)
			throws Exception {
		String message = helloWorldService.sayHello(name);
		logger.debug("message: {}", message);
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", message);
		mav.setViewName("/example/helloworld/helloWorld");
		return mav;
	}

	@RequestMapping("/sayHelloByPdf")
	public ModelAndView sayHelloByPdf(
			@RequestParam(value = "name", required = false) String name)
			throws Exception {
		String message = helloWorldService.sayHello(name);
		logger.debug("message: {}", message);
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", message);
		mav.setViewName("helloWorldPdfView");
		return mav;
	}

	@RequestMapping("/sayHelloByExcel")
	public ModelAndView sayHelloByExcel(
			@RequestParam(value = "name", required = false) String name)
			throws Exception {
		String message = helloWorldService.sayHello(name);
		logger.debug("message: {}", message);
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", message);
		mav.setViewName("helloWorldExcelView");
		return mav;
	}

}
