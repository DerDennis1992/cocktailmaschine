/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cocktail;


/**
 *
 * @author root
 */
public class Cocktail {
   private int IntID;
   private String StringName;
   private String StringRezept;
   private String [] RezeptGetraenkename;
   private int[] RezeptVolumen = new int[17];//ml
   private String StringSpeicherpfadDesBildes;
   
   public Cocktail(int InitInputID
           ,String StringInputName
           ,String StringInputRezept
           ,String StringInputSpeicherpfadDesBildes
           ,String[] Rezept){
      IntID=InitInputID;
      StringName=StringInputName;
      StringRezept=StringInputRezept;
      StringSpeicherpfadDesBildes=StringInputSpeicherpfadDesBildes;
      this.RezeptGetraenkename = Rezept;
      setRezeptVolumen();
       System.out.println(Rezept[1]);
   }   
   public int getIntID (){
       return IntID;
   }   
   public String getName(){
       return StringName;
   } 
   public String getRezept(){
       System.out.println(StringRezept);
       return StringRezept;
   }
   public String getSpeicherpfadDesBildes(){
       return StringSpeicherpfadDesBildes;
   }
   
   private void setRezeptVolumen(){
       String [] StrTempRezept;       
       StrTempRezept=StringRezept.split(" ");
       for(int i=1; i<StrTempRezept.length; i++){
           try{
               if (!StrTempRezept[i].isEmpty()){
                RezeptVolumen[i-1]=Integer.parseUnsignedInt(StrTempRezept[i].trim())*20;//ml  
               }
           }
           catch (NumberFormatException n){
               System.out.println(n.getMessage());
           }
       }
   }
   public String getPrintRezept(int i){
       String a;
       try{
            a = (RezeptGetraenkename[i]+": "+RezeptVolumen[i]+" ml");
       }
       catch (NullPointerException e){
           a="buh";
       }
       return a;
   }
}