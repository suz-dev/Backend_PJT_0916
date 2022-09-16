package controller;

import java.io.IOException;
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
		String part = request.getParameter("part");
		
		List<Video> videoList = videoDao.selectAll();
		request.setAttribute("videoList", videoList);
		System.out.println(part);
//		if(!part.isEmpty()) {
//			List<Video> partList = videoDao.selectPartFitVideo("");
//			request.setAttribute("partList", partList);
//		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}