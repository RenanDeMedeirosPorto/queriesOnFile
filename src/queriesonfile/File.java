package queriesonfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class File {
    ArrayList<String> header = new ArrayList<>();
    ArrayList<LinkedHashMap<String, String>> lines = new ArrayList<LinkedHashMap<String, String>>();
    
    public ArrayList<String> getHeader(){
        return this.header;
    }
    
    public void setHeader(ArrayList<String> header) {
        this.header = header;
    }
    
    public ArrayList<LinkedHashMap<String, String>> getLines() {
        return lines;
    }

    public void setLines(ArrayList<LinkedHashMap<String, String>> lines) {
        this.lines = lines;
    }
    
    public void readFile(String fileName) throws FileNotFoundException, IOException{
        BufferedReader arquivo = new BufferedReader(new FileReader(fileName));
        String line;
        int numberLine = 0;
        while ((line = arquivo.readLine()) != null) {
            ArrayList<String> linha = new ArrayList<>( Arrays.asList(line.split(",")));
            if ( numberLine == 0 ){
                this.setHeader(linha);
            } else {
                setLinhaHeader(linha);
                
            }
            numberLine++;
        }
    }
    
    public void setLinhaHeader(ArrayList<String> linha){
        LinkedHashMap<String, String> aMap = new LinkedHashMap<String, String>();
        int colunaNumero = 0;
        for (String colunaValor : linha)
        {
            aMap.put(header.get(colunaNumero).toLowerCase(), colunaValor);
            colunaNumero++;
        }
        
        lines.add(aMap);
    }
    
    public int getNumberOfLines(){
        return this.lines.size();
    }
    
    public int getNumberDistinctByHeaderName(String headerName){
        if ( !this.header.contains(headerName.toLowerCase()) ){
            return 0;
        }
        
        LinkedHashMap<String, String> distinctValuesByHeaderName = new LinkedHashMap<String, String>();
        for (LinkedHashMap<String, String> linha : this.lines) {
            distinctValuesByHeaderName.put(linha.get(headerName), linha.get(headerName));
        }
        return distinctValuesByHeaderName.size();        
    }
    
    public void printHeader(){
        Tool.printArrayList(this.header, "|");
    }
    
    public void printLinesByHeaderFilter(String headerName, String value){
        for (LinkedHashMap<String, String> linha : this.lines) {
            if ( linha.get(headerName).toLowerCase().equals(value.toLowerCase())){
                Tool.printArrayList(new ArrayList<String>(linha.values()), "|");
            }
        }
    }
}
