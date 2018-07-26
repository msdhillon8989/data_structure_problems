package demo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by maninder on 3/1/17.
 */
public class SocketDemo {
    private void  personaSocketDemo()
    {
        try{
            Socket s = new Socket("dmp.personagraph.com",80);
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            pw.println("GET /api/v1/segment/segments HTTP/1.1");
            pw.println("Host: dmp.personagraph.com");
            pw.println("authToken: 15jsj3mukbvoa20gprir6q0r:332c");
            pw.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            pw.println("Accept-Encoding: gzip, deflate, sdch, br");
            pw.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String line ="";
            System.out.println("request sent");

            while(line!=null)
            {
                System.out.println("waiting");
                line = br.readLine();
                System.out.println("line "+line);

            }




        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(5000);
            while(true)
            {
                Socket socket = serverSocket.accept();

                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String line = "";
                String contentHeader = "Content-Length: ";
                int contentLength =0;
                while (!(line=br.readLine()).trim().equals("")) {
                    System.out.println(line);
                    if (line.startsWith(contentHeader)) {
                        contentLength = Integer.parseInt(line.substring(contentHeader.length()));
                    }
                }

                StringBuilder body = new StringBuilder();
                System.out.println("header finished "+contentLength);
                int c = 0;
                for (int i = 0; i < contentLength; i++) {
                    c = br.read();
                    body.append((char) c);
                }
                System.out.println(body.toString());
                out.println("HTTP/1.0 200 OK");
                out.println("Content-Type: text/html");
                out.println("");
                // Send the HTML page
                String method = "get";
                out.print("<html><form method="+method+">");
                out.print("<textarea name=we></textarea></br>");
                out.print("<input type=text name=a><input type=submit></form></html>");
                out.println();
                out.flush();

                socket.close();


            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
