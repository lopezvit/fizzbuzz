package fi.serviceflow.fizzbuzz.ws;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alejandro López(alejandro) {@literal <Alejandro.Lopez@xplain.net>} on 08/01/2018.
 */
@WebServlet(

)
public class FizzBuzzServlet extends HttpServlet {

  private static final String DIVISIBLE_BY_3_AND_5 = "Fizz Buzz";
  private static final String DIVISIBLE_BY_3 = "Fizz";
  private static final String DIVISIBLE_BY_5 = "Buzz";

  public String fizzBuzz(String inputString) throws FizzBuzzException {
    final String[] split = inputString.split("\\s*,\\s*");
    final List<String> result = new ArrayList<String>(split.length);
    for (String input : split) {
      if (input != null) {
        final Integer number;
        try {
          number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
          throw new FizzBuzzException("Input need to be a collection of numbers, example: 5, 3, 8");
        }
        if (number % 3 == 0) {
          if (number % 5 == 0) {
            result.add(DIVISIBLE_BY_3_AND_5);
          } else {
            result.add(DIVISIBLE_BY_3);
          }
        } else if (number % 5 == 0) {
          result.add(DIVISIBLE_BY_5);
        } else {
          result.add(input);
        }
      }
    }
    return StringUtils.join(result, ", ");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // Set the response message's MIME type
    resp.setContentType("text/html;charset=UTF-8");
    // Allocate a output writer to write the response message into the network socket
    PrintWriter out = resp.getWriter();

    // Write the response message, in an HTML page
    try {
      out.println("<!DOCTYPE html>");
      out.println("<html><head>");
      out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
      out.println("<title>Hello, World</title></head>");
      out.println("<body>");
      out.println("<h1>Hello, world!</h1>");  // says Hello
      // Echo client's request information
      out.println("<p>Request URI: " + req.getRequestURI() + "</p>");
      out.println("<p>Protocol: " + req.getProtocol() + "</p>");
      out.println("<p>PathInfo: " + req.getPathInfo() + "</p>");
      out.println("<p>Remote Address: " + req.getRemoteAddr() + "</p>");
      // Generate a random number upon each request
      out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();  // Always close the output writer
    }
  }
}
