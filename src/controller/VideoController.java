package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import dao.ReviewDaoImpl;
import dao.VideoDao;
import dao.VideoDaoImpl;
import dto.Review;
import dto.Video;

@WebServlet("/video")
public class VideoController extends HttpServlet {
	
	VideoDao videoDao = VideoDaoImpl.getInstance();
	ReviewDao reviewDao = ReviewDaoImpl.getInstance();
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "detail":
			doDetail(request, response);
			break;
		}
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Video video = videoDao.selectVideo(id);
		List<Review> reviewList = reviewDao.getReviewList(id);
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("video", video);
		request.getRequestDispatcher("reviewList.jsp").forward(request, response);
	}

}
