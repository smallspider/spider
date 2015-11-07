import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
public class Client extends Frame
{
    TextField tf=new TextField(20);
    TextArea ta=new TextArea();
    Button send=new Button("send");
    Button voiceChat=new Button("voiceChat");
    Socket client;
    InputStream in;
    OutputStream out;
    BufferedReader br;
    BufferedWriter bw;
    public Client()
    {
        super("Client");
        add("North",tf);
        add("Center",ta);
        add("South",send);
        add("East",voiceChat);
        setSize(250,250);
        show();
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                dispose();
                System.exit(0);
            }
        });
        try
        {
            Socket client=new Socket("127.0.0.1",5000);
            ta.append("Connect to:"+client.getInetAddress().getHostName()+"\n\n");
            in=client.getInputStream();
            br=new BufferedReader(new InputStreamReader(in));
            out=client.getOutputStream();
            bw=new BufferedWriter(new OutputStreamWriter(out));
        }
        catch(IOException ioe)
        {}
        while(true)
        {
            try
            {
                byte[] buf=new byte[200];
                in.read(buf);
                String str=new String(buf);
                ta.append("Server say:"+str);
                ta.append("\n");
            }
            catch(IOException e)
            {
                System.out.print(e.getMessage());
            }
        }
    }
    public boolean action(Event evt, Object arg)
    {
        if(evt.target.equals(send))
        {
            try
            {
                String str=tf.getText();
                byte[] buf=str.getBytes();
                tf.setText(null);
                out.write(buf);
                ta.append("I say:"+str);
                ta.append("\n");
            }
            catch(IOException ioe)
            {
                System.out.print(ioe.getMessage());
            }
        }
        else if(evt.target.equals(voiceChat))
        {
            try
            {
                Socket cli=new Socket("127.0.0.1",6000);
                Capture cap=new Capture(cli);
                cap.start();
            }
            catch(Exception e)
            {}
        }
        return true;
    }
    public static void main(String[] args)
    {
        Client client=new Client();
    }
    
}

