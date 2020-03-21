package version1;

import java.util.Objects;

public class Main {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";

    //все символы которые будут использоваться
    private static final String DATA = CHAR_LOWER + CHAR_UPPER + NUMBER;

    //ПАРОЛЬ КОТОРЫЙ ИЩЕМ
    private static final String PASS = "12";
    private static int hashCode = Objects.hash (PASS);

    public static void main(String[] args) {

        System.out.println ("PASS = "+PASS);
        System.out.println ("hashCode = "+hashCode);
        System.out.println("String DATA : " + DATA);

        //Пароль который подобрали
        String brutPass;

        //масив который используеться для генерации все возможных комбинаций цифер и букв @DATA
        //{0,0,0,0,0}
        int[] massive = new int[PASS.length ()];

        System.out.println ("Поиск значений...");
        //проверка (massive[PASS.length () - 1] != (DATA.length () - 1)) на то что пройдено все значения
        do {
            brutPass = generateString(massive);
            equalToHashCode(brutPass);

            updMassive (massive);
        } while (massive[PASS.length () - 1] != (DATA.length () - 1));
        System.out.println ("Поиск закончен");
    }

    private static boolean equalToHashCode (String brutPass){
        if (hashCode==Objects.hash (brutPass)){
            System.out.println ("---Найдено---");
            System.out.println ("brutPass = "+brutPass);
            System.out.println ("bruteHashCode = "+Objects.hash (brutPass));
            return true;
        }
        return false;
    }

    private static int[] updMassive (int[] massive) {
        for (int i = 0; i <massive.length ; i++) {
            if(massive[i] >=DATA.length ()-1){
                massive[i] = 0;
            } else {
                massive[i]++;
                break;
            }
        }
        return  massive;
    }

    public static String generateString(int[] massive ) {
        StringBuilder sb = new StringBuilder(massive.length);
        for (int i: massive
             ) {
            char rndChar = DATA.charAt(i);
            sb.append(rndChar);
        }

        //System.out.println ("sb.toString() = "+sb.toString());
        return sb.toString();

    }



}
