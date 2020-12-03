import java.util.NoSuchElementException;

public class Range implements IntegerSequence{

  private int start, end, current;

  public Range(int start, int end){
    if (start > end){
      throw new IllegalArgumentException(start + " cannot be larger than " + end + "!");
    }
    this.start = start;
    this.end = end;
    current = start;
  }

  public void reset(){
    current = start;
  }

  public int length(){
    return end - start + 1;
  }

  public boolean hasNext(){
    return current <= end;
  }

  public int next(){
    if (current > end){
      throw new NoSuchElementException("No more elements in Range(" + start + ", " + end + ")");
    }
    int temp = current;
    current++;
    return temp;
  }

}
