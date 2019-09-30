package no.hvl.dat108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/frukt2")
public class ServletFrukt2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	private List<String> readOptionsFromFile(String filePath) throws IOException {
		List<String> options = new ArrayList<String>();
		InputStream optionsStream = getServletContext() .getResourceAsStream(filePath);
		BufferedReader optionsReader = new BufferedReader( new InputStreamReader(optionsStream));
		    String option = optionsReader.readLine();
		    while (option != null) {
		        options.add(option);
		        option = optionsReader.readLine();
		    }
		optionsReader.close();
		    return options;
		}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		readOptionsFromFile("/WEB-INF/options.txt");
	}

}
