/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Taylor Horton
 * @version 09/10/24
 */
public class CryptoManager {

	
	private static final char LOWER_RANGE = 32;
	private static final char UPPER_RANGE = 95;
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
    public static boolean isStringInBounds(String plainText) { 
    	
        int flag = 0;

        for (int i = 0; i < plainText.length(); i++) {

            if (plainText.charAt(i) < LOWER_RANGE || plainText.charAt(i) > UPPER_RANGE) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            return false;
        else {
            return true;
        }
      
    }
    
	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
    public static String caesarEncryption(String plainText, int key) {

        if(isStringInBounds(plainText) == false){

            return "The selected string is not in bounds, Try again.";
        }
        while (key > 95) {

            key -= (95 - 32 + 1);

        }
        
        String newString;
        String eString = "";
        char origChar;
        char newChar;

        for (int i = 0; i < plainText.length(); i++) {

            origChar = plainText.charAt(i);

            int x = 0;

            if (origChar + key > 95) {

                x = (origChar + key) - 95;
                newChar = (char) (31 + x);
                newString = String.valueOf(newChar);
                eString = eString.concat(newString);

            } else {

                newChar = (char) (origChar + key);
                newString = String.valueOf(newChar);
                eString = eString.concat(newString);

            }
        }
        return eString;
    }
    
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
    public static String caesarDecryption(String encryptedText, int key) {

        int flag = 0;
        int key2 = key;

        if (key2 > 95) {

            flag = 1;
        }
        while (key2 > 95) {

            key2 -= (95 - 32 + 1);
        }
        char origChar;
        char newChar;

        int x = 0;
        int y = 0;
        int z = 0;
     
        String newString;
        String dString = "";
        for (int i = 0; i < encryptedText.length(); i++) {

            origChar = encryptedText.charAt(i);

            if (flag == 1 && origChar - key2 < 32) {

                x = origChar - 31;
                y = x + 95;
                z = y - key2;
                newChar = (char) z;
            }
            else if(origChar - key2 <32) {
            	
                x = origChar - 31;
                y = x + 95;
                z = y - key2;
                newChar = (char) z;
            		
            }
            else {
                newChar = (char) (origChar - key2);
            }
            newString = String.valueOf(newChar);
            dString = dString.concat(newString);
        }
        return dString;
    }
    
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
    public static String bellasoEncryption(String plainText, String bellasoStr) {

        int plainTextLen = plainText.length();
        int bellasoStrLen = bellasoStr.length();

        char origChar;
        char bellaChar;
        char newChar;
        String eString = "";
        int tempChar = 0;
        String shortBellasoStr = "";

        if (plainTextLen < bellasoStrLen) {

            shortBellasoStr = bellasoStr.substring(0, plainTextLen);


            for (int i = 0; i < shortBellasoStr.length(); i++) {

                origChar = plainText.charAt(i);
                bellaChar = bellasoStr.charAt(i);

                tempChar = origChar + bellaChar;

                if (tempChar > 95) {

                    while (tempChar > 95) {

                        tempChar -= 64;
                    }
                }
                newChar = (char) tempChar;
                eString = eString.concat(String.valueOf(newChar));
            }
        } else {

            for (int i = 0; i < bellasoStrLen; i++) {

                origChar = plainText.charAt(i);
                bellaChar = bellasoStr.charAt(i);


                tempChar = origChar + bellaChar;

                if (tempChar > 95) {

                    while (tempChar > 95) {

                        tempChar -= 64;
                    }
                }
                newChar = (char) tempChar;
                eString = eString.concat(String.valueOf(newChar));
            }

            int x = 0;

            if (plainTextLen > bellasoStrLen) {

                for (int i = bellasoStrLen; i < plainTextLen; i++) {

                    x = i % bellasoStrLen;

                    bellaChar = bellasoStr.charAt(x);
                    origChar = plainText.charAt(i);

                    tempChar = origChar + bellaChar;

                    if (tempChar > 95) {

                        while (tempChar > 95) {

                            tempChar -= 64;
                        }
                    }
                    newChar = (char) tempChar;
                    eString = eString.concat(String.valueOf(newChar));
                }
            }
        }
        return eString;
    }
    
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
    public static String bellasoDecryption(String encryptedText, String bellasoStr) {

        int encryptedTextLen = encryptedText.length();
        int bellasoStrLen = bellasoStr.length();

        char origChar;
        char bellaChar;
        char newChar;
        String dString = "";
        int tempChar = 0;
        String shortBellasoStr = "";

        if (encryptedTextLen < bellasoStrLen) {						// checks if the Cipher key is longer than the text to be decrypted

            shortBellasoStr = bellasoStr.substring(0, encryptedTextLen);

            for (int i = 0; i < shortBellasoStr.length(); i++) {				// iterates through the length of the cipher key shortened to length of the text

                origChar = encryptedText.charAt(i);
                bellaChar = bellasoStr.charAt(i);

                if (bellaChar - origChar > 31 && origChar - 64 > 0 || bellaChar - origChar == 32) {

                    newChar = (char) (bellaChar - origChar);
                }
                else if(bellaChar - origChar > 31 && origChar - 64 < 0){     // this is to check if the original unencrypted text plus the character to cipher it , when added together if subtracting 64 it would still be greater than 95, so in order to decrypt it would need to subtract 64 another time.


                   newChar = (char) ((origChar + 64 + 64) - bellaChar);

               }
                else {

                    tempChar = (origChar + 64) - bellaChar;
                    newChar = (char) (tempChar);
                    if(newChar == 96)
                        newChar = 32;

                }
                dString = dString.concat(String.valueOf(newChar));
            }

        } else {												// if the cipher key is not shorter than the text to be encrypted, than iterate through the length of the cipher key 

            for (int i = 0; i < bellasoStrLen; i++) {

                origChar = encryptedText.charAt(i);
                bellaChar = bellasoStr.charAt(i);

                if (bellaChar - origChar > 31 && origChar - 64 > 0 || bellaChar - origChar == 32) {

                    newChar = (char) (bellaChar - origChar);
                }
                else if(bellaChar - origChar > 31 && origChar - 64 < 0){     // this is to check if the original unencrypted text plus the character to cipher it , when added together if subtracting 64 it would still be greater than 95, so in order to decrypt it would need to subtract 64 another time.

                    newChar = (char) ((origChar + 64 + 64) - bellaChar);

                }
                else {

                    tempChar = (origChar + 64) - bellaChar;
                    newChar = (char) (tempChar);
                    if(newChar == 96)
                        newChar = 32;


                }
                dString = dString.concat(String.valueOf(newChar));

            }
            int x = 0;

            if (encryptedTextLen > bellasoStrLen) {                        // additional if statement after iterating through length of cipher key length, if the text to be encrypted is longer than the cipher key there is more to be decrypted.

                for (int i = bellasoStrLen; i < encryptedTextLen; i++) {        // loop starts at the end of the cipher key length till the end of the text to be decrypted length, this will iterate the only remaining characters that exceed the length of the cipher key length.

                    x = i % bellasoStrLen;		// to match the remaining characters exceeding the cipher key length, modulus the index by the cipher key length , that way the character that exceeds the cipher key length will match the start of the cipher again with the remainder value

                    bellaChar = bellasoStr.charAt(x);
                    origChar = encryptedText.charAt(i);

                    if (bellaChar - origChar > 31 && origChar - 64 > 0 || bellaChar - origChar == 32){

                        newChar = (char) (bellaChar - origChar);
                    }
                    else if(bellaChar - origChar > 31 && origChar - 64 < 0){     // this is to check if the original unencrypted text plus the character to cipher it , when added together if subtracting 64 it would still be greater than 95, so in order to decrypt it would need to subtract 64 another time.


                        newChar = (char) ((origChar + 64 + 64) - bellaChar);

                    }
                    else {

                        tempChar = (origChar + 64) - bellaChar;
                        newChar = (char) (tempChar);
                        if(newChar == 96)
                            newChar = 32;
                    }
                    dString = dString.concat(String.valueOf(newChar));
                }
            }
        }
        return dString;
    }
}
