package fi.serviceflow.fizzbuzz.services;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import fi.serviceflow.fizzbuzz.ws.FizzBuzzException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Alejandro López(alejandro) {@literal <Alejandro.Lopez@xplain.net>} on 08/01/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/testApplicationContext.xml"})
public class FizzBuzzServiceTest {

  @Autowired
  FizzBuzzService fizzBuzzService;

  @Test
  public void testFizzBuzz() throws Exception {
    final String result = fizzBuzzService.fizzBuzz("5, 3,7,  10,15,77");
    assertThat(result, is("Buzz, Fizz, 7, Buzz, Fizz Buzz, 77"));
  }

  @Test(expected = FizzBuzzException.class)
  public void testFizzBuzzException() throws Exception {
    final String result = fizzBuzzService.fizzBuzz("5, 3,7,  10,15,77'");
    System.err.println(result);
    assert false;
  }
}