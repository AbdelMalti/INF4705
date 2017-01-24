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


public class Quicksort {
	
	private FileInputStream fis;
	private BufferedInputStream bis;
	private FileChannel fc;
	private long time;
	private int[] size = {1000, 5000, 10000, 50000, 100000, 500000};
	private int[][] serieTest = {{0,1,2,3,4,5,6,7,8,9}, 
									{10,11,12,13,14,15,16,17,18,19}, 
									{20,21,22,23,24,25,26,27,28,29}};
	private float totalTime;

	public Quicksort(){
		
	}
	
	public void sort(){
		//Ici on entre dans chacunes des series.
		for(int serie = 0; serie < serieTest.length ; serie++){
			
			//Ici on fait chacunes des tailles pour la serie actuelle.
				for(int actuelSize : size){
					
					for(int num = 0 ; num < 10 ; ++num){
						
						//On prend le nom du fichier que l'on veut analyser.
						String fileName = "testset" + "_" + actuelSize + "_" + serieTest[serie][num] + ".txt"; 
						totalTime = 0;
						
						//On recupere toutes les donnees dans un tableau.
						this.readFromFile(fileName, actuelSize);
						
						//Démarrage du chrono
						time = System.currentTimeMillis();
						
						//On range les donnees du tableau selon different algo.
						//this.quickSort(int arr[], int left, int right);
						
						//Affichage du temps d'exécution
						totalTime = System.currentTimeMillis() - time;
					
					}
					
				}
				
		}
	}
	
	/**
	 * Lien du code : https://openclassrooms.com/courses/apprenez-a-programmer-en-java/les-flux-d-entree-sortie
	 */
	private void readFromFile(String file, int sizeOfFile){
		try{
			//Lire du fichier
		      /******/
		      Scanner scanner = new Scanner(new File(file));
		      int [] tall = new int [sizeOfFile];
		      int i = 0;
		      while(scanner.hasNextInt()){
		         tall[i++] = scanner.nextInt();
		         System.out.println("Num : "+tall[i]);
		      }
		      /******/
		     /* 
		      //On crée un buffer correspondant à la taille du fichier
		      ByteBuffer bBuff = ByteBuffer.allocate(size);
					
		      //Démarrage de la lecture
		      fc.read(bBuff);
		      //On prépare à la lecture avec l'appel à flip
		      bBuff.flip();*/
		      
		} catch (FileNotFoundException e) {
		      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	/**
	 * Lien du code : http://www.algolist.net/Algorithms/Sorting/Quicksort
	 */
	private int partition(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	 
	private void quickSort(int arr[], int left, int right) {
		
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	}
}
