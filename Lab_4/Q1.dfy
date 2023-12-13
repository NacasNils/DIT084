
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
/*
Answer Question 1b here:


 */