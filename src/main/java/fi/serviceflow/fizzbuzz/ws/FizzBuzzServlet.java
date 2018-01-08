package fi.serviceflow.fizzbuzz.ws;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author Alejandro López(alejandro) {@literal <Alejandro.Lopez@xplain.net>} on 08/01/2018.
 */
public class FizzBuzzServlet extends HttpServlet {

  private static final Logger LOGGER = Logger.getLogger(FizzBuzzServlet.class);

  private static final String DIVISIBLE_BY_3_AND_5 = "Fizz Buzz";
  private static final String DIVISIBLE_BY_3 = "Fizz";
  private static final String DIVISIBLE_BY_5 = "Buzz";

  public static String fizzBuzz(String inputString) throws FizzBuzzException {
    LOGGER.info(String.format("Playing fizz buzz game, input string: %s.", inputString));
    final String[] split = inputString.split("\\s*,\\s*");
    final List<String> result = new ArrayList<String>(split.length);
    for (String input : split) {
      if (input != null) {
        final Integer number;
        try {
          number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
          final String message = String.format(
                  "Input need to be a collection of numbers, example: 5, 3, 8. This string is not a valid number: %s",
                  input);
          LOGGER.warn(message);
          throw new FizzBuzzException(message);
        }
        final String nextAddition;
        if (number % 3 == 0) {
          if (number % 5 == 0) {
            nextAddition = DIVISIBLE_BY_3_AND_5;
          } else {
            nextAddition = DIVISIBLE_BY_3;
          }
        } else if (number % 5 == 0) {
          nextAddition = DIVISIBLE_BY_5;
        } else {
          nextAddition = input;
        }
        result.add(nextAddition);
        if (LOGGER.isDebugEnabled())
          LOGGER.debug(String.format("Converting %s into: %s.", number, nextAddition));
      }
    }
    final String stringResult = StringUtils.join(result, ", ");
    LOGGER.info(String.format("Game played, result: %s", stringResult));
    return stringResult;
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
      out.println("<title>Simple Fizz Buzz</title></head>");
      out.println("<body>");
      String inputFizzBuzz = req.getParameter("input-fizz-buzz");
      if (inputFizzBuzz != null && !inputFizzBuzz.isEmpty()) {
        try {
          final String result = fizzBuzz(inputFizzBuzz);
          out.println("<p>" + result + "</p>");
        } catch (FizzBuzzException e) {
          out.print("<p style=\"color:red\">" + e.getMessage() + "</p>");
        }

      }
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();  // Always close the output writer
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    doGet(req, resp);
  }
}
