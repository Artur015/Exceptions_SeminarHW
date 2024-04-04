package Exceptions_SeminarHW;

import Exceptions_SeminarHW.Exceptions.IllegalUserDetailFormatException;
import Exceptions_SeminarHW.Exceptions.WrongNumberOfUserDetailsException;

import java.io.IOException;
import java.util.Scanner;

public class View {
    Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void run(){
        while (true) {
            try {
                String[] userDetails = getUserDetails(prompt1);
                controller.validateEnteredUserDetails(userDetails);
                controller.saveToFile(userDetails);
                break;
            } catch (WrongNumberOfUserDetailsException | IllegalUserDetailFormatException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }



    static String prompt1 = "Пожалуйста, введите свои данные пользователя (6 параметров), разделенные знаком пробела (другие знаки не допускаются) в поле " +
            "следующий порядок и формат: Имя Фамилия Отчество, дата рождения (дд.мм.гггг), номер телефона (только цифры), пол (f или m): ";

    private String getString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String response = scanner.nextLine();
        return response;
    }

    public String[] getUserDetails(String prompt) {
        String response = getString(prompt);
        int requiredLength = 6;
        String[] responseArray = response.split(" ");
        if (responseArray.length != requiredLength) {
            throw new WrongNumberOfUserDetailsException(responseArray.length, requiredLength);
        }
        return responseArray;
    }
}
