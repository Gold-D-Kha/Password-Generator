import java.util.Random;

public class PasswordGenerator {
    // character pools
    public static final String LOWERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String UPPERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_SYMBOLS = "&(-è_ç/@]}^{#";

    //the randim class allows us to generate a random number which will be uesed to rendomly choose the characters
    private final Random random;

    //constructor
    public PasswordGenerator() {random=new Random();}

    //length tength of the password to be generatde (taken from the user)
    //includeupperCase and etc.. considers if the password should include uppercase, lowercasse, etc
    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers,
                                   boolean includeSpecialSymbols) {
        // we will use string builder over string for better effieciency
        StringBuilder passwordBuilder = new StringBuilder();

        // store valid charachtere (toggle states)
        String validCharacters ="";
        if (includeUppercase) validCharacters += UPPERCASE_CHARACTERS;
        if (includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
        if (includeNumbers) validCharacters += NUMBERS;
        if (includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;

        //build password
        for (int i = 0; i < length; i++) {
            // generate a random index
            int randomIndex = random.nextInt(validCharacters.length());

            //get the char based on the random index
            char randomChar = validCharacters.charAt(randomIndex);

            // store char based on the random index
            passwordBuilder.append(randomChar);

            //do this until we have recheved the length that the user has provided to us
        }

        // return the result
        return passwordBuilder.toString();
    }

}
