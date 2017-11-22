package queriesonfile;

import java.util.ArrayList;

public class Tool {
    public static void printArrayList(ArrayList<String> arrayToPrint, String separator){
        String separador = "";
        String textToPrint = "";
        for(String colunaNome : arrayToPrint) {
            textToPrint += separador + colunaNome;
            separador = " "+ separator +" ";
        }
        System.out.println(textToPrint);
    }
}
