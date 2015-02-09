/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

/**
 *
 * @author muuuh
 */

import java.io.*;

public class readFile {
    
    private FileReader CocktailEinlesen;
    private BufferedReader InputCocktailInfo;
    private FileReader RezeptEinlesen;
    private BufferedReader InputRezeptInfo;

   
      
    /**
     *
     * @param CocktailID_Input
     */
    public readFile(String StrRezeptauswahl){
        
        try{
            
         CocktailEinlesen = new FileReader("/home/malte/Schreibtisch/Workspace/meep"+StrRezeptauswahl+".md");
         
         InputCocktailInfo = new BufferedReader(CocktailEinlesen); 
         
       }
       catch (FileNotFoundException b){
           System.out.println("muuuh");
       }
        
        try{
            RezeptEinlesen = new FileReader("/home/malte/Schreibtisch/Workspace/meep"+StrRezeptauswahl+".mdr");
            InputRezeptInfo = new BufferedReader(RezeptEinlesen);
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        
    }
    public String StringGet_Rezept() throws EOFException{
        String zeile;
        try{        
           
           
           if ((zeile = InputRezeptInfo.readLine()) == null) {
               
               zeile =	"-"; // wenn keine zeile mehr da ist wird der Rückgabewert "-" ansonsten die Zeile
               throw new EOFException("EndofSpecs at meepX.mdr");
           }
        }   
        catch( IOException a) {
            System.out.println("EndofSpecs at meepX.mdr");
            throw new EOFException("EndofSpecs at meepX.mdr");
            //return "error reading line";
        }
        
        System.out.println(zeile);
        return zeile;
    }
    
    public String StringGet_CocktailInfo() throws EOFException{
        String zeile;
        try{        
           
           
           if ((zeile = InputCocktailInfo.readLine()) == null) {
               
               zeile =	"-"; // wenn keine zeile mehr da ist wird der Rückgabewert "-" ansonsten die Zeile
               throw new EOFException("EndofSpecs at meepX.md");
           }
        }   
        catch( IOException a) {
            throw new EOFException("EndofSpecs at meepX.md");
            //return "error reading line";
        }
        
        System.out.println(zeile);
        return zeile;
    }
    
}