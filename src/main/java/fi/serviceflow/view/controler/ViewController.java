package fi.serviceflow.view.controler;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import fi.serviceflow.view.model.Message;

/**
 * @author Alejandro López(alejandro) {@literal <Alejandro.Lopez@xplain.net>} on 18/01/2018.
 */
@Controller
@RequestMapping("/view")
public class ViewController {

  private static final Logger LOGGER = Logger.getLogger(ViewController.class);

  @SuppressWarnings("SameReturnValue")
  @RequestMapping(method = RequestMethod.GET)
  public String index(final Message message) {
    return "index";
  }

  @PostMapping
  public ModelAndView play(@ModelAttribute("message") Message message) {
    RestTemplate template = new RestTemplate();
    String uri = "http://localhost:8080/fizzbuzz/{inputFizzBuzz}";
    String response;
    try {
      response = template.getForObject(uri, String.class, message.getInputFizzBuzz());
    } catch (RestClientException e) {
      LOGGER.warn(String.format("Error %s when calling to the fizz buzz api.", e.getMessage()), e);
      return new ModelAndView("index", "error", "There was a problem with your input string, please, try again.");
    }
    LOGGER.info(String.format("Response %s from the fizz buzz api.", response));
    // model.addAttribute("result", response);
    return new ModelAndView("index", "response", response);
  }

}
