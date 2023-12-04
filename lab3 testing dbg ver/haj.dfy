// class CircularMemory
// This class implements a cicular buffer with with 2 int typed pointers
class CircularMemory
{
  var cells : array<int>;
  var read_position : int;
  var write_position : int;
  var isFlipped : bool;
  var counter : int;

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

  method isEmpty() returns (empty : bool)
    requires valid()
  {
    if(counter > 0){
        empty := false;
    }
    if(read_position > write_position){
        empty := true;
    } 
    else{
        empty := false;
    }
  }
  

  method Read() returns (isSuccess : bool, content : int)
    modifies this
    requires Valid()
    ensures  Valid()
    ensures  isSuccess 
    ensures !isSuccess ==> valid()

  {
    if(isFlipped)
    {
      read_position := 0;
      isFlipped := false;
    }
    else // not flipped
    {
      if (isEmpty()) {
        isSuccess := false;
        content := 0;
      }

      isSuccess := true;
      read_position := read_position + 1;
      content := cells[read_position];

    }
  }

  method Write(input : int) returns (isSuccess : bool)
    modifies this
    requires Valid()
    ensures  Valid()
    ensures  isSuccess ==> ...
    ensures !isSuccess ==> ...
  {
    if(isFlipped)
    {
      ...
    }
    else // not flipped
    {
      ...
    }
  }


}
