package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReviewDao;
import dao.ReviewDaoImpl;
import dao.VideoDao;
import dto.Review;
import dto.User;
import dto.Video;

@WebServlet("/review")
public class ReviewController extends HttpServlet {

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
		case "regist":
			doRegist(request, response);
			break;
		case "getForm":
			doGetForm(request, response);
			break;
		case "remove":
			doRemove(request, response);
			break;
		case "update":
			doUpdate(request, response);
			break;
		case "getUpdateForm":
			doGetUpdateForm(request, response);
			break;
		}
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String videoId = request.getParameter("videoId");

		List<Review> reviewList = reviewDao.getReviewList(videoId);
		Review findReview = null;
		for (Review review : reviewList) {
			if (review.getReviewId() == reviewId) {
				findReview = review;
			}
		}
		request.setAttribute("review", findReview);
		request.getRequestDispatcher("reviewDetail.jsp").forward(request, response);
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		if(loginUser==null) {
			request.setAttribute("msg", "로그인 후 이용해주세요.");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		Review review = new Review();
		String id = request.getParameter("videoId");
		review.setVideoId(id);
		review.setReviewId(reviewDao.getReviewList(id).size());
		review.setContent(request.getParameter("content"));
		review.setTitle(request.getParameter("title"));
		review.setWriter(loginUser.getUserName());
		
		reviewDao.writeReview(review);
		response.sendRedirect("/Backend_0916/video?action=detail&id=" + id);
	}

	private void doGetForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String videoId = request.getParameter("id");
		request.setAttribute("videoId", videoId);
		request.getRequestDispatcher("reviewWrite.jsp").forward(request, response);
	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String videoId = request.getParameter("videoId");
		List<Review> reviewList = reviewDao.getReviewList(videoId);
		Review findReview = null;
		for (Review review : reviewList) {
			if (review.getReviewId() == reviewId) {
				findReview = review;
			}
		}
		reviewDao.deleteReview(findReview);
		response.sendRedirect("/Backend_0916/video?action=detail&id="+ videoId);
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String videoId = request.getParameter("videoId");
		List<Review> reviewList = reviewDao.getReviewList(videoId);
		Review findReview = null;
		for (Review review : reviewList) {
			if (review.getReviewId() == reviewId) {
				findReview = review;
			}
		}
		
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		if(loginUser==null) {
			request.setAttribute("msg", "로그인 후 이용해주세요.");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}else if(!loginUser.getUserName().equals(findReview.getWriter())) {
			request.setAttribute("msg", "권한이 없습니다.");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	
		findReview.setContent(request.getParameter("content"));
		findReview.setTitle(request.getParameter("title"));

		reviewDao.updateReview(findReview);
		
		response.sendRedirect("/Backend_0916/video?action=detail&id="+ videoId);
	}
	
	private void doGetUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String videoId = request.getParameter("videoId");
		List<Review> reviewList = reviewDao.getReviewList(videoId);
		Review findReview = null;
		for (Review review : reviewList) {
			if (review.getReviewId() == reviewId) {
				findReview = review;
			}
		}

		request.setAttribute("review", findReview);
		request.getRequestDispatcher("updateReview.jsp").forward(request, response);
	}
}
