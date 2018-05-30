package backgammon;

public class checkerBoard {//ÆåÅÌÀà
     int [][] cB;
     int next = -1;
     int score = 0;
     //int annext = -1;
    // int SC = 0;
     checkerBoard()
     {
    	 cB = new int [15][];
    	 for(int i = 0;i!=15;++i)
    		   cB[i] = new int [15];
    	for(int i = 0;i!=15;++i)
    		for(int j = 0;j!=15;++j)
    			  cB[i][j] = 0;
     }
     public void bturn(int i,int j)
     {
    	 cB[i][j] = 2;
     }
     public void wturn(int i,int j)
     {
    	 cB[i][j] = 1;
     }
     int getScore3(int x,int y)
     {
          	   int ver = 1;//Êú
          	   int vva = 0,vvs = 0;
          	   int hor = 1,hha = 0,hhs = 0;//ºá
          	   int left = 1,lla = 0,lls = 0;//×óÐ±
          	   int right = 1,rra = 0,rrs = 0;//ÓÒÐ±
          	   int i,j;
          	   int []kind = new int [6];
          	   
          	   for(i = x+1;i!=15;++i)
          		    if(cB[i][y] == 2)
          		    	  ++ver;
          		    else break;
          	   for(;i!=15&&cB[i][y] == 0;++i)
          		       ++vva;
          	   for( j = x-1;j>=0;--j)
          		   if(cB[j][y] == 2)
          			     ++ver;
          		   else break;
          	    for(;j>=0&&cB[j][y] == 0;--j)
          	    	    --vvs;
          	 //  if(ver == 5) return true;
          	   if(ver >= 5) return 100;
          	   else if(ver!=1&&vva-vvs+ver >=5)
          	   {
          		   i -= vva;
          		   j -= vvs;
          		   int belong = (4-ver)*2;
          		   boolean dead = false;
          		   if(i!=15&&cB[i][y] == 0)
          			    ;
          		   else dead = true;
          		   if(j>=0&&cB[j][y] == 0)
          		   {
          			   if(!dead) kind[belong]++;
          			   else kind[belong+1]++;
          		   }
          		   else
          		   {
          			   if(!dead) kind[belong+1]++;
          			  // else kind[6]++;
          		   }
          				   }
          	        
          	  
          	   for(i = y+1;i!=15;++i)
          		     if(cB[x][i] == 2)
          		    	  ++hor;
          		     else break;
          	   for(;i!=15&&cB[x][i] == 0;++i)
      		       ++hha;
          	   for(j = y-1;j>=0;--j)
          		     if(cB[x][j] == 2)
          		    	   ++hor;
          		     else break;
          	   for(;j>=0&&cB[x][j] == 0;--j)
      		       --hhs;
          	   if(hor >= 5) return 100;
          	   else if(hor!=1&&hha - hhs + hor>=5)
          	   {
          		   i -= hha;
          		   j -= hhs;
          		   int belong = (4-hor)*2;
          		   boolean dead = false;
          		   if(i!=15&&cB[x][i] == 0)
          			    ;
          		   else dead = true;
          		   if(j>=0&&cB[x][j] == 0)
          		   {
          			   if(!dead) kind[belong]++;
          			   else kind[belong+1]++;
          		   }
          		   else
          		   {
          			   if(!dead) kind[belong+1]++;
          			  // else kind[6]++;
          		   }
          				   }
         // 	   if(hor == 5) return true;
          	   int b = 1 , e = -1;
          	  for(i = x+1,j = y+1;i!=15&&j!=15;++i,++j)
          	            if(cB[i][j] == 2)
          	            	{++right;++b;}
          	            else break;
          	  for(;i!=15&&j!=15&&cB[i][j] == 0;++i,++j)
          		       ++rra;
          	  for( i = x-1,j = y-1;i>=0&&j>=0;--i,--j)
          		     if(cB[i][j] == 2)
          		  {++right;--e;}
          		     else break;
          	  for(;i>=0&&j>=0&&cB[i][j] == 0;--i,--j)
     		       --rrs;
          	          //     if(right == 5)
          	            //	   return true;
         	   if(right >= 5) return 100;
         	   else if(right!=1&&right + rra - rrs >= 5)
         	   {
         		   int belong = (4-right)*2;
         		   boolean dead = false;
         		   if(x+b!=15&&y+b!=15&&cB[x+b][y+b] == 0)
         			    ;
         		   else dead = true;
         		   if(x+e>=0&&y+e>=0&&cB[x+e][y+e] == 0)
         		   {
         			   if(!dead) kind[belong]++;
         			   else kind[belong+1]++;
         		   }
         		   else
         		   {
         			   if(!dead) kind[belong+1]++;
         			  // else kind[6]++;
         		   }
         				   }
         	   b = 1;
         	   e = -1;
          	         	  for(i = x+1,j = y-1;i!=15&&j>=0;++i,--j)
          	    	            if(cB[i][j] == 2)
          	    	             	{++left;++b;}
          	    	            else break;
          	         	  for(;i!=15&&j>=0&&cB[i][j] == 0;++i,--j)
          	         		     ++lla;
          	    	  for(i = x-1,j = y+1;i>=0&&j!=15;--i,++j)
          	    		     if(cB[i][j] == 2)
          	    		    	    {++left;--e;}
          	    		     else break;
          	    	  for(;i>=0&&j!=15&&cB[i][j] == 0;--i,++j)
          	    		       --lls;
          	   	   if(left >= 5) return 100;
          	   	   else if(left !=1&&lla - lls + left>=5)
          	   	   {
          	   		   int belong = (4-left )*2;
          	   		   boolean dead = false;
          	   		   if(x + b!=15&& y - b >= 0&&cB[x+b][y-b] == 0)
          	   			    ;
          	   		   else dead = true;
          	   		   if(x+e>=0&&y - e!=15 &&cB[x+e][y-e] == 0)
          	   		   {
          	   			   if(!dead) kind[belong]++;
          	   			   else kind[belong+1]++;
          	   		   }
          	   		   else
          	   		   {
          	   			   if(!dead) kind[belong+1]++;
          	   			  // else kind[6]++;
          	   		   }
          	   				   }
          	    	            //   if(left == 5)
          	    	            //	   return true;
          	    	      //  return false;
          	   	   //if()
          	   	 
          	     if(kind[0]>=1||kind[1]>=2||kind[1]>0&&kind[2]>0)//»î4£¬Ë«ËÀ4£¬ËÀ4ºÍ»î3
          	    	 return 90;
          	     else if(kind[2]>=2)//2hs
          	    	 return 80;
          	     else if(kind[2]>0&&kind[3]>0)
          	    	 return 70;
          	     else if(kind[1] >= 1)
          	    	 return 60;
          	     else if(kind[2] >= 1)
          	    	 return 50;
          	     else if(kind[4] >= 2)
          	    	 return 40;
          	     else if(kind[3] >= 1)
          	    	   return 30;
          	     else if(kind[4] >= 1)
          	    	 return 20;
          	     else if(kind[5]>=1)
          	    	 return 10;
          	     else return 0;
       	  } 
/*
      	   int ver = 1;//Êú
      	   int hor = 1;//ºá
      	   int left = 1;//×óÐ±
      	   int right = 1;//ÓÒÐ±
      	   int i,j;
      	  // int []kind = new int [6];
      	   boolean find = false;
      	   for(i = x+1;i!=15;++i)
      		    if(cB[i][y] == 2)
      		    	  ++ver;
      		    else break;
      	   for( j = x-1;j>=0;--j)
      		   if(cB[j][y] == 2)
      			     ++ver;
      		   else break;
      	 //  if(ver == 5) return true;
      	   if(ver >= 5) {return 100;}
      	   else if(ver==4&&i<15&&j>=0&&cB[i][x] == 0&& cB[j][x] == 0 )
      	   {
                 find = true;
      				   }
      	        
      	  
      	   for(i = y+1;i!=15;++i)
      		     if(cB[x][i] == 2)
      		    	  ++hor;
      		     else break;
      	   for(j = y-1;j>=0;--j)
      		     if(cB[x][j] == 2)
      		    	   ++hor;
      		     else break;
      	   if(hor >= 5) return 100;
      	  // if(ver == 5) {return 100;}
      	   else if(hor == 4&&i<15&&j>=0&&cB[x][i] == 0&& cB[x][j] == 0 )
      	   {
                 find = true;
      				   }
      				   
     // 	   if(hor == 5) return true;
      	   int b = 0 , e = -1;
      	  for(i = x+1,j = y+1;i!=15&&j!=15;++i,++j)
      	            if(cB[i][j] == 2)
      	            	{++right;++b;}
      	            else break;
      	  for( i = x-1,j = y-1;i>=0&&j>=0;--i,--j)
      		     if(cB[i][j] == 2)
      		  {++right;--e;}
      		     else break;
      	          //     if(right == 5)
      	            //	   return true;
     	   if(right >= 5) return 100;
     	   else if(right==4&&x+b<15&&y+b<15&&y+e>=0&&x+e>=0&&cB[x+b][y+b] == 0&&cB[x+e][y+e]==0)
     	   {
     		   find = true;
     				   }
     	   b = 0;
     	   e = -1;
      	         	  for(i = x+1,j = y-1;i!=15&&j>=0;++i,--j)
      	    	            if(cB[i][j] == 2)
      	    	             	{++left;++b;}
      	    	            else break;
      	    	  for(i = x-1,j = y+1;i>=0&&j!=15;--i,++j)
      	    		     if(cB[i][j] == 2)
      	    		    	    {++left;--e;}
      	    		     else break;
      	   	   if(left >= 5) return 100;
      	     else if(left==4&&x+b<15&&y-b>=0&&y-e<15&&x+e>=0&&cB[x+b][y-b] == 0&&cB[x+e][y-e]==0)
      	   	   {
                find = true;
      	   				   }
      	    	            //   if(left == 5)
      	    	            //	   return true;
      	    	      //  return false;
              if(find) return 95;
              return 0;*/
   	  
