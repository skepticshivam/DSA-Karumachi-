public class TwoStacksInAnArray {

    int[] array;
    int headOne,headTwo;

    public TwoStacksInAnArray(int n){
        array=new int[n];
        headOne=-1;
        headTwo=array.length;

    }

    public void pushX(int data){
        if(headTwo-headOne>1)
            array[++headOne]=data;
        else
            System.out.println("No space to fill data on stack1 ");
    }
    public void pushY(int data){
        if(headTwo-headOne>1)
            array[--headTwo]=data;
        else 
            System.out.println("No space to fill data on stack2 ");

    }
    public int popX(){
        if(headOne>-1)
            return array[headOne--];
        else {
            System.out.println("underflow stack1");
            return 0;
        }
    }
    public int popY(){
        if(headTwo<array.length)
            return array[headTwo++];
        else{
            System.out.println("underflow stack2");
            return 0;
        }
    }
    public boolean isEmptyX(){
        return (headOne==-1);
    }
    public boolean isEmptyY(){
        return (headTwo==(array.length));
}

    public static void main(String[] args) {
   
        TwoStacksInAnArray twostack=new TwoStacksInAnArray(10);
        twostack.pushX(10);
        twostack.pushY(9);
        twostack.pushX(100);
        twostack.pushY(99);
        System.out.println("Poped element from stack 1: "+twostack.popX());
        System.out.println("Poped element from stack 2: "+twostack.popY());

    

}
}
