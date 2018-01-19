package fi.serviceflow.fizzbuzz.services;

import fi.serviceflow.fizzbuzz.ws.FizzBuzzException;

/**
 * @author Alejandro López(alejandro) {@literal <Alejandro.Lopez@xplain.net>} on 18/01/2018.
 */
public interface FizzBuzzService {
  String fizzBuzz(String inputString) throws FizzBuzzException;
}
