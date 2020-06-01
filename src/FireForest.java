import java.util.*;
public class FireForest {
    
    
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
    public static int countTime(char mat[][], int temp[][], int n ,int row, int col, int count)
    {
        
        
        
        count++;
        temp[row][col] = count;
        int flag = 1;
        int north = row - 1;
        int south = row + 1;
        int east = col + 1;
        int west = col - 1;
        
        if(north >= 0 && north < n && mat[north][col] == 'T' && temp[north][col] == 0)//north
        {
               //temp[north][col] = count;
               count = countTime(mat,temp,n,north,col,count);
               
        }
        if(south >= 0 && south < n && mat[south][col] == 'T' && temp[south][col] == 0)//south
        {
             //temp[south][col] = count;
             count = countTime(mat,temp,n,south,col,count);
        }
        if(east >= 0 && east < n && mat[row][east] == 'T' && temp[row][east] == 0)//east
        {
            //temp[row][east] = count;
            count = countTime(mat,temp,n,row,east,count);
        }
        if(west >= 0 && west < n && mat[row][west] == 'T' && temp[row][west] == 0)//west
        {
            //temp[row][west] = count;
            count = countTime(mat,temp,n,row,west,count); 
        }
        
        //north east
        
        if(north >= 0 && north < n && east >= 0 && east < n && mat[north][east] == 'T' && temp[north][east] == 0)//north
        {
            //temp[north][east] = count;
            countTime(mat,temp,n,north,east,count);
        }
        //north west
        if(north >= 0 && north < n && west >= 0 && west < n && mat[north][west] == 'T' && temp[north][west] == 0)//north
        {
            //temp[north][west] = count;
            countTime(mat,temp,n,north,west,count);
        }
        //south east
        if(south >= 0 && south < n && east >= 0 && east < n && mat[south][east] == 'T' && temp[south][east] == 0)//north
        {
            //temp[south][east] = count;
             countTime(mat,temp,n,south,east,count);
        }
        //south west
        if(south >= 0 && south < n && west >= 0 && west < n && mat[north][west] == 'T' && temp[south][west] == 0)//north
        {
            //temp[south][west] = count;
             countTime(mat,temp,n,south,west,count);
        }
        return count;        
    }
        
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size:");
        int n = sc.nextInt();
        
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
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        //print
        printArray(mat);
        
        System.out.println(countTime(mat, temp, n, r - 1 , c - 1 ,0));
        
        //System.out.println(temp[0].length);
        for(int i = 0; i < temp.length; i++)
        {
            for(int j = 0; j < temp[i].length; j++)
            {
                  System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        
    }
}
