#include <iostream>
#include <string>
using namespace std;

int main()
{
    int n,aCount=0,dCount=0;
    string inpt;
    cin>>n>>inpt;
    for( int i = 0;i<inpt.length();++i)
    {
        if(inpt[i]=='A')
            ++aCount;
        else
            ++dCount;
    }
    if(aCount>dCount)
        cout<<"Anton\n";
    else if(aCount<dCount)
        cout<<"Danik\n";
    else
        cout<<"Friendship\n";
}
