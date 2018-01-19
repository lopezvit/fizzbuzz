package fi.serviceflow.fizzbuzz.services.impl;

import fi.serviceflow.fizzbuzz.ws.FizzBuzzException;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alejandro López(alejandro) {@literal <Alejandro.Lopez@xplain.net>} on 18/01/2018.
 */
@Service
public class FizzBuzzServiceImpl implements fi.serviceflow.fizzbuzz.services.FizzBuzzService {

  private static final Logger LOGGER = Logger.getLogger(FizzBuzzServiceImpl.class);

  private static final String DIVISIBLE_BY_3_AND_5 = "Fizz Buzz";
  private static final String DIVISIBLE_BY_3 = "Fizz";
  private static final String DIVISIBLE_BY_5 = "Buzz";

  @Override
  public String fizzBuzz(String inputString) throws FizzBuzzException {
    LOGGER.info(String.format("Playing fizz buzz game, input string: %s.", inputString));
    final String[] split = inputString.split("\\s*,\\s*");
    final List<String> result = new ArrayList<>(split.length);
    for (String input : split) {
      if (input != null) {
        final Long number;
        try {
          number = Long.parseLong(input);
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
}
