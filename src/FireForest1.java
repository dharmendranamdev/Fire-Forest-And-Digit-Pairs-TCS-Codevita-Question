import java.util.*;
public class FireForest1 {
    
    
    public static void printArray(char mat[][])
    {
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[i].length; j++)
            {
                  System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void countTime(char mat[][], int temp[][], int n ,int row, int col, int count)
    {
        //when we don't need to go to this function
        
        if((row >= n) || (row < 0 ) || ( col < 0 ) || (col >= n) || (mat[row][col] == 'W')){
            return;
        } 
        //check whether the cell is already visited or not ,if visited then cell contains greather than 0
        //it take care about 2 more more direction which has Tree (T) assign same time
        if(temp[row][col] != 0 && count >= temp[row][col])
            return;
        
        temp[row][col] = count;
        countTime(mat, temp, n, row + 1, col, count + 1);//north
        countTime(mat, temp, n, row - 1, col, count + 1);//south
        countTime(mat, temp, n, row, col + 1, count + 1);//east
        countTime(mat, temp, n, row, col - 1, count + 1);//west
        countTime(mat, temp, n, row + 1, col + 1, count + 1);//north - east
        countTime(mat, temp, n, row + 1, col - 1, count + 1);//north - west
        countTime(mat, temp, n, row - 1, col + 1, count + 1);//south east
        countTime(mat, temp, n, row - 1 , col -1, count + 1);//south west
        
        //temp[row][col] = count;
        
    } 
        
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter a size:");
        //int n = sc.nextInt();
        int n = 6;
        char W = 'W';
        char T = 'T';
        char mat[][] = {{W,T,T,T,T,T},
                        {T,W,W,W,W,W},
                        {W,T,T,T,T,T},
                        {W,W,W,W,W,T},
                        {T,T,T,T,T,T},
                        {T,W,W,W,W,W},
        };
        
        int temp[][] = new int[n][n];//by default conatain 0,it means mat[i][j] not visited yet
                                     //keep track of firing time of mat[i][j] which should be Tree(T)
                                     
       
        
        /*
        System.out.println("Enter Tree(T) and Water(W) in Matrix:");
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                mat[i][j] = sc.next().charAt(0);//Read character
            }
        }
        */
        
        
        
        System.out.println("First Tree Position which catches fire first:");
        //int r = sc.nextInt();
        //int c = sc.nextInt();
        int r = 1,c = 6;
        //print
        printArray(mat);
        
        countTime(mat, temp, n, r - 1 , c - 1 ,1);
        
        //System.out.println(temp[0].length);
        /*
        for(int i = 0; i < temp.length; i++)
        {
            for(int j = 0; j < temp[i].length; j++)
            {
                  System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        */
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < temp.length; i++)
        {
            for(int j = 0; j < temp[0].length; j++)
            {
                if(max < temp[i][j])
                  max = temp[i][j];
            }
        }
        System.out.println("Answer is : " +max);
        
    }
}
