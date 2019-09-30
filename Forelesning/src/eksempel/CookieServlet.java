package eksempel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		boolean besokt = false;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("besokt")) {
					besokt = true;
				}
			}
		}
		
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		if (besokt) {
			out.println("Hallo gamle venn!");
		} else {
			out.println("Hallo nye venn!");
			Cookie cookie = new Cookie("besokt", "ja");
			cookie.setMaxAge(60);
			response.addCookie(cookie);
		}
		
	
	}



}
