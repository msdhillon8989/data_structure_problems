package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class TextEditorStack {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cases = Integer.parseInt(br.readLine());
		Stack<String[]> commands = new Stack();
		while(cases-->0)
		{
			String input[] = br.readLine().split(" ");
			if(input[0].equals("1"))
			{
				String undoCommand[] = {"2",input[1].length()+""};
				commands.push(undoCommand);
				sb = executeCommand(sb,input);
			}
			else if(input[0].equals("2"))
			{
				int size = Integer.parseInt(input[1]);
				String undoCommand[] = {"1",sb.substring(sb.length()-size)};
				commands.push(undoCommand);
				sb = executeCommand(sb,input);
			}
			else if(input[0].equals("3"))
			{
				int index = Integer.parseInt(input[1]);
				System.out.println(sb.charAt(index-1));
			}
			else if(input[0].equals("4"))
			{
				String command[]  = commands.pop();  
				sb =executeCommand(sb, command);
			}
			
		}
	}

	private static StringBuilder executeCommand(StringBuilder sb, String[] input) 
	{
		if(input[0].equals("1"))
		{
			sb.append(input[1]);
			return sb;
		}
		else
		{
			int size = Integer.parseInt(input[1]);
			sb.setLength(sb.length()-size);
			return sb;
		}
		
		
	}

}
