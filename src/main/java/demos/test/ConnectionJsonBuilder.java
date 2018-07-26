package demos.test;

import java.util.ArrayList;
import java.util.List;

public class ConnectionJsonBuilder {
	private static final List<String> ports = new ArrayList<>();

	final private static String template ="{\"ocs\":\"<OCS_NAME>\",\"inport\":\"<INPORT>\",\"outport\":\"<OUTPORT>\",\"opType\":\"ADD\",\"dir\":\"<DIR>\"}";

	private static final List<String> ocs = new ArrayList<>();
	static private final String direction = "UNI";
	public static void main(String[] args) {
		initPorts();
		int usePorts = 320;
		int skip = 0;
		ocs.add("Calient.Raj.OCS-01");
		ocs.add("Calient.Raj.OCS-02");

		StringBuilder json = new StringBuilder("[");

		for(int i=0;i<(usePorts);i++)
		{
			String inport = ports.get(skip+i);
			//String outport = ports.get(skip+usePorts-i-1);
			for(String ocs : ocs)
			{
				json.append(template.replace("<OCS_NAME>",ocs).replace("<INPORT>",inport).replace("<OUTPORT>",inport).replace("<DIR>",direction)).append(",\n");
			}
		}
		json.setLength(json.length()-2);
		json.append("]");

		System.out.println(json);
	}

	private static void initPorts() {
		String port = "";
		int count=0;
		for(int i=1;i<6;i++)
		{
			for(int j=1;j<9;j++)
			{
				for(int k=1;k<9;k++)
				{
					port =i+"."+j+"."+k;
					ports.add(port);
					//System.out.println(port);
					count++;
				}
			}
		}
		//System.out.println(count);
	}
}
