package inicio;
import java.util.ArrayList;
import java.util.Scanner;
import interfazGrafica.*;
/**
 *
 * @author froi
 */
public class Decodificador {
    
    public void iniciar(){
        
        Scanner scan = new Scanner(System.in);
        int repetir;
        String adn1, adn2;
        
        do{
            
            System.out.println("\n\nBIENVENIDO AL DECODIFICADOR DE ADN");
            System.out.println("Ingrese la primera secuencia de ADN");
            adn1 = scan.next();
            System.out.println("Ingrese la segunda secuencia de ADN");
            adn2 = scan.next();
            
            //accedemos a la lógica de la decodificacion
            escanear(adn1, adn2);
            
            //Las siguientes lineas permiten seguir decodificando ADN
            System.out.println("\n\n¿Desea seguir decodificando ADN?");
            System.out.println("1.- Si");
            System.out.println("2.- No");
            
            repetir = scan.nextInt();
        }while(repetir == 1);
        
    }
    
    public void mostrarVentana(){
        
        DecodificadorGrafico v1 = new DecodificadorGrafico();
        v1.setVisible(true);
        
    }
    
    //Funcion que contiene la lógica de la decodificación
    public String escanear(String adn1, String adn2){
            
        boolean invalido = false;
        ArrayList<String> iguales = new ArrayList<>();
        
        //comprobamos que el usuario no haya ingresado algún carácter inválido
        for(int i = 0; i < adn1.length(); i++){
            if(adn1.charAt(i) != 'A' && adn1.charAt(i) != 'C' && adn1.charAt(i) != 'G' && adn1.charAt(i) != 'T' && adn1.charAt(i) != 'a' && adn1.charAt(i) != 'c' && adn1.charAt(i) != 'g' && adn1.charAt(i) != 't')
                invalido = true;
        }
        for(int i = 0; i < adn2.length(); i++){
            if(adn2.charAt(i) != 'A' && adn2.charAt(i) != 'C' && adn2.charAt(i) != 'G' && adn2.charAt(i) != 'T' && adn2.charAt(i) != 'a' && adn2.charAt(i) != 'c' && adn2.charAt(i) != 'g' && adn2.charAt(i) != 't')
                invalido = true;
        }
        
        //La siguiente condicion impide que se ejecute la comparación si existen caracteres invalidos en alguna de las dos secuencias
        if(invalido == false){
            
            //Variable que nos indicará el inicio del subString
            int inicioCadena = 0;
            while (inicioCadena < adn1.length()){
                for (int i = inicioCadena+1; i < adn1.length() + 1; i++){
                    String cadena1 = adn1.substring(inicioCadena, i);
                    int inicioCadena2 = 0;
                    
                    while(inicioCadena2 < adn2.length()){
                        for(int j = inicioCadena2+1; j < adn2.length() + 1; j++){
                            if(cadena1.equals(adn2.substring(inicioCadena2, j)))
                                iguales.add(cadena1);
                        }
                        inicioCadena2++;
                    }
                    
                }
                
                inicioCadena++;
            }
            
            int max = iguales.get(0).length();
            int pos = 0;
            for(int i = 0; i < iguales.size(); i++){
                if(iguales.get(i).length() > max){
                    pos = i;
                    max = iguales.get(i).length();
                }
            }
            
            //imptime la cadena resultante
            System.out.println("El resultado de la decodificación es: " + iguales.get(pos));
            return iguales.get(pos);
            
        }else{
            return "Ha ingresado un carácter inválido";
        }
        
    }
    
}
