
public class MergeSort {
	
	
	
	public static void mergeSort(int arr[], int low, int high)
	{
		if(low<high)
		{
			int mid = low+high/2;
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			merge(arr,low,mid,high);
		}
	}
	
	public static void merge(int arr[], int low,int mid, int high)
	{
		
		int n = high-low+1;
		int n1 = mid-low+1;
		int n2 = high-mid;
		
		int left[] = new int[n1];
		int right[] = new int[n2];
		
		for(int i=0;i<n1;i++)
		{
			left[i] = arr[i];
		}
		
		for(int j=mid;j<n2;j++)
		{
			right[j] = arr[j];
		}
		
		int i=0,j=0,k=0;
		
		while(i<n1 && j<n2)
		{
			
			if(left[i]<right[j])
			{
				arr[k] = left[i];
				i++;
			}else if(left[i]>right[j]){
				arr[k] = right[j];
				j++;
			}
			
			k++;
		}
		
		while(i<n1)
		{
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while(j<n2)
		{
			arr[k] = right[j];
			j++;
			k++;
		}
	}
	
	
	
	public static void main(String args[])
	{
		int arr[] = new int[]{10,3,5,7,3,3,22,3};
		int n = arr.length;
		mergeSort(arr,0,n-1);
		
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i] + " ");
		}
		
	}

}
