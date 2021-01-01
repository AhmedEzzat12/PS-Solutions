#include <iostream>
using namespace std;
void swapArr(int * right, int* left)
{
	int temp = *left;
	*left = *right;
	*right = temp;
}
int main()
{
	int n, *arr = NULL,counter=0;
	bool sorted = true;
	cin >> n;

	arr = new int[n];
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
	if (n == 1)
	{
		cout << arr[0];
		return 0;
	}
	while (true)
	{
		if (arr[counter + 1] < arr[counter])
		{
			sorted = false;
			swapArr(&arr[counter + 1], &arr[counter]);
		}
		++counter;
		if (counter == n-1)
		{
			if (sorted)
			{
				break;
			}
			counter = 0;
			sorted = true;
		}
	}

	
	for (size_t i = 0; i < n; i++)
	{
		cout << arr[i];
		if (i != n - 1)
		{
			cout << " ";
		}
	}
	delete[] arr;
	arr = NULL;     


}
