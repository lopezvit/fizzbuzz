package fi.serviceflow.fizzbuzz.ws;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author Alejandro López(alejandro) {@literal <Alejandro.Lopez@xplain.net>} on 08/01/2018.
 */
public class FizzBuzzServletTest {

  @Test
  public void testFizzBuzz() throws Exception {
    final FizzBuzzServlet fizzBuzzServlet = new FizzBuzzServlet();
    final String result = fizzBuzzServlet.fizzBuzz("5, 3,7,  10,15,77");
    assertThat(result, is("Buzz, Fizz, 7, Buzz, Fizz Buzz, 77"));
  }

  @Test(expected = FizzBuzzException.class)
  public void testFizzBuzzException() throws Exception {
    final FizzBuzzServlet fizzBuzzServlet = new FizzBuzzServlet();
    final String result = fizzBuzzServlet.fizzBuzz("5, 3,7,  10,15,77'");
  }
}