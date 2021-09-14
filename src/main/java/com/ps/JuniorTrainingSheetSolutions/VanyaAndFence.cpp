#include <iostream>

using namespace std;

int main()
{
    int n,h,a,minWidth=0;
    cin>>n>>h;
    for( int i = 0;i<n;++i)
    {
        cin>> a;
        if(a>h)
            minWidth+=2;
        else
            minWidth+=1;
    }
    cout << minWidth<< endl;
}
