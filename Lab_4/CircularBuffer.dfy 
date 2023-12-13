// class CircularMemory
// This class implements a cicular buffer with with 2 int typed pointers
class CircularMemory
{
  var cells : array<int>;
  var read_position : int;
  var write_position : int;
  var isFlipped : bool;
  var cap : int;

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
    cap == cells.Length && write_position >= 0
    && write_position < cap
    && read_position >= 0 && read_position < cap
    && ((!isFlipped <==> read_position<= write_position)
    || (isFlipped <==> read_position >= write_position))
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
    ensures Valid()
    ensures  isSuccess ==> old(cells) == cells && 
    ((old(read_position) == read_position-1) || (old(read_position) == cells.Length-1 && read_position == 0 && !isFlipped)) 
    && old(write_position) == write_position
    ensures !isSuccess ==> (isEmpty() && old(cells) == cells)

  {
    if (isFlipped){
      //read = write
      if(read_position == write_position){

        //if we are on last index
        if (read_position < cells.Length-1){
          content := cells[read_position];
          read_position := read_position+1;
          isSuccess := true;
        }

        //if we are on last index
        else {
          content := cells[read_position];
          read_position := 0;
          isSuccess := true;
          isFlipped := false;
        }
      }
      // read > write
      else{

        //read == cells.Length-1
        if  (read_position == cells.Length-1){
          content := cells[read_position];
          read_position := 0;
          isSuccess := true;
          isFlipped := false;
        }

        //read < cells.Length-1
        else {
          content := cells[read_position];
          read_position := read_position+1;
          isSuccess := true;
        }
      }
    }
    //if not flipped
    else{
      //if read = write
      if (read_position == write_position){
        content := 0;
        isSuccess := false;
      }
      //if read < write
      else {
        content := cells[read_position];
        isSuccess := true;
        read_position := read_position + 1;
      }
    }
    }
    method Write(input : int) returns (isSuccess : bool)
      modifies this, this.cells
      requires Valid()
      ensures  Valid()
      ensures  isSuccess ==> ((old(write_position) == write_position-1 || ((old(write_position) == cells.Length-1) && (write_position == 0) && (isFlipped)))
      && (old(read_position) == read_position))
      ensures !isSuccess ==> (old(cells) == cells && isFull())
  {
    if (isFlipped) {

      // write = read AKA full
      if (read_position == write_position) {
        isSuccess := false;
      }

      // write < read
      else {
        cells[write_position] := input;
        isSuccess := true;
        write_position := write_position + 1;
      }
    }
    // if not flipped
    else {
      
      // if write = read
      if (write_position == read_position){
          cells[write_position] := input;
          isSuccess := true;

  
        // if write = cells.Length-1
        if (write_position == cells.Length-1){
          isFlipped := true;
          write_position := 0;
        }

        // if write < cells.Length-1
        else{
          write_position := write_position+1;
        }
      }

      // if write > read
      else{
        cells[write_position] := input;
        isSuccess := true;
        
        // if write == cells.Length-1
        if(write_position == cells.Length-1){
          isFlipped := true;
          write_position := 0;
        }

        // if write < cells.Length-1
        else{
          write_position := write_position + 1;
        }
      }

    }
    
  }


  }
 