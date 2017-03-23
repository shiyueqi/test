package socket;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * date: 2016/09/20 15:29.
 * author: Yueqi Shi
 */
public class SocketServer {
    int port = 9098;

    void start() {
        Socket s = null;
        try {
            ServerSocket ss = new ServerSocket(port);
            while (true) {
                // 选择进行传输的文件
                String filePath = "C:\\";

                JFileChooser fileChooser = new JFileChooser(filePath);
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setDialogTitle("选择文件");
                fileChooser.setApproveButtonText("选择");
                int returnVal = fileChooser.showOpenDialog(fileChooser);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    filePath= fileChooser.getSelectedFile().getAbsolutePath();//这个就是你选择的文件夹的路径
                } else {
                    System.out.println("socket server select file is null, braek.");
                    break;
                }

                System.out.println("socket server select file path: " + filePath);

                File fi = new File(filePath);

                System.out.println("file length: " + (int) fi.length());

                // public Socket accept() throws
                // IOException侦听并接受到此套接字的连接。此方法在进行连接之前一直阻塞。

                s = ss.accept();
                System.out.println("build socket connection");
                DataInputStream dis = new DataInputStream(new BufferedInputStream(s.getInputStream()));
                dis.readByte();

                DataInputStream fis = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)));
                DataOutputStream ps = new DataOutputStream(s.getOutputStream());
                //将文件名及长度传给客户端。这里要真正适用所有平台，例如中文名的处理，还需要加工，具体可以参见Think In Java 4th里有现成的代码。
                ps.writeUTF(fi.getName());
                ps.flush();
                ps.writeLong((long) fi.length());
                ps.flush();

                int bufferSize = 8192;
                byte[] buf = new byte[bufferSize];

                while (true) {
                    int read = 0;
                    if (fis != null) {
                        read = fis.read(buf);
                    }

                    if (read == -1) {
                        break;
                    }
                    ps.write(buf, 0, read);
                }
                ps.flush();
                // 注意关闭socket链接哦，不然客户端会等待server的数据过来，
                // 直到socket超时，导致数据不完整。
                fis.close();
                s.close();
                System.out.println("file transfer complete");
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String arg[]) {
        new SocketServer().start();
    }
}
