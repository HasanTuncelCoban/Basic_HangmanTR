package Basic_Hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class Basic_Hangman{
		static public void tahmin(String kelime, int can){
					char[] filler=new char[kelime.length()];
					int i=0;
					while(i<kelime.length()){
					filler[i]='_';
						if (kelime.charAt(i)==' '){
							filler[i]=' ';
						}
						i++;
					}
					System.out.print(filler);
					System.out.println("  Canýn="+can);
					
					Scanner s= new Scanner(System.in); //Harfleri okumak için scann yapacak
					
					ArrayList<Character> l=new ArrayList<Character>();
					
					while( can>0 ) {
						char x=s.next().charAt(0); //Kullanýcýnýn Harf Giriþi Yaptýðý Yer
						if(l.contains(x)){
							System.out.println("Daha Önce Ayni Harfi Denediniz !");
							continue; //While Dongüsü Devam Eder
						}
						l.add(x);
						if(kelime.contains(x+"")){
								for(int y=0;y<kelime.length();y++){ //Buradaki For LOOP Kullanýcýnýn Girmiþ olduðu karakterleri 
									if(kelime.charAt(y)==x){  //'_' iþareti ile deðiþtirir
										filler[y]=x;
									}
								}
								
						}else{
							can--; // Hatalý Harf Giriþinde Caný Azaltýr
						}
						
						
						if(kelime.equals(String.valueOf(filler))){ //Kullanýcý Tarafýndan Girilen Harflerin 
								System.out.println(filler);      // Fillerre Eþit Olup Olmadýðýný Kontrol Eder
								System.out.println("Tebrikler Oyunu Kazandýnýz :) !!");
								break;
						}
						System.out.print(filler);
					    System.out.println("   Kalan Canýn="+can);
					}
					if (can==0){
					    System.out.println("Üzgünüm Oyunu Kaybettiniz :(");
					}
					
		}
	
	public static void main(String[] args){
			String kelime="Hello World"; // Tahmin Edilecek Kelime
			int can=5; // Oyundaki Tahmin Can Sayýsý Kiþinin 5 Caný Var
			tahmin(kelime,can);
	}
}
