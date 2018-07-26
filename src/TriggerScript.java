import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriggerScript 
{
	public static void main(String[] args) throws IOException 
	{
		ProcessBuilder pb = new ProcessBuilder("processLogFile.sh", "/home/weloadm/data/logs", "/home/weloadm/data/badRecords/badRecords.log");
		pb.directory(new File("/home/weloadm/data/script"));
		Process p = pb.start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		System.out.println(br.readLine());
	}

}
