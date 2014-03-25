package org.codelabor.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.example.dto.DummyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class LiveObjectServlet
 */
public class LiveObjectMonitoringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory
			.getLogger(LiveObjectMonitoringServlet.class);
	private final Collection<DummyDto> collection = new ArrayList<DummyDto>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LiveObjectMonitoringServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();

		int size = 10000;
		for (int i = 0; i < size; i++) {
			collection.add(new DummyDto());
		}
		printWriter.format("DummyDto count: %d<br/>", collection.size());
		logger.debug("DummyDto count: {}", collection.size());

		Runtime runtime = Runtime.getRuntime();
		long totalMemory = runtime.totalMemory() / (1024 * 1024);
		long freeMemory = runtime.freeMemory() / (1024 * 1024);
		printWriter.format("Memory Size: %d / %d (Free / Total MB)<br/>",
				freeMemory, totalMemory);
		logger.debug("Memory Size: {} / {} (Free / Total MB)", freeMemory,
				totalMemory);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
