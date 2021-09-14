#include <iostream>
#include <string>
using namespace std;

int main()
{
    int a,b,numOfyears=0;
    cin>>a>>b;
    while(a<=b)
    {
        a*=3;
        b*=2;
        ++numOfyears;
    }
    cout<<numOfyears<<endl;
}
