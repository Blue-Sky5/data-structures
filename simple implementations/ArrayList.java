package list;

public class ArrayList implements list {
    public int[] getArray() {
        return array;
    }
    public void setArray(int[] array) {
        this.array = array;
    }
    public int getArrayLength() {
        return arrayLength;
    }
    public void setArrayLength(int arrayLength) {
        this.arrayLength = arrayLength;
    }
    public int getTail() {
        return tail;
    }
    public void setTail(int tail) {
        this.tail = tail;
    }
    private int[] array;
    private int arrayLength;
    private int tail = -1;
    //.....................................................
    public ArrayList(){
        this.array = new int[1];
        this.arrayLength = this.array.length;
    }
    //.....................................................
    @Override
    public void insert(int data, int index) {
        if(index<0 || index-1 > this.tail){
            System.out.println("IndexOutOfBound");
            throw new IndexOutOfBoundsException();
        }
        else {
            expand();
            shiftForward(index);
            this.array[index] = data;
            this.tail+=1;
        }
    }
    private void shiftForward(int index) {
        if (tail != -1){
           for(int i = tail+1 ; i > index ; i--){
               this.array[i] = this.array[i-1];
           }
        }

    }
    private void expand() {
        if (this.tail+1 == this.arrayLength){
            int[] temp = new int[arrayLength*2];
            for (int i = 0 ; i < this.arrayLength ; i++){
                temp[i] = this.array[i];
            }
            this.array = temp;
            this.arrayLength = array.length;
        }
    }
    //.....................................................
    @Override
    public void delete(int index) {
        if(index<0 || index > this.tail){
            System.out.println("IndexOutOfBound");
            throw new IndexOutOfBoundsException();
        }
        else {
            shiftBackward(index);
            shrink();
            this.tail-=1;
        }
    }
    private void shrink() {
        double temp = (double)tail/(double)arrayLength;
        if(temp<= 0.25){
            int[] temp_a = new int[arrayLength/2];
            for (int i = 0 ; i <= tail ; i++){
                temp_a[i] = this.array[i];
            }
            this.array = temp_a;
            arrayLength = this.array.length;
        }
    }
    private void shiftBackward(int index) {
        for(int i = index ; i < tail ; i++){
            this.array[i] = this.array[i+1];
        }
        this.array[tail] = 0;
    }
    //.....................................................
    @Override
    public void replace(int data, int index) {
        if (index > tail || index <0){
            System.out.println("IndexOutOfBound");
            throw new IndexOutOfBoundsException();
        }
        else {
            this.array[index] = data;
        }
    }
    //.....................................................
    @Override
    public int getData(int index) {
        if (index > tail || index <0){
            System.out.println("IndexOutOfBound");
            throw new IndexOutOfBoundsException();
        }
        else {
            return this.array[index];
        }
    }
}

