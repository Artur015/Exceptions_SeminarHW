package Exceptions_SeminarHW;

import Exceptions_Sem3_HomeTasks.Exceptions.IllegalUserDetailFormatException;
import Exceptions_Sem3_HomeTasks.Exceptions.WrongNumberOfUserDetailsException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(controller);

        view.run();
    }



}
