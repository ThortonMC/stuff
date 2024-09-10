public class CryptoManager {

    public static void main(String[] args) {

        String test = "HELLO";
        int key1 = 105;

        String testd = "HELLO 12DE- 3EWQZX";
        String testd2 = "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT";

        //System.out.println(bellasoEncryption(testd, testd2));

        String testd3 = ";,:;05.G(56;/,9G:;905.";
        System.out.println(caesarDecryption(testd3, 999 ));


        //System.out.println(bellasoDecryption(testd3, testd2));


    }
    public static boolean isStringInBounds(String plainText) {

        int flag = 0;

        for (int i = 0; i < plainText.length(); i++) {

            if (plainText.charAt(i) < 32 || plainText.charAt(i) > 95) {
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
            else {
                newChar = (char) (origChar - key2);
            }
            newString = String.valueOf(newChar);
            dString = dString.concat(newString);
        }
        return dString;
    }

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
    public static String bellasoDecryption(String encryptedText, String bellasoStr) {

        int encryptedTextLen = encryptedText.length();
        int bellasoStrLen = bellasoStr.length();

        char origChar;
        char bellaChar;
        char newChar;
        String dString = "";
        int tempChar = 0;
        String shortBellasoStr = "";

        if (encryptedTextLen < bellasoStrLen) {

            shortBellasoStr = bellasoStr.substring(0, encryptedTextLen);

            for (int i = 0; i < shortBellasoStr.length(); i++) {

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

        } else {

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

            if (encryptedTextLen > bellasoStrLen) {

                for (int i = bellasoStrLen; i < encryptedTextLen; i++) {

                    x = i % bellasoStrLen;

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

