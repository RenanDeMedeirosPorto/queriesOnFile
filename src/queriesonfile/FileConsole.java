package queriesonfile;

import java.util.Scanner;

public class FileConsole {

    private final File file;
    
    FileConsole(File file) {
        this.file = file;
    }
    
    public void init(){
        Scanner userInput = new Scanner(System.in);
        while(userInput.hasNext()){
                String comando = userInput.nextLine();
                if(comando.equalsIgnoreCase("sair")){
                        break;
                }
                this.runCommand(comando);
        }
    }
    
    public void runCommand(String command){
        String[] commandVetor = command.split(" ");
        if(commandVetor[0].equalsIgnoreCase("help")){
            this.printHelp();
        }else if(commandVetor.length > 1 && commandVetor[0].toLowerCase().equalsIgnoreCase("count") && commandVetor[1].equals("*")){
            System.out.println("Número de linhas importadas: " + this.file.getNumberOfLines());
        }else if(commandVetor.length > 2 && commandVetor[0].toLowerCase().equalsIgnoreCase("count") && commandVetor[1].toLowerCase().equalsIgnoreCase("distinct")){
            System.out.print("Número de linhas distintas filtradas pelo paramêtro " + commandVetor[1] + ":");
            System.out.println(this.file.getNumberDistinctByHeaderName(commandVetor[2]));
        }else if(commandVetor.length > 2 && commandVetor[0].toLowerCase().equalsIgnoreCase("filter")){
            this.file.printHeader();
            String valueFilter = this.getParamWithoutMainCommand("filter " + commandVetor[1], command);
            this.file.printLinesByHeaderFilter(commandVetor[1], valueFilter);
        } else {
            System.out.println("Commando inválido");
            this.printHelp();
        }
    }
    
    private String getParamWithoutMainCommand(String mainCommand, String command){
        return command.replace(mainCommand, "").trim();
    }
    
    private void printHelp(){
        System.out.println(
                "Digite 'Count *' para a contagem total de registros importados \n"+
                "Digite 'Count distinct [propriedade]' para o total de valores distintos da propriedade (coluna) enviada\n"+
                "Digite 'Filter [propriedade] [valor]' para todas as linhas em que a propriedade enviada possua o valor enviado\n" +
                "Digite 'Sair' para fechar programa"
        );
    }
    
}
