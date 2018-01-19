package fi.serviceflow.view.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Alejandro López(alejandro) {@literal <Alejandro.Lopez@xplain.net>} on 19/01/2018.
 */
public class Message {

  @NotEmpty(message = "Input is required.")
  private String inputFizzBuzz;

  public String getInputFizzBuzz() {
    return inputFizzBuzz;
  }

  public void setInputFizzBuzz(String inputFizzBuzz) {
    this.inputFizzBuzz = inputFizzBuzz;
  }
}
