#include<iostream>

using namespace std;

class simple{


    public:

    void show(){

        int *temp;    //wild pointer
        cout<<"temp = "<<*temp;
        temp+=2;
        cout<<"\n temp = "<<*temp;
    }
};


int main(){

    simple obj;
    obj.show();
    return 0;
}