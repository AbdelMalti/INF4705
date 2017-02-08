import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadFile {
	private int[] size = { 1000, 5000, 10000, 50000, 100000, 500000 };
	private int[][] serieTest = { {0,1,2,3,4,5,6,7,8,9}, {10,11,12,13,14,15,16,17,18,19}, {20,21,22,23,24,25,26,27,28,29} };
	//private CountingSort countingsort = new CountingSort();
	private long time;
	private float totalTime;

	public ReadFile(){
		
	}
	
	public void read(int serie, int algo)
	{
		//Ici on entre dans chacunes des series.
		//for(int serie = 0; serie < serieTest.length ; serie++){
			int numeroFichier = 10;
			//Ici on fait chacunes des tailles pour la serie actuelle.
				for(int actuelSize : size)
				{
					
					for(int num = 0 ; num < numeroFichier ; ++num)
					{
						
						//On prend le nom du fichier que l'on veut analyser.
						String fileName = "testset" + "_" + actuelSize + "_" + serieTest[serie][num] + ".txt"; 
						
						this.readFromFile(fileName, actuelSize);	
					}
					
				}
				
		//}
	}
	
	/**
	 * Lien du code : https://openclassrooms.com/courses/apprenez-a-programmer-en-java/les-flux-d-entree-sortie
	 */
	private void readFromFile(String file, int sizeOfFile)
	{
		try
		{
			//Lire du fichier
			
		      Scanner scanner = new Scanner(new File("INF4705/INF4705_H17_TP1_donnees/"+file));
		      //int [] tall = new int [sizeOfFile];
		      ArrayList tall = new ArrayList();
		      int i = 0;
		      
		      while(scanner.hasNextInt())
		      {
		    	  String inputFile = scanner.next();
		    	  int tempInt = Integer.parseInt(inputFile);
		    	  
		    	  //tall[i++] = tempInt;
		    	  tall.add(tempInt);
		    	  
		    	  //tab[i++] = tempInt;
		      }
		      scanner.close();
		      
		      
		      totalTime = 0;
				//Démarrage du chrono
				time = System.currentTimeMillis();
				
				CountingSort countingsort = new CountingSort();
				countingsort.countingSort(tall, countingsort.maxNumber(tall));
				countingsort = null;
				
				/*QuickSort quicksort = new QuickSort();
				quicksort.quickSort(tall, 0, tall.length-1);
				//System.out.println("h");
				for(int j=0; j <tall.length ; ++j)
				{
					System.out.println("tab : "+tall[j]);
				}
				quicksort = null;*/
				
				//Affichage du temps d'exécution
				totalTime = System.currentTimeMillis() - time;
				System.out.println(totalTime);
				tall = null;
		      
		} catch (FileNotFoundException e) {
		      e.printStackTrace();
	    }
	}
	
	
}
