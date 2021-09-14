#include <iostream>

using namespace std;

int main()
{
    string a, b;
    int resa = 0, resb = 0;
    cin >> a >> b;
    for (int i = 0; i < a.size(); ++i)
    {
        resa += ((a[i] - 'A') % 32);
        resb += ((b[i] - 'A') % 32);
    }
    if (resa - resb > 0)
    {
        printf("1");
    }
    else if (resa - resb < 0)
    {
        printf("-1");
    }
    else
    {
        printf("0");
    }
}

//aslkjlkasdd
//asdlkjdajwi