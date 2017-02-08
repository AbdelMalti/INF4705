import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if( true)//args.length > 0)
		{
			int serie1 = 0;
			int serie2 = 1;
			int serie3 = 2;
			/*
			ArrayList listOfData = new ArrayList();
			ArrayList TimeToSort = new ArrayList();
			CountingSort countingsort = new CountingSort();*/
			
			int algo = 1;
			
			ReadFile read = new ReadFile();
		
			read.read(serie2, algo);
			
			System.out.println("*********************Debut*************************");
			
			/*for(Object ta : listOfData)
			{
				int tableToSort[][] = (int[][]) ta;
				for(int[] t : tableToSort)
				{	
					//int maxN = maxNumber(t) + 1;
					//System.out.println("maxNumber : "+maxN);
					/*
					totalTime = 0;
					//Démarrage du chrono
					time = System.currentTimeMillis();
					//countingsort.countingSort(t, maxN);
					
					
					//Affichage du temps d'exécution
					totalTime = System.currentTimeMillis() - time;
					System.out.println(totalTime);
					TimeToSort.add(totalTime);
				}
				
			}*/
			/*
			for(Object sa : listOfData){
				int tableSorted[] = (int[]) sa;
				for(int i : tableSorted)
				{
						System.out.println(i);
				}
			}*/
			
			System.out.println("**********************Fin**************************");
			
			/*for(String string : args)
			{
				System.out.println("In commande : "+string);
			}*/
			
		}
		//System.out.println("In commande : end ");
	}
}
