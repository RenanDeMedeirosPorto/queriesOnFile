package queriesonfile;

import java.io.FileNotFoundException;
import java.io.IOException;

public class QueriesOnFile {
    
    public static void main(String[] args) {
        try {
            checkArguments(args);
            File file = new File();
            file.readFile(args[0]);

            FileConsole fileConsole = new FileConsole(file);
            fileConsole.init();
          } catch (FileNotFoundException fileException){
            System.out.println("Arquivo não encontrado");
            hoToUse();
            System.exit(0);
          } catch (IOException e) {
            System.out.println("Ocorreu algum erro !!!");
            System.exit(0);
          }
    }
    
    private static void checkArguments(String[] argumentos){
        if(argumentos.length == 0){
            hoToUse();
            System.exit(0);
        }
    }
    
    private static void hoToUse(){
            System.out.println("Como usar: java QueriesOnFile.java filename.format");
    }
}
