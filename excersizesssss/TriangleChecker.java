class TriangleChecker{

  // All sides equal?
  static boolean isEquilateral(int a, int b, int c){
      return a == b && a == c;
  }
  // At least two sides equal?
  static boolean isIsosceles(int a, int b, int c){
      return a == b || a == c;
  }
  // No sides equal?
  static boolean isScalene(int a, int b, int c){
      return a != b && b !=c; 
  }

  public static void main(String[] args) {
      int a = Integer.parseInt(args[0]);
      int b = Integer.parseInt(args[1]);
      int c = Integer.parseInt(args[2]);

      if (isScalene(a,b,c))
	  System.out.println("Triangle is scalene (no sides equal).");
      else if (isIsosceles(a,b,c))
	  System.out.println("Triangle is isosceles (two sides equal).");
      else if (isEquilateral(a,b,c))
	  System.out.println("Triangle is equilateral (all sides equal).");
      else System.out.println("Not a valid triangle.");
  }
}
