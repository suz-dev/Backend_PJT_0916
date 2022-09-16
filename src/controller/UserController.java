package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReviewDao;
import dao.ReviewDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import dto.Review;
import dto.User;

@WebServlet("/user")
public class UserController extends HttpServlet {

	UserDao userDao = UserDaoImpl.getInstance();

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
		case "signup":
			doSignup(request, response);
			break;
		case "login":
			doLogin(request, response);
			break;
		case "logout":
			doLogout(request, response);
			break;
		}
	}

	

	private void doSignup(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		User user = userDao.findById(userId);
		if(user==null) {
			userDao.registUser(new User(userDao.findAll().size(), userId, password, userName));
			response.sendRedirect("index.jsp");
		}else {
			request.setAttribute("msg", "이미 존재하는 아이디입니다.");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		User user = userDao.findById(userId);
		if(user==null) {
			request.setAttribute("msg", "존재하지 않는 아이디입니다.");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		} else if(!user.getPassword().equals(password)) {
			request.setAttribute("msg", "비밀번호가 틀렸습니다.");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			response.sendRedirect("index.jsp");
		}
	}

	private void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	
}