     int getScore1(int x,int y)
     {

      	   int ver = 1;//Êú
      	   int vva = 0,vvs = 0;
      	   int hor = 1,hha = 0,hhs = 0;//ºá
      	   int left = 1,lla = 0,lls = 0;//×óÐ±
      	   int right = 1,rra = 0,rrs = 0;//ÓÒÐ±
      	   int i,j;
      	   int []kind = new int [6];
      	   
      	   for(i = x+1;i!=15;++i)
      		    if(cB[i][y] == 1)
      		    	  ++ver;
      		    else break;
      	   for(;i!=15&&cB[i][y] == 0;++i)
      		       ++vva;
      	   for( j = x-1;j>=0;--j)
      		   if(cB[j][y] == 1)
      			     ++ver;
      		   else break;
      	    for(;j>=0&&cB[j][y] == 0;--j)
      	    	    --vvs;
      	 //  if(ver == 5) return true;
      	   if(ver >= 5) return 100;
      	   else if(ver!=1&&vva-vvs+ver >=5)
      	   {
      		   i -= vva;
      		   j -= vvs;
      		   int belong = (4-ver)*2;
      		   boolean dead = false;
      		   if(i!=15&&cB[i][y] == 0)
      			    ;
      		   else dead = true;
      		   if(j>=0&&cB[j][y] == 0)
      		   {
      			   if(!dead) kind[belong]++;
      			   else kind[belong+1]++;
      		   }
      		   else
      		   {
      			   if(!dead) kind[belong+1]++;
      			  // else kind[6]++;
      		   }
      				   }
      	        
      	  
      	   for(i = y+1;i!=15;++i)
      		     if(cB[x][i] == 1)
      		    	  ++hor;
      		     else break;
      	   for(;i!=15&&cB[x][i] == 0;++i)
  		       ++hha;
      	   for(j = y-1;j>=0;--j)
      		     if(cB[x][j] == 1)
      		    	   ++hor;
      		     else break;
      	   for(;j>=0&&cB[x][j] == 0;--j)
  		       --hhs;
      	   if(hor >= 5) return 100;
      	   else if(hor!=1&&hha - hhs + hor>=5)
      	   {
      		   i -= hha;
      		   j -= hhs;
      		   int belong = (4-hor)*2;
      		   boolean dead = false;
      		   if(i!=15&&cB[x][i] == 0)
      			    ;
      		   else dead = true;
      		   if(j>=0&&cB[x][j] == 0)
      		   {
      			   if(!dead) kind[belong]++;
      			   else kind[belong+1]++;
      		   }
      		   else
      		   {
      			   if(!dead) kind[belong+1]++;
      			  // else kind[6]++;
      		   }
      				   }
     // 	   if(hor == 5) return true;
      	   int b = 1 , e = -1;
      	  for(i = x+1,j = y+1;i!=15&&j!=15;++i,++j)
      	            if(cB[i][j] == 1)
      	            	{++right;++b;}
      	            else break;
      	  for(;i!=15&&j!=15&&cB[i][j] == 0;++i,++j)
      		       ++rra;
      	  for( i = x-1,j = y-1;i>=0&&j>=0;--i,--j)
      		     if(cB[i][j] == 1)
      		  {++right;--e;}
      		     else break;
      	  for(;i>=0&&j>=0&&cB[i][j] == 0;--i,--j)
 		       --rrs;
      	          //     if(right == 5)
      	            //	   return true;
     	   if(right >= 5) return 100;
     	   else if(right!=1&&right + rra - rrs >= 5)
     	   {
     		   int belong = (4-right)*2;
     		   boolean dead = false;
     		   if(x+b!=15&&y+b!=15&&cB[x+b][y+b] == 0)
     			    ;
     		   else dead = true;
     		   if(x+e>=0&&y+e>=0&&cB[x+e][y+e] == 0)
     		   {
     			   if(!dead) kind[belong]++;
     			   else kind[belong+1]++;
     		   }
     		   else
     		   {
     			   if(!dead) kind[belong+1]++;
     			  // else kind[6]++;
     		   }
     				   }
     	   b = 1;
     	   e = -1;
      	         	  for(i = x+1,j = y-1;i!=15&&j>=0;++i,--j)
      	    	            if(cB[i][j] == 1)
      	    	             	{++left;++b;}
      	    	            else break;
      	         	  for(;i!=15&&j>=0&&cB[i][j] == 0;++i,--j)
      	         		     ++lla;
      	    	  for(i = x-1,j = y+1;i>=0&&j!=15;--i,++j)
      	    		     if(cB[i][j] == 1)
      	    		    	    {++left;--e;}
      	    		     else break;
      	    	  for(;i>=0&&j!=15&&cB[i][j] == 0;--i,++j)
      	    		       --lls;
      	   	   if(left >= 5) return 100;
      	   	   else if(left !=1&&lla - lls + left>=5)
      	   	   {
      	   		   int belong = (4-left )*2;
      	   		   boolean dead = false;
      	   		   if(x + b!=15&& y - b >= 0&&cB[x+b][y-b] == 0)
      	   			    ;
      	   		   else dead = true;
      	   		   if(x+e>=0&&y - e!=15 &&cB[x+e][y-e] == 0)
      	   		   {
      	   			   if(!dead) kind[belong]++;
      	   			   else kind[belong+1]++;
      	   		   }
      	   		   else
      	   		   {
      	   			   if(!dead) kind[belong+1]++;
      	   			  // else kind[6]++;
      	   		   }
      	   				   }
      	    	            //   if(left == 5)
      	    	            //	   return true;
      	    	      //  return false;
      	   	   //if()
      	   	 
      	     if(kind[0]>=1||kind[1]>=2||kind[1]>0&&kind[2]>0)//»î4£¬Ë«ËÀ4£¬ËÀ4ºÍ»î3
      	    	 return 90;
      	     else if(kind[2]>=2)
      	    	 return 80;
      	     else if(kind[2]>0&&kind[3]>0)
      	    	 return 70;
      	     else if(kind[1] >= 1)
      	    	 return 60;
      	     else if(kind[2] >= 1)
      	    	 return 50;
      	     else if(kind[4] >= 2)
      	    	 return 40;
      	     else if(kind[3] >= 1)
      	    	   return 30;
      	     else if(kind[4] >= 1)
      	    	 return 20;
      	     else if(kind[5]>=1)
      	    	 return 10;
      	     else return 0;
   	  } 	
     void clean()
     {
    	 for(int i = 0;i!=15;++i)
    		 for(int j = 0;j!=15;++j)
    			 cB[i][j] = 0;
     }
      boolean isWin(int x,int y)
      {
    	  int ver = 0,hor = 0,left = 0,right = 0;
    	  for(int i = x;i!=15;++i)
    		     if(cB[i][y] == 2)
    		    	   ++ver;
    		     else break;
    	  for(int j = x-1;j>=0;--j)
    		     if(cB[j][y] == 2 )
    		    	    ++ver;
    		     else break;
    	     if(ver>=5)
    	  return true;
       	  for(int i = y;i!=15;++i)
 		     if(cB[x][i] == 2)
 		    	   ++hor;
 		     else break;
 	  for(int j = y-1;j>=0;--j)
 		     if(cB[x][j] == 2 )
 		    	    ++hor;
 		     else break;
 	        if(hor>=5)
 	      return true;
 	    	  for(int i = x,j = y;i!=15&&j!=15;++i,++j)
     		     if(cB[i][j] == 2)
     		    	   ++right;
     		     else break;
     	  for(int i = x-1,j = y - 1;j>=0&&i>=0;--i,--j)
     		     if(cB[i][j] == 2 )
     		    	    ++right;
     		     else break;
     	     if(right>=5)
     	  return true;
     	    for(int i = x,j = y;i!=15&&j>=0;++i,--j)
    		     if(cB[i][j] == 2)
    		    	   ++left;
    		     else break;
    	  for(int i = x-1,j = y + 1;i>=0&&j!=15;--i,++j)
    		     if(cB[i][j] == 2 )
    		    	    ++left;
    		     else break;
    	     if(left>=5)
    	  return true;  	
    	     return false;
      }
	  /*int getScore2(int x,int y)
	  {
		  int next = 0;
   	   int ver = 0,vva = 0,vvs = 0;//Êú
   	   int hor = 0,hha = 0,hhs = 0;//ºá
   	   int left = 0,lla = 0,lls = 0;//×óÐ±
   	   int right = 0,rra = 0,rrs = 0;//ÓÒÐ±
   	//   int max = 0;
   	   int i,j;
   	   int []kind = new int [6];
   	   
   	   for(i = x;i!=15;++i)
   		    if(cB[i][y] == 2)
   		    	  ++ver;
   		    else break;
   	   for(;i!=15&&cB[i][y] == 0;++i)
   		      ++vva;
   	   for( j = x-1;j>=0;--j)
   		   if(cB[j][y] == 2)
   			     ++ver;
   		   else break;
   	   for(;j>=0&&cB[j][y]== 0;--j)
   		        --vvs;
   	 //  if(ver == 5) return true;
   	   if(ver >= 5) return 100;
   	   else if(ver!=1&&vva-vvs+ver>=5)
   	   {
   		   i-=vva;
   		   j-=vvs;
   		   int belong = (4-ver)*2;
   		   boolean dead = false,already = false;
   		   if(i!=15&&cB[i][y] == 0)
   			    ;
   		   else dead = true;
   		   if(j>=0&&cB[j][y] == 0)
   		   {
   			   if(!dead) kind[belong]++;
   			   else kind[++belong]++;
   		   }
   		   else
   		   {
   			   if(!dead) kind[++belong]++;
   			   else belong = 6;
   		   }
   		 if(belong == 0)
  		      next = i*15+y;
  		   else if(belong != 6)
  		   {
  		   for(int m = 0;m<belong;++m)
  			      if(kind[m]!=0)
  			      {
  			    	  already = true;
  			    	  break;
  			      }
  		   if(!already)
  		   {
  			   if(belong%2 == 0)
  				    next = i*15+y;
  			   else if(i<15&&cB[i][y] == 0)
  				      next = i*15+y;
  			   else next = j*15+y;
  			//   System.out.println(next);
  			      }
  		   }
   				   }
   	        
   	  
   	   for(i = y;i!=15;++i)
   		     if(cB[x][i] == 2)
   		    	  ++hor;
   		     else break;
   	   for(;i!=15&&cB[x][i] == 0;++i)
   		       ++hha;
   	   for(j = y-1;j>=0;--j)
   		     if(cB[x][j] == 2)
   		    	   ++hor;
   		     else break;
   	   for(;j>=0&&cB[x][j] == 0;--j)
   		     --hhs;
   	   if(hor >=5) return 100;
   	   else if(hor!=1&&hha - hhs + hor >=5)
   	   {
   		   i -= hha;
   		   j -= hhs;
   		   int belong = (4-hor)*2;
   		   boolean dead = false,already = false;
   		   if(i!=15&&cB[x][i] == 0)
   			    ;
   		   else dead = true;
   		   if(j>=0&&cB[x][j] == 0)
   		   {
   			   if(!dead) kind[belong]++;
   			   else kind[++belong]++;
   		   }
   		   else
   		   {
   			   if(!dead) kind[++belong]++;
   			   else belong = 6;
   		   }
   		   if(belong == 0)
   		      next = x*15+i;
   		   else if(belong != 6)
   		   {
   		   for(int m = 0;m<belong;++m)
   			      if(kind[m]!=0)
   			      {
   			    	  already = true;
   			    	  break;
   			      }
   		   if(!already)
   		   {
   			   if(belong%2 == 0)
   				    next = x*15+i;
   			   else if(i<15&&cB[x][i] == 0)
   				      next = x*15+i;
   			   else next = x*15+j;
   			      }
   		   }     
   				   }
  // 	   if(hor == 5) return true;
   	   int b = 0 , e = -1;
   	  for(i = x,j = y;i!=15&&j!=15;++i,++j)
   	            if(cB[i][j] == 2)
   	            	{++right;++b;}
   	            else break;
   	  for(;i!=15&&j!=15&&cB[i][j] == 0;++i,++j)
   		    ++rra;
   	  for( i = x-1,j = y-1;i>=0&&j>=0;--i,--j)
   		     if(cB[i][j] == 2)
   		  {++right;--e;}
   		     else break;
   	  for(;i>=0&&j>=0&&cB[i][j] == 0;--i,--j)
   		      --rrs;
   	          //     if(right == 5)
   	            //	   return true;
  	   if(right >= 5) return 100;
  	   else if(right!=1&&rra - rrs + right >= 5)
  	   {
  		   int belong = (4-right)*2;
  		   boolean dead = false,already = false;
  		   if(x+b!=15&&y+b!=15&&cB[x+b][y+b] == 0)
  			    ;
  		   else dead = true;
  		   if(x+e>=0&&y+e>=0&&cB[x+e][y+e] == 0)
  		   {
  			   if(!dead) kind[belong]++;
  			   else kind[++belong]++;
  		   }
  		   else
  		   {
  			   if(!dead) kind[++belong]++;
  			 else belong = 6;
  		   }
  		 if(belong == 0)
  		      next = (x+b)*15+y+b;
  		   else if(belong != 6)
  		   {
  		   for(int m = 0;m<belong;++m)
  			      if(kind[m]!=0)
  			      {
  			    	  already = true;
  			    	  break;
  			      }
  		   if(!already)
  		   {
  			   if(belong%2 == 0)
  				    next = (x+b)*15+y+b;
  			   else if(x+b<15&&y+b<15&&cB[x+b][y+b] == 0)
  				      next = (x+b)*15+y+b;
  			   else next = (x+e)*15+y+e;
  			      }
  		   }
  				   }
  	   b = 0;
  	   e = -1;
   	         	  for(i = x,j = y;i!=15&&j>=0;++i,--j)
   	    	            if(cB[i][j] == 2)
   	    	             	{++left;++b;}
   	    	            else break;
   	         	  for(;i!=15&&j>=0&&cB[i][j] == 0;++i,--j)
   	         		     ++lla;
   	    	  for(i = x-1,j = y+1;i>=0&&j!=15;--i,++j)
   	    		     if(cB[i][j] == 2)
   	    		    	    {++left;--e;}
   	    		     else break;
   	    	  for(;i>=0&&j!=15&&cB[i][j] == 0;--i,++j)
   	    		     --lls;
   	   	   if(left >= 5) return 100;
   	   	   else if(left !=1&&lla-lls+left>=5)
   	   	   {
   	   		   int belong = (4-left )*2;
   	   		   boolean dead = false,already = false;
   	   		   if(x + b!=15&& y - b >= 0&&cB[x+b][y-b] == 0)
   	   			    ;
   	   		   else dead = true;
   	   		   if(x+e>=0&&y - e!=15 &&cB[x+e][y-e] == 0)
   	   		   {
   	   			   if(!dead) kind[belong]++;
   	   			   else kind[++belong]++;
   	   		   }
   	   		   else
   	   		   {
   	   			   if(!dead) kind[++belong]++;
   	   			else belong = 6;
   	   		   }
   	   	 if(belong == 0)
  		      next = (x+b)*15+y-b;
  		   else if(belong != 6)
  		   {
  		   for(int m = 0;m<belong;++m)
  			      if(kind[m]!=0)
  			      {
  			    	  already = true;
  			    	  break;
  			      }
  		   if(!already)
  		   {
  			   if(belong%2 == 0)
  				    next =(x+b)*15+y-b;
  			   else if(x+b<15&&y-b>=0&&cB[x+b][y-b] == 0)
  				      next = (x+b)*15+y-b;
  			   else next = (x+e)*15+y-e;
  			      }
  		   }
   	   				   }
   	    	            //   if(left == 5)
   	    	            //	   return true;
   	    	      //  return false;
   	   	  
   	   	   
   	     if(kind[0]>=1||kind[1]>=2||kind[1]+kind[2]>=2)
   	     {
   	    	 this.next = next;
   	    	 this.score = 90;
   	    	 return 90;
   	     }
   	     else if(kind[2]>=2)
   	     {
   	    	 if(80>=this.score)
   	    	 {
   	    		 this.score = 80;
   	    		 this.next  =next;
   	    	 }
   	    	 return 80;
   	     }
   	     else if(kind[2]+kind[3]>=2)
   	     {
   	    	 if(70>=this.score)
   	    	 {
   	    		 this.score = 70;
   	    		 this.next  =next;
   	    	 }
   	    	 return 70;
   	     }
   	     else if(kind[1] >= 1)
   	     {   	  
   	    	 if(60>=this.score)
	    	 {
	    		 this.score = 60;
	    		 this.next  =next;
	    	 }
   	    	 return 60;
   	     }
   	     else if(kind[2] >= 1)
   	     {
   	    	 if(50>=this.score)
   	    	 {
   	    		 this.score = 50;
   	    		 this.next  =next;
   	    	 }
   	    	 return 50;
   	     }
   	     else if(kind[4] >= 2)
   	    	 return 40;
   	     else if(kind[3] >= 1)
   	    	   return 30;
   	     else if(kind[4] >= 1)
   	    	 return 20;
   	     else if(kind[5]>=1)
   	    	 return 10;
   	     else return 0;
	  }*/
}
