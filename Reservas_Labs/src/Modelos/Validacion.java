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
        // Patrón para validar una contraseña de exactamente diez caracteres, números o letras
        String passwordRegex = "^[a-zA-Z0-9]{10}$";
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

    public static boolean isValidUsername(String username) {
        // Patrón para validar un nombre de usuario con letras y números, sin espacios
        String usernameRegex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(usernameRegex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

}
