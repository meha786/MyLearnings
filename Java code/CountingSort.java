
public class CountingSort {
	
	
	public static void countArray(int arr[], int n, int count[], int maxVal)
	{
		for(int i=0;i<=maxVal;i++)
		{
			count[i] = 0;
		}
		
		System.out.println("count initiallized to zero");
		for(int i=0;i<=maxVal;i++)
		{
			System.out.println(count[i]);
		}
		
		
		for(int i=0;i<n;i++) 
		{
			count[arr[i]] = count[arr[i]] + 1;
		}
		
		System.out.println("stored count");
		
		
		for(int i=0;i<=maxVal;i++)
		{
			System.out.println(count[i]);
		}
		
		System.out.println("cumulative sum");
		
		for(int i=1;i<=maxVal;i++)
		{
			count[i] = count[i]+count[i-1];
		}
		
		for(int i=0;i<=maxVal;i++)
		{
			System.out.println(count[i]);
		}
		
		System.out.println("final output");
		
		
		int output[] = new int[n];
		
		for(int i=n-1;i>=0;i--)
		{
			output[count[arr[i]]-1] = arr[i];
			
			--count[arr[i]];
			
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.println(output[i]);
		}
		
		
	}
	

	public static int calMax(int arr[], int n)
	{
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			if(max < arr[i])
			{
				max = arr[i];
			}
		}
		return max;
	}
	
	public static void main(String args[])
	{
		int arr[] = new int[]{1,2,4,2,6,1,3,9};
		int n = arr.length;
		int maxVal = calMax(arr,n);
		int count[] = new int[maxVal+1];
		countArray(arr,n,count,maxVal);
		
		
	}

}
