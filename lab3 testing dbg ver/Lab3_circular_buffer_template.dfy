// class CircularMemory
// This class implements a cicular buffer with with 2 int typed pointers
class CircularMemory
{
  var cells : array<int>;
  var read_position : int;
  var write_position : int;
  var isFlipped : bool;

  constructor Init(cap : int) 
    requires cap > 0
  {
    cells := new int[cap];
    read_position, write_position := 0, 0;
    isFlipped := false;
    }

  predicate Valid() 
    reads this
  {
    cells.Length > 0 && 
    read_position >= 0 && 
    read_position < cells.Length 
    && write_position >= 0 
    && write_position < cells.Length
  }

  predicate isFull()
    reads this
  {
    read_position == write_position && isFlipped
  }

  predicate isEmpty()
    reads this
  {
    read_position == write_position && !isFlipped
  }

   method Read() returns (isSuccess : bool, content : int)
    modifies this 
    requires Valid()
    ensures  Valid()
    ensures  isSuccess ==> old(cells) == cells 
                           && ((old(read_position) == read_position-1)  
                           || (old(read_position) == cells.Length-1 
                           && read_position == 0 && !isFlipped))
                           && old(write_position) == write_position
    ensures !isSuccess ==> (isEmpty() && old(cells) == cells)

  {
    if(isFlipped){
        content := cells[read_position];
        isSuccess := true; 
        if (read_position == cells.Length-1){ read_position := 0; isFlipped := false;}
        else {read_position := read_position+1;}
    }
    else{
      // if Empty
      if (read_position == write_position){
        content := 0;
        isSuccess := false;
      }
      // if read_position < write_position
      else {
        content := cells[read_position];
        read_position := read_position+1;
        isSuccess := true;
      }

    }
  }
}