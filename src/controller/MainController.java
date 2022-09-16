package controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoDao;
import dao.VideoDaoImpl;
import dto.Video;

@WebServlet("/main")
public class MainController extends HttpServlet {
	
	VideoDao videoDao = VideoDaoImpl.getInstance();
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String _part = request.getParameter("part");
		String part = "전신";
		List<Video> videoList = videoDao.selectAll();
		Collections.sort(videoList);
		request.setAttribute("videoList", videoList);
		if(_part != null) {
			part = _part;
		}
		List<Video> partList = videoDao.selectPartFitVideo(part);
		request.setAttribute("partList", partList);
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}
}