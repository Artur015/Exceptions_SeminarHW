package Exceptions_SeminarHW;

import Exceptions_SeminarHW.Exceptions.IllegalUserDetailFormatException;

import java.io.IOException;

public class Controller {
    Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void validateEnteredUserDetails(String[] responseArray) {
        String message;
        int userParameterIndex = 3;
        int maxElInBirthdate = 3;
        String[] stringBirthdate = responseArray[userParameterIndex].split("\\.");
        if (stringBirthdate.length != maxElInBirthdate) {
            message = "Неверное количество элементов даты рождения. ";
            throw new IllegalUserDetailFormatException(message);
        }
        int[] birthDate = new int[stringBirthdate.length];
        for (int i = 0; i < birthDate.length; i++) {
            try {
                birthDate[i] = Integer.parseInt(stringBirthdate[i]);
            } catch (NumberFormatException e) {
                message = "Некоторые элементы даты рождения не являются числами. ";
                throw new IllegalUserDetailFormatException(message);
            }
        }
        userParameterIndex++;

        try {
            int phoneNumber = Integer.parseInt(responseArray[userParameterIndex]);
        } catch (NumberFormatException e) {
            message = "Некоторые элементы телефонного номера не являются числами. ";
            throw new IllegalUserDetailFormatException(message);
        }
        userParameterIndex++;
        int maxElInSex = 1;
        if (responseArray[userParameterIndex].length() != maxElInSex) {
            message = "Параметр пола не является одним символом. ";
            throw new IllegalUserDetailFormatException(message);
        }

        if (!responseArray[userParameterIndex].equals("m") && !responseArray[userParameterIndex].equals("f")) {
            message = "Введен неправильный параметр пола. ";
            throw new IllegalUserDetailFormatException(message);
        }
    }

    public void saveToFile(String[] userDetails) throws IOException {
        model.saveToFile(userDetails);
    }
}
