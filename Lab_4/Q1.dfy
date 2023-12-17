
/* 
Answer Question 1a here:
--ERROR MESSEGE--
Error: a postcondition could not be proved on this return path
Could not prove: a > b
--ERROR MESSEGE--

Reason for this is if x == y then we set a = y and b = x. 
but now we cannot ensure a > b since we can reach a state 
in which we return a == b

*/
method M(x : int, y : int) returns (a : int, b : int)
  ensures a > b;
{
  if (x > y)
   {a:= x;
    b := y;}
  else
   {a := y; 
    b := x;}
}

// fixed with post condition
method M1(x : int, y : int) returns (a : int, b : int)
  ensures a >= b;
{
  if (x > y)
   {a:= x;
    b := y;}
  else
   {a := y; 
    b := x;}
}

// fixed with pre condition
method M2(x : int, y : int) returns (a : int, b : int)
  requires x != y;
  ensures a > b;
{
  if (x > y)
   {a:= x;
    b := y;}
  else
   {a := y; 
    b := x;}
}
// this fix is weird couldnt come up with anything better
method M3(x : int, y : int) returns (a : int, b : int)
  ensures a > b;
{
  if (x > y)
   {a:= x;
    b := y;}
  if (y > x)
  {a := y;
   b := x;}
  else
   {a := 69; // DUMMY NUMBERS to show that we failed
    b := -69;}
}