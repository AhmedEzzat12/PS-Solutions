#include <iostream>
#include <string>
using namespace std;

int main()
{
    int n,numOfproblems=0,a,temp=0;
    cin>>n;
    for(int i = 0;i<n ;++i)
    {
        for(int j = 0 ; j < 3 ; ++j)
        {
            cin>>a;
            temp+=a;
        }
        if(temp>=2)
            ++numOfproblems;
        temp=0;
    }

    cout<<numOfproblems<<endl;
}
