/**
 *
 * @author Taniya    T.O.rodrigo 17020735
 */
import java.util.*;
//import java.lang.*; 
//import java.io.*; 



public class Q3 {
         static String[] arr ;
         static String s;
         static int k;
        static int a;
        static int b;
    
         public static String[] hash_table;
         
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Enter a sentence:");
        Scanner input =new Scanner(System.in);
        s= input.nextLine();
        k=(int)Math.pow(2,s.length());
        hash_table=new String[k];
        SubString(s, s.length()); 
        
  
        
        
        
        
        
        
        while(true){
      //  input.nextInt();

        System.out.println("Enter the start index of the substring");
        a=input.nextInt();
        if(a<0){
            System.out.println("ERROR");
            return;
        }
        System.out.println("Enter the end index of the substring");
        b=input.nextInt();
        if(b>s.length()){
            System.out.println("ERROR");
            return;
        }
        StringBuilder st = new StringBuilder(); 
        st.append(s.substring(a, b+1)); 
        st = st.reverse(); 
        //System.out.println(st);
                //   System.out.println(st.toString());

        
       /* SubString(st.toString(), st.length());
           
        for(int i=0;i<k;i++){
           search_hash(hash(arr[i]),arr[i]);
        }*/
       
       search_hash(hash(st.toString()),s.substring(a, b+1),st.toString());
        }
    
}
    
    
    
    
    public static void SubString(String str, int n) {
        
        int array_size=(int)Math.pow(2,n);
        arr = new String[array_size];
        k=0;
        for (int i = 0; i < n; i++){
            
           for (int j = i+1; j <= n; j++){ 
                arr[k++]=str.substring(i, j);
           
           }
        }
        
        for(int i=0; i<k; i++){
            
            insert_hash(hash(arr[i]),arr[i]);   
        }
       
                
    } 
    
    
    
    
    
    
    
    
    
    
    static int hash(String x){
         
        int key=0;
            for(int i=0;i<x.length();i++){
                key=x.charAt(i);
                key+=key*31^i;
    }
    return key%(hash_table.length);
  }
    
    
    
    
    
    
    
    
    static void insert_hash(int key, String value){
       
        for(int i=0; i<k; i++){
            if(hash_table[(i+key)%k]==null ){
                hash_table[(i+key)%k]=value;
               //System.out.println(hash_table[(i+key)%k]);

                break;
        
            }
    
        }
    }
   

    
    
    
    
    static void search_hash(int key, String value, String rev){
       
        //k=hash_table.length
        for(int i=0; i<k; i++){
            if(hash_table[(i+key)%k]==null ){
                System.out.println("["+a+","+b+"] --> Substring\""+value+"\" is Not a Palindrom ");
                return;
        
            }
            
           if(hash_table[(i+key)%k].equals(rev) ){
            System.out.println("["+a+","+b+"] --> Substring\""+value+"\" is a Palindrom ");
                return;
            }
        }
        System.out.println("["+a+","+b+"] --> Substring\""+value+"\" is Not a Palindrom ");
    }
}