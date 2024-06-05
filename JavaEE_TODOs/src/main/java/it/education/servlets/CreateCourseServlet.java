package it.education.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import it.education.dao.CourseDao;
import it.education.entity.Course;

/**
 * Servlet implementation class CreateCourseServlet
 */
@WebServlet(urlPatterns = {"/createNewCourse"},
name="myCreateCourseServlet"
)
public class CreateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String CourseId=request.getParameter("course_id");
		String CourseName=request.getParameter("course_name");
		String CourseProvider=request.getParameter("course_provider");
		String CourseDuration=request.getParameter("course_duration");
		String CourseFees=request.getParameter("course_fees");
		
		int courseId1 = Integer.parseInt(CourseId);
		int CourseDuration1=Integer.parseInt(CourseDuration);
		int CourseFees1=Integer.parseInt(CourseFees);
		
		Course currentCourse= new Course(courseId1, CourseName, CourseProvider, CourseDuration1, CourseFees1);
		System.out.println(currentCourse);
		
		CourseDao.create(currentCourse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
