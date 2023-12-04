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
    read_position <= cells.Length 
    && write_position >= 0 
    && write_position <= cells.Length
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
    ensures  isSuccess ==> true
    ensures !isSuccess ==> false

  {
    if(isFlipped)
    {
       if(read_position > cells.Length){
        content := cells[read_position];
        isSuccess := true;
        isFlipped := false;
      } 
      else{
        content := cells[read_position];
        isSuccess := true;
        read_position := read_position + 1;
      }
      
    }
    
    else // not flipped
      {
      if (read_position == write_position && !isFlipped) {
        isSuccess := false;
        content := 0;
      }
      isSuccess := true;
      content := cells[read_position];
      read_position := read_position + 1;
    
    }
  }


  method Write(input : int) returns (isSuccess : bool)
    modifies this
    requires Valid()
    ensures  Valid()
    ensures  isSuccess ==> true
    ensures !isSuccess ==> false
  {

    if(write_position > cells.Length){
    isFlipped := true;
    write_position := 0;
    }

    if(isFlipped)
    {
      if(read_position == write_position && isFlipped){
        isSuccess := false;
        return;
      }
          else
    {
      cells[write_position] := input;
      isSuccess := true;
    }
  }
      else // not flipped
    {
      cells[write_position] := input;
      isSuccess := true;
    }
}

}
