
package primitivewritechars;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author julián
 */
public class Primitivewritechars {

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File texto4 = new File("/home/oracle/Documents/texto4.txt");
        
        FileOutputStream salida = new FileOutputStream(texto4);
        BufferedOutputStream bsalida = new BufferedOutputStream(salida);
        DataOutputStream dsalida=new DataOutputStream(bsalida);
        
        
        
        
        FileInputStream entrada = new FileInputStream(texto4);
        BufferedInputStream bentrada = new BufferedInputStream(entrada);
        DataInputStream dentrada = new DataInputStream(bentrada);
        String cadea1="Esto é unha cadea \n";
        String cadea2="Esto é unha cadea \n";

        dsalida.writeChars(cadea1);
        System.out.print("writeChars escribiu: "+cadea1);
        int lcadea1=dsalida.size();
        System.out.println("writeChars escribiu: "+lcadea1+"bytes");

        dsalida.writeChars(cadea2);       
        System.out.print("writeChars escribiu "+cadea2);
        System.out.println("writeChars escribiu: "+(dsalida.size()-lcadea1)+"bytes");
        System.out.println("bytes totais escritos"+dsalida.size());
        dsalida.close();
        int totaisporler=dentrada.available();
        System.out.println("bytes totais por ler"+totaisporler);
        String lercadea1="";
        for(int i=0;i<cadea1.length();i++){
           lercadea1+=dentrada.readChar();
        }
        System.out.println("readChar leu : "+lercadea1);

        int bytesprimeira=totaisporler-dentrada.available();
        System.out.println("O numero bytes lidos e "+bytesprimeira);
        System.out.println("bytes restantes por ler"+dentrada.available());

         String lercadea2="";
       for(int i=0;i<cadea2.length();i++){
           lercadea2+=dentrada.readChar();
        
       } 
       System.out.println("readChar leu : "+lercadea2);

      System.out.println("O numero bytes lidos e "+(totaisporler-bytesprimeira));
      System.out.println("bytes restantes por ler"+dentrada.available());

       dentrada.close();
       
        
       


// writeChars escribiu: Esta e unha cadea\n
//writeChars escribiu:  36bytes
//writeChars escribiu: Esta e unha cadea\n
//writeChars escribiu:  36bytes
//bytes totais escritos = 72
//lemos a primeira cadea:  Esta e unha cadea
//
//o numero de bytes lidos e :36
//bytes restantes por ler : 36
//lemos a segunda cadea:  Esta e unha cadea
//
//o numero de bytes lidos e :36
//bytes restantes por ler : 0
    }
    
}
