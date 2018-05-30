package TwoZeroFourEight;

import java.util.ArrayList;

public class TheArray {
      int [][]array ;
      public TheArray()
      {
    	  array =  new int [4][4];
    	  for(int i = 0;i!=4;++i)
    		  for(int j = 0;j!=4;++j)
    			    array[i][j] = 0;
      }
      int RightMove()
      {
    	  int score = -1;
    	 // boolean isMove = false;
          for(int i = 0;i!=4;++i)
          {
        	  int num = 4;
          for(int j = 3;j>=0;--j)
        	     if(array[i][j]!=0)
        	     {
        	    	  array[i][--num] = array[i][j];
        	    	 
        	    	  if(num!=j)
        	    	  {
        	    		  if(score==-1)
        	    		  score = 0;
        	    		  array[i][j] = 0;
        	    	  }
        	     }
          for(int j = 3;j> num;--j)
        	     if(array[i][j] == array[i][j-1])
        	     {
        	    	     array[i][j]+=array[i][j-1];
        	    	     array[i][j-1] = 0;
        	    	    
        	    	     //++num;
        	    	     score+=array[i][j];
        	    	     --j;
        	    	   //  isMove = true;
        	     }
               num = 4;
          for(int j = 3;j>=0;--j)
     	     if(array[i][j]!=0)
     	     {
     	    	  array[i][--num] = array[i][j];
     	    	  if(j!=num)
     	    	  array[i][j] = 0;
     	    //	  if(num!=j)
     	    	//	  isMove = true;
     	     }       
          }
          return score;
      }
      int LeftMove()
      {
    	  int score = -1;
          for(int i = 0;i!=4;++i)
          {
        	  int num = -1;
          for(int j = 0;j<=3;++j)
        	     if(array[i][j]!=0)
        	     {
        	    	  array[i][++num] = array[i][j];
        	    	  
        	    	  if(num!=j)
        	    	  {
        	    		  array[i][j] = 0;
        	    		  if(score == -1)
        	    			   score = 0;
        	    		//  isMove = true;
        	    	  }
        	     }
          for(int j = 0;j<num;++j)
        	     if(array[i][j] == array[i][j+1])
        	     {
        	    	     array[i][j]+=array[i][j+1];
        	    	     array[i][j+1] = 0;
        	    	    
        	    	     //++num;
        	    	     score += array[i][j];
        	    	     ++j;
        	    	//     isMove = true;
        	     }
               num = -1;
          for(int j = 0;j!=4;++j)
     	     if(array[i][j]!=0)
     	     {
     	    	  array[i][++num] = array[i][j];
     	    	  if(num!=j)
     	    	  array[i][j] = 0;
     	    //	  if(num!=j)
     	    	//	  isMove = true;
     	     }       
          }
          return score;
      }

      int UpMove()
      {
    	//  boolean isMove = false;
    	  int score = -1;
          for(int j = 0;j!=4;++j)
          {
        	  int num = -1;
          for(int i = 0;i!=4;++i)
        	     if(array[i][j]!=0)
        	     {
        	    	  array[++num][j] = array[i][j];
        	    	  
        	    	  if(num!=i)
        	    	  {
        	    		  if(score == -1)
        	    		  score = 0;
        	    		  array[i][j] = 0;
        	    	  }
        	     }
          for(int i = 0;i<num;++i)
        	     if(array[i][j] == array[i+1][j])
        	     {
        	    	     array[i][j]+=array[i+1][j];
        	    	     array[i+1][j] = 0;
        	    	     
        	    	     //++num;
        	    	     score+=array[i][j];
        	    	    // System.out.println(array[i][j]);
        	    	     ++i;
        	    	   //  isMove = true;
        	     }
               num = -1;
          for(int i = 0;i<4;++i)
     	     if(array[i][j]!=0)
     	     {
     	    	  array[++num][j] = array[i][j];
     	    	  if(num!=i)
     	    	  array[i][j] = 0;
     	    //	  if(num!=j)
     	    	//	  isMove = true;
     	     }       
          }
          return score; 
      }
      int DownMove()
      {
    	  int score = -1;
          for(int j = 0;j!=4;++j)
          {
        	  int num = 4;
          for(int i = 3;i>=0;--i)
        	     if(array[i][j]!=0)
        	     {
        	    	  array[--num][j] = array[i][j];
        	    	  
        	    	  if(num!=i)
        	    	  {
        	    		  if(score == -1)
        	    			  score = 0;
        	    		 // isMove = true;
        	    		  array[i][j] = 0;
        	    	  }
        	     }
          for(int i = 3;i> num;--i)
        	     if(array[i][j] == array[i-1][j])
        	     {
        	    	     array[i][j]+=array[i-1][j];
        	    	     array[i-1][j] = 0;
        	    	    
        	    	     score+=array[i][j];
        	    	     //++num;
        	    	     //isMove = true; 
        	    	     --i;
        	     }
               num = 4;
          for(int i = 3;i>=0;--i)
     	     if(array[i][j]!=0)
     	     {
     	    	  array[--num][j] = array[i][j];
     	    	  if(num!=i)
     	    	  array[i][j] = 0;
     	    //	  if(num!=j)
     	    	//	  isMove = true;
     	     }       
          }
          return score;  	  
      }
      int random2or4()
      {
    	  ArrayList<Integer> weNeed = new ArrayList<Integer>();
    	  boolean isTwo = (int)(Math.random()*10) != 0,over =false;
    	  int rand = -1;
    	  for(int i = 0;i!=4;++i)
    		  for(int j = 0;j!=4;++j)
    			    if(array[i][j] == 0)
    			    	weNeed.add(i*4+j);  
    	      if(weNeed.size() == 0)
    	    	   over = true;
    	      if(!over) 
    	    	  {
    	    	  rand = (int)(Math.random()*weNeed.size());
    	    	  
    	    	  if(isTwo)
    	      array[weNeed.get(rand).intValue()/4][weNeed.get(rand).intValue()%4] = 2 ;
    	    	  else array[weNeed.get(rand).intValue()/4][weNeed.get(rand).intValue()%4] = 4;
    	    	  }
    	      if(rand!=-1)
    	      return weNeed.get(rand).intValue();
    	      else return -1;
      }
    void show()
    {
    	for(int i = 0;i!=4;++i)
    	{
    		 for(int j = 0;j!=4;++j)
    	System.out.printf(array[i][j]+" ");
    		 System.out.println();
    	}
    }
    void clean()
    {
    	for(int i = 0;i!=4;++i)
    		for(int j = 0;j!=4;++j)
    			 array[i][j] = 0;
    }
    boolean can_not_Move()
    {
    	int [][]copy = new int [4][4];
    	for(int i = 0;i!=4;++i)
    		for(int j = 0;j!=4;++j)
    			 copy [i][j]= array[i][j];
    	if(LeftMove() != -1)
    	{
    		array = copy;
    		return false;
    	}
    	else if(RightMove ()!=-1)
    	{
    		array = copy;
    		return false;   		
    	}
    	else if(UpMove()!=-1)
    	{
    		array = copy;
    		return false;
    	}
    	else if(DownMove()!=-1)
    	{
    		array = copy;
    		return false;
    	}
    	return true;
    		
    }
}
