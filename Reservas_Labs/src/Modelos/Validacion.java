package Modelos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {

    public static boolean isValidEmail(String email) {
        // Patrón para validar un email
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        // Patrón para validar una contraseña de al menos diez caracteres, solo números
        String passwordRegex = "^\\d{10,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isValidWord(String word) {
        // Patrón para validar que haya solo una palabra compuesta solo de letras y que su longitud sea mayor a 2
        String wordRegex = "^[a-zA-Z]{3,}$";
        Pattern pattern = Pattern.compile(wordRegex);
        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }

}
