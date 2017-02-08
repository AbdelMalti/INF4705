import java.util.ArrayList;

public class CountingSort {

	/**
	 * Source : <a>http://www.opendatastructures.org/ods-java/11_2_Counting_Sort_Radix_So.html</a>
	 * @param a
	 * @param k
	 * @return
	 */
	public void countingSort(int[] a, int k) {//k est la valeur la plus grande dans a[]
		
		//System.out.println("size of array : "+a.length);
        short c[] = new short[k];
        for (int i = 0; i < a.length; i++)
            c[a[i]]++;
        for (int i = 1; i < k; i++)
            c[i] += c[i-1];
        short b[] = new short[a.length];
        for (int i = (short) (a.length-1); i >= 0; i--)
            b[--c[a[i]]] = (short) a[i];
        
        b = null;
        c = null;
        a = null;
        //return b;
    }

	public void countingSort(ArrayList a, int k) {//k est la valeur la plus grande dans a[]
		System.out.println("a");
		ArrayList c = new ArrayList(k);
		for (int i = 0; i < k; i++) { c.add(0); }
		System.out.println("b");
		for (int i = 0; i < a.size(); i++) { c.set((Integer) a.get(i), ((Integer)c.get(i))+1 );}
		System.out.println("c");
		
		/*for (int i = 1; i < k; i++)
		{ 
			int n = c.get(i) + c.get(i-1);
			c.set(i, n);//( ((Integer) c.get(i))  + (Integer) c.get(i-1) )) ; 
		}*/
		
		int avant = 0;
		int sum = 0;
		int compt = 0 ;
		for(Object i : c)
		{
			if(i != c.get(0))
			{
				sum = (Integer)i + avant;
				c.set(compt, sum);
			}
			avant = (Integer)i;
			sum = 0;
			++compt;
		}
		
		System.out.println("d");
		ArrayList<Integer> b = new ArrayList();
		for (int i = 0; i < a.size(); i++) { b.add(0); }
		System.out.println("e");
		for (int i = a.size() -1 ; i >= 0; i--)
			b.set( (Integer) c.get( (Integer) a.get(i) -1 ), (Integer) a.get(i));
		System.out.println("f");
		b = null;
        c = null;
        a = null;
	}
	
	/**
	 * Source : http://www.sanfoundry.com/java-program-find-largest-number-array/
	 * @param a
	 * @return
	 */
	public int maxNumber(int[] a){
		int max = a[0];
        for(int i = 0; i < a.length; i++)
        {
            if(max < a[i])
            {
                max = a[i];
            }
        }
        return (max+1);
	}
	
	public int maxNumber(ArrayList a){
		int max = (Integer) a.get(0);
        for(int i = 0; i < a.size(); i++)
        {
            if(max < (Integer) a.get(i))
            {
                max = (Integer) a.get(i);
            }
        }
        return (max+1);
	}
}
