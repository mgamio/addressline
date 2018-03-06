package com.friday.addressline;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.friday.addressline.model.Address;
import com.friday.addressline.service.AddresslineService;
import com.friday.addressline.service.AddresslineServiceImpl;

@SpringBootApplication
public class AddresslineApplication {

  public static void main(String[] args) {

    ApplicationContext context = SpringApplication.run(AddresslineApplication.class, args);
    AddresslineServiceImpl addresslineService = context.getBean(AddresslineServiceImpl.class);

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
      if (userInput.equals("Q")) {
        System.exit(0);
      } else {
        if (userInput.trim().length() > 0) {
          Address address = new Address();
          address.setStreetName("calle name");
          address.setStreetNumber("1212A");

          Address address2 = addresslineService.separateFields(userInput);
          console.writer().println("{" + address2.getStreetName() + ", " + address2.getStreetNumber() + "}");

          console.flush();
          continue test;
        }
      }
    }

  }
}
