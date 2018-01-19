package fi.serviceflow.fizzbuzz.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.serviceflow.fizzbuzz.services.FizzBuzzService;

/**
 * @author Alejandro López(alejandro) {@literal <Alejandro.Lopez@xplain.net>} on 08/01/2018.
 */
@Controller
public class FizzBuzzController {

  @Autowired
  private FizzBuzzService fizzBuzzService;

  @RequestMapping(value = "/fizzbuzz/{inputFizzBuzz}", method = RequestMethod.GET)
  @ResponseBody
  public String handleApiRequest(@PathVariable String inputFizzBuzz) {
    return fizzBuzzService.fizzBuzz(inputFizzBuzz);
  }

}
