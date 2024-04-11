import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketUtils {
    
    public OutputStreamWriter osw;
    public BufferedWriter bw;
    public PrintWriter out;

    public InputStreamReader isr;
    public BufferedReader in;

    public SocketUtils(Socket cs){
        try {
            osw = new OutputStreamWriter(cs.getOutputStream());
            isr = new InputStreamReader(cs.getInputStream());
            in = new BufferedReader(isr);

            bw = new BufferedWriter(osw);
            out = new PrintWriter(bw, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    public void dispose(){
        try {
            osw.close();
            isr.close();
            in.close();
            bw.close();
            out.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

}
