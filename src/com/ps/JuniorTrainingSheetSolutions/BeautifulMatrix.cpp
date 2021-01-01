#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    int a,c,r;
    for(int i = 0 ; i < 5 ; ++i)
    {
        for(int j = 0 ; j < 5 ; ++j)
        {
            cin>>a;
            if(a==1)
            {
                c=j;
                r=i;
                goto a;
            }
        }
    }
    a:
    cout<<abs(2-r)+abs(2-c)<<endl;
}
