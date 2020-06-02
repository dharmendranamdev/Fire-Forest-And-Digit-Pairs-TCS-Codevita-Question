import java.util.*;
import java.lang.*;
import java.math.*;
public class DigitPairs {
    public static int largest(int n)
    {
        String str = n + " ";
        //convert first character into integer
        int large = Character.getNumericValue(str.charAt(0));
        for(int i = 1; i < 3; i++)
        {
            int num = Character.getNumericValue(str.charAt(i));
            if(large < num)
                large = num;
        }
        return large;
    }
     public static int smallest(int n)
    {
        String str = n + " ";
        //convert first character into integer
        int small = Character.getNumericValue(str.charAt(0));
        for(int i = 1; i < 3; i++)
        {
            int num = Character.getNumericValue(str.charAt(i));
            if(small > num)
                small = num;
        }
        return small;
    }
    public static void main(String args[])
    {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      for(int t = 1; t <= T; t++)
      {
           
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i = 0; i < n; i++)
      {
          a[i] = sc.nextInt();
      }
      for(int i = 0; i < n; i++)
      {
          int largestDigit = largest(a[i]);
          int smallestDigit = smallest(a[i]);
          int score = largest(a[i]) * 11 + smallest(a[i]) * 7;
          //System.out.println(i + " - >" + " l-->" + largestDigit + " s-->" + smallestDigit + "  " + score);
          a[i]  = score % 100;
      }
      //bitscore
      /*
      for(int i = 0; i < n; i++)
      {
        System.out.print(a[i] + " ");
      }
      */
      //ArrayList <Integer> odd = new ArrayList<Integer>();
      //ArrayList <Integer> even = new ArrayList<Integer>();
      int oddCount[] = new int[10];
      int evenCount[] = new int[10];
      for(int i = 0; i < n; i++)
      {
          if(i % 2 == 0)//odd
          {   
              int val = a[i] / 10;//most significant digit
              //odd.add(val);
              oddCount[val]++;
          }
          else
          {
              int val = a[i] / 10;//most significant digit
              //even.add(val);
              evenCount[val]++;
          }
      }
      /*
      System.out.println();
      for(int i = 0; i < 10; i++)
      {
        System.out.print(evenCount[i] + " ");
      }
      System.out.println();
      for(int i = 0; i < 10; i++)
      {
        System.out.print(oddCount[i] + " ");
      }
      */
      int myodd = 0;
      for(int i = 0; i < 10; i++)
      {
          if(oddCount[i] == 2)
          {
            myodd = 1;
          }
          if(oddCount[i] > 2)
          {
            myodd = 2;
            break;
          }
      }
      
      int myeven = 0;
      for(int i = 0; i < 10; i++)
      {
          if(evenCount[i] == 2)
          {
            myeven = 1;
          }
          if(evenCount[i] > 2)
          {
            myeven = 2;
            break;
          }
      }
    
      int p = myodd + myeven;
      System.out.println(p);
      }
    }
    
}