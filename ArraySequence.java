import java.util.NoSuchElementException;

public class ArraySequence implements IntegerSequence{

  int currentIndex;
  int[] data;

  public ArraySequence(int[] other){
    data = other;
    currentIndex = 0;
  }

  public ArraySequence(IntegerSequence otherseq){
    int size = 0;
    int[] temp = new int[otherseq.length()];
    for (int i = 0; otherseq.hasNext(); i++){
      temp[i] = otherseq.next();
      size++;
    }
    data = new int[size];
    for (int i = 0; i < data.length; i++){
      data[i] = temp[i];
    }
    otherseq.reset();
  }

  public boolean hasNext(){
    return currentIndex < data.length;
  }

  public int next(){
    if (!(hasNext())){
      throw new NoSuchElementException("No more elements");
    }
    int temp = data[currentIndex];
    currentIndex++;
    return temp;
  }
  public int length(){
    return data.length;
  }

  public void reset(){
    currentIndex = 0;
  }

}
