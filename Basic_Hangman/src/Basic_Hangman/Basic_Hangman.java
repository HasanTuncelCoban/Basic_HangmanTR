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
					System.out.println("  Can�n="+can);
					
					Scanner s= new Scanner(System.in); //Harfleri okumak i�in scann yapacak
					
					ArrayList<Character> l=new ArrayList<Character>();
					
					while( can>0 ) {
						char x=s.next().charAt(0); //Kullan�c�n�n Harf Giri�i Yapt��� Yer
						if(l.contains(x)){
							System.out.println("Daha �nce Ayni Harfi Denediniz !");
							continue; //While Dong�s� Devam Eder
						}
						l.add(x);
						if(kelime.contains(x+"")){
								for(int y=0;y<kelime.length();y++){ //Buradaki For LOOP Kullan�c�n�n Girmi� oldu�u karakterleri 
									if(kelime.charAt(y)==x){  //'_' i�areti ile de�i�tirir
										filler[y]=x;
									}
								}
								
						}else{
							can--; // Hatal� Harf Giri�inde Can� Azalt�r
						}
						
						
						if(kelime.equals(String.valueOf(filler))){ //Kullan�c� Taraf�ndan Girilen Harflerin 
								System.out.println(filler);      // Fillerre E�it Olup Olmad���n� Kontrol Eder
								System.out.println("Tebrikler Oyunu Kazand�n�z :) !!");
								break;
						}
						System.out.print(filler);
					    System.out.println("   Kalan Can�n="+can);
					}
					if (can==0){
					    System.out.println("�zg�n�m Oyunu Kaybettiniz :(");
					}
					
		}
	
	public static void main(String[] args){
			String kelime="Hello World"; // Tahmin Edilecek Kelime
			int can=5; // Oyundaki Tahmin Can Say�s� Ki�inin 5 Can� Var
			tahmin(kelime,can);
	}
}
