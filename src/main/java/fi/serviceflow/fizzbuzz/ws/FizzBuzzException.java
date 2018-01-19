package fi.serviceflow.fizzbuzz.ws;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Alejandro López(alejandro) {@literal <Alejandro.Lopez@xplain.net>} on 08/01/2018.
 */
@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE, reason="Wrong Input String")
public class FizzBuzzException extends RuntimeException {
  public FizzBuzzException(String message) {
    super(message);
  }
}
