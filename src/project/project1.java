package project;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import project.GUIlauncher;

public class project1 {
  static String[] words = new String[100000];
  String Str;
  static String graph = "" ;
  static int temp; 
	
  public String getString()
	{
         return Str;
	}

  public void setString(String Str)
	{
		this.Str = Str;
	}
	
  public static void main(String[] args) throws Exception  {
		
		
		GUIlauncher pic = new GUIlauncher();
	}
	
	//将txt文件打开
  public static String txtOpen(File file){
		
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
	
	//路径文件处理
  public static List<File> getFileList(String path){//获取路径下的文件列表
        File[] files = new File(path).listFiles();
        List<File> fileList = new ArrayList<File>();
        for(File file:files){
            fileList.add(file);
        }
        return fileList;
    }

  public static String domain(String Str)
	{
		 
        Str=Str.substring(1);
        return Str;
	}	
  public static class edge
	{
		String start_node;
		String end_node;
		int weight;
		
	}
	
  public static List<edge> createDirectedGraph(String Str)
	{
		words = Str.split(" ");
		
		int n = 0;
		for(int i = 0; i < words.length; i++)
		{
			if(null != words[i]) 
				n++;
		}
		
		List<edge> edges=new ArrayList();
		int cnt=1;
		while(cnt!=n)
		{
			int i;
			String new_start=words[cnt-1];
			String new_end=words[cnt];
			for(i=0;i<edges.size();i++)
			{
				if(edges.get(i).start_node.equals(new_start)&&edges.get(i).end_node.equals(new_end))
				{					
					edges.get(i).weight++;
					break;
				}

			}
			if(i==edges.size())
			{
				edge new_edge=new edge();
				new_edge.start_node=new_start;
				new_edge.end_node=new_end;
				new_edge.weight=1;
				edges.add(new_edge);
			}
					
			cnt++;
		}
		for(int i = 0;i<edges.size();i++)
		{
			
			graph += (edges.get(i).start_node+" -> "+edges.get(i).end_node+"[label = \""+ edges.get(i).weight+"\"];");
		}
		
		return edges;
				
	}
	
  public static void showDirectedGraph(List<edge> edges)
	{
		for(int i=0;i<edges.size();i++)
		{
			System.out.print("From:"+edges.get(i).start_node+"  To:"+edges.get(i).end_node+"  Weight:"+edges.get(i).weight);
			System.out.println();
		}
	}
	
	/** List order maintained  list查重 **/      
	
  public static void removeDuplicateWithOrder(List<String> arlList)      
	{      
		Set set = new HashSet();      
		List newList = new ArrayList();
		for (Iterator iter = arlList.iterator(); iter.hasNext(); )      
		{      
			Object element = iter.next();      
			if (set.add(element)) 
				newList.add(element);      
		}      
		arlList.clear();      
		arlList.addAll(newList);      
	}
	
	public static void createDotGraph(String dotFormat,String fileName)
	 {
	     GraphViz gv=new GraphViz();
	     gv.addln(gv.start_graph());
	     gv.add(dotFormat);
	     gv.addln(gv.end_graph());
	     String type = "jpg";
	     gv.decreaseDpi();
	     gv.decreaseDpi();
	     File out = new File(fileName+"."+ type); 
	     gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
	 }
	
  public static String queryBridgeWords(List<edge> edges, String word1, String word2)
	{
		int a = 0;
		int b = 0;
		String answer=new String();
		List<String> bridge_word=new ArrayList();
		for(int i=0;i<edges.size();i++)
		{
			if(edges.get(i).start_node.equals(word1))
			{
				a=1;
				String new_start=edges.get(i).end_node;
				for(int j=0;j<edges.size();j++)
				{
					if(edges.get(j).end_node.equals(word2)&&edges.get(j).start_node.equals(new_start))
					{
						b=1;
						bridge_word.add(new_start);
					}
				}
			}
		}
		if(a==0)
		{
			for(int i=0;i<edges.size();i++)
			{
				if(edges.get(i).end_node.equals(word1)) 
					a=1;
			}
		}
		if(b==0)
		{
			for(int i=0;i<edges.size();i++)
			{
				if(edges.get(i).end_node.equals(word2)||edges.get(i).start_node.equals(word2)) 
					b=1;
			}
		}
		if(a==0&&b==0)
		{
			//System.out.println("No "+"“"+word1+"”"+" and “"+word2+"”"+" in the graph!");
			answer += ("No "+"“"+word1+"”"+" and “"+word2+"”"+" in the graph!");
		}
		else if(a==1&&b==0)
		{
			//System.out.println("No "+"“"+word2+"”"+" in the graph!");
			answer += ("No "+"“"+word2+"”"+" in the graph!");
		}
		else if(a==0&&b==1)
		{
			//System.out.println("No "+"“"+word1+"”"+" in the graph!");
			answer += ("No "+"“"+word1+"”"+" in the graph!");
		}
		else if(bridge_word.size()>1)
		{
			//System.out.print("The bridge words from word1 to word2 are: ");
			answer +=("The bridge words from "+word1+" to "+word2+" are: ");
			for(int i=0;i<bridge_word.size()-1;i++)
			{
				//System.out.print(bridge_word.get(i)+", ");
				answer += (bridge_word.get(i)+", ");
			}
			//System.out.println("and "+bridge_word.get(bridge_word.size()-1)+".");
			answer += ("and "+bridge_word.get(bridge_word.size()-1)+".");
			//return answer;
		}
		else if(bridge_word.size()==1)  //"."???是不是有点多
		{
			//System.out.print("and "+bridge_word.get(bridge_word.size()-1)+".");
			answer += ("The bridge word from "+word1+" to "+word2+" is: ");
			//System.out.println(bridge_word.get(bridge_word.size()-1)+".");
			answer += (bridge_word.get(bridge_word.size()-1)+".");
			//return answer;
		}
		else if(bridge_word.size()==0)
		{
			//System.out.println("No bridge words from" +word1+" to "+ word2+"!" );
			answer += ("No bridge words from " +word1+" to "+ word2+"!") ;
			
		}
		return answer;
	}
	
  public static String generateNewText(List<edge> edges, String inputText)
	{
		
		String[] new_words = new String[1000];
		new_words=inputText.split(" ");
		int n = 0;
		int add=0;
		int cnt=1;
		String new_string=new String();
		for(int i = 0; i < new_words.length; i++)
		{
			if(null != new_words[i]) 
				n++;
		}
		while(cnt!=n)
		{
			//String new_start=words[cnt-1];
			//String new_end=words[cnt];
			List<String> bridge_word=new ArrayList();
			for(int i=0;i<edges.size();i++)
			{
				
				if(edges.get(i).start_node.equals(new_words[cnt-1]))
				{
					
					String new_start=edges.get(i).end_node;
					//String.copyValueOf(word1);
					for(int j=0;j<edges.size();j++)
					{
						if(edges.get(j).end_node.equals(new_words[cnt])&&edges.get(j).start_node.equals(new_start))
						{
							
							bridge_word.add(new_start);
						}
					}
				}
			}
			new_string+=new_words[cnt-1];
			new_string+=" ";
			if(bridge_word.size()==1)
			{
				new_string+=bridge_word.get(0);
				new_string+=" ";
			}
			else if(bridge_word.size()>1)
			{
				
				Random random=new Random();
				int rand_int=random.nextInt(bridge_word.size());
				new_string+=bridge_word.get(rand_int);
				new_string+=" ";
			}
			if(cnt==n-1)
			{
				new_string+=new_words[cnt];
				//new_string+=" ";
			}
			//else new_string+=new_words[cnt];
	
			cnt++;
			//return new_string;
			
			
			
		}
		return new_string;
	}
  public static List<String> calcShortestPath(List<edge> edges, String word1, String word2)
	{
		List<String> path=new ArrayList();
		List<List<String>> final_paths=new ArrayList();
		Queue<List<String>> paths=new  LinkedList<List<String>>();
		path.add(word1);
		paths.offer(path);
		String new_start=word1;
		String new_end=word2;
		List<String> ans=new ArrayList();
		while(!paths.isEmpty())
		{
			new_start=paths.peek().get(paths.peek().size()-1);
			for(int i=0;i<edges.size();i++)
			{
				List<String> new_path=new ArrayList();
				
				if(edges.get(i).start_node.equals(new_start))
				{
					new_end=edges.get(i).end_node;
					for(int j=0;j<paths.peek().size();j++)
					{
						new_path.add(paths.peek().get(j));
					}
					if(!new_path.contains(new_end))
					{
						new_path.add(new_end);
						if(new_path.get(new_path.size()-1).equals(word2))
						{
							final_paths.add(new_path);
							break;
						}
						paths.add(new_path);
					}
					
				}
			}
			paths.poll();
			
			
		}
		int shortest=Integer.MAX_VALUE;
		for(int i=0;i<final_paths.size();i++)
		{
			//ans[i]=final_paths.get(i);
			String temp="";
			int cnt=0;
			for(int j=0;j<final_paths.get(i).size();j++)
			{
				//temp+=
				
				temp+=final_paths.get(i).get(j);
				temp+=" ";
				cnt++;
			}
			temp+=" length:"+(final_paths.get(i).size()-1);
			if(shortest>=cnt) 
				{
					shortest=cnt;
					ans.add(temp);
					continue;
				}
			
		}
		
		return ans;
	}

  public static String randomWalk(List<edge> edges)
	{
		
		Random random=new Random();
		int rand_int=random.nextInt(edges.size());
		//String word1="T";
		String word1=edges.get(rand_int).start_node;
		List<String> sol=new ArrayList();
		String ans="";
		while(1==1)
		{
			List<String> path=new ArrayList();
			for(int i=0;i<edges.size();i++)
			{
				if(edges.get(i).start_node.equals(word1))
				{
					path.add(edges.get(i).end_node);
					//if(temp==1) return path;
				}
			}
			int new_rand=0;
			if(path.size()==0) 
				break;
			else if(path.size()==1) 
				new_rand=0;
			else new_rand=random.nextInt(path.size());
			int flag=0;
			for(int i=0;i<sol.size()-1;i++)
			{
				if((sol.get(i).equals(word1)&&sol.get(i+1).equals(path.get(new_rand))))
				{
					sol.add(word1);
					sol.add(path.get(new_rand));
					flag=1;
					break;
				}
			}
	
			if(sol.size()!=0)
			{
				if(sol.get(sol.size()-1).equals(word1)&&word1.equals(path.get(new_rand)))
				{
					sol.add(word1);
					sol.add(path.get(new_rand));
					//flag=1;
					break;
				}
			
			}
		
			//if(sol.get(index))
			if(flag==1) break;

			sol.add(word1);
			word1=path.get(new_rand);
		}
		for(int i=0;i<sol.size();i++)
		{
			if(temp==1) break; 
			ans+=sol.get(i);
			ans+=" ";
		}
		return ans;

	
	}
}

