package projeto;

import java.io.BufferedReader;
import java.io.FileReader;
public class ExibirArquivo {
    
    public String nome;
    public int size;

    public ExibirArquivo() { 
        
    }
    public void visualizar(String name){
        
        try {
        
            BufferedReader lerArquivo = new BufferedReader(new FileReader(name));
            String linha = " ";
            
            while((linha = lerArquivo.readLine()) != null){
                System.out.println(linha);
            }
            
            lerArquivo.close();
            
        } catch (Exception e) {
            
        }catch(Error e){  
            
        }
    } 
    
    
    
}
