package com.friday.addressline;

import java.io.Console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.friday.addressline.model.Address;
import com.friday.addressline.service.AddresslineServiceImpl;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddresslineApplication {

  private static final String COMMAND_QUIT = "Q";
  private static final String OPENING_BRACE = "{";
  private static final String CLOSING_BRACE = "}";

  public static void main(String[] args) {

    ApplicationContext context = SpringApplication.run(AddresslineApplication.class, args);

    //Service responsible to separate the fields
    AddresslineServiceImpl addresslineService = context.getBean(AddresslineServiceImpl.class);

    //Input from user. It is expected a concatenated street
    Console console = System.console();
    if (console == null) {
      throw new RuntimeException("Console not available");
    } else {
      console.writer().println("================= F R I D A Y =================");
      console.writer().println("Welcome to our Addressline Program!!!");
      console.flush();
    }

    test:
    while (true) {
      console.flush();
      String userInput = console.readLine("Enter a concatenated street or Q (quit the program): ");
      if (userInput.equals(COMMAND_QUIT)) {
        System.exit(0);
      } else {
        if (userInput.trim().length() > 0) {

          Address address = addresslineService.separateFields(userInput);

          //Format the response - Output
          console.writer().println(OPENING_BRACE + address.getStreetName() + ", " + address.getStreetNumber() + CLOSING_BRACE);

          console.flush();
          continue test;
        }
      }
    }

  }

  @Bean
  public Address address() {
    return new Address();
  }

}
