package socket;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;

/**
 * date: 2016/09/20 15:52.
 * author: Yueqi Shi
 */
public class SocketClient {
    private ClientSocket cs = null;

    private String ip = "localhost";// 设置成服务器IP

    private int port = 9098;

    private String sendMessage = "Windwos";

    public SocketClient() {
        try {
            if (createConnection()) {
                sendMessage();
                getMessage();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private boolean createConnection() {
        cs = new ClientSocket(ip, port);
        try {
            cs.createConnection();
            System.out.println("connect to server success!");
            return true;
        } catch (Exception e) {
            System.out.println("connect to server fail!");
            e.printStackTrace();
            return false;
        }

    }

    private void sendMessage() {
        if (cs == null)
            return;
        try {
            cs.sendMessage(sendMessage);
        } catch (Exception e) {
            System.out.println("send msg error!");
            e.printStackTrace();
        }
    }

    private void getMessage() {
        if (cs == null)
            return;
        DataInputStream inputStream = null;
        try {
            inputStream = cs.getMessageStream();
        } catch (Exception e) {
            System.out.println("get msg input stream error");
            e.printStackTrace();
            return;
        }

        try {
            //本地保存路径，文件名会自动从服务器端继承而来。
            String filePath = "C:\\";

            String fileName = inputStream.readUTF();

            JFileChooser fileChooser = new JFileChooser(filePath);
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setDialogTitle(fileName + " 文件保存目录");
            fileChooser.setApproveButtonText("选择");
            int returnVal = fileChooser.showOpenDialog(fileChooser);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                filePath= fileChooser.getSelectedFile().getAbsolutePath() + "\\";//这个就是你选择的文件夹的路径
            }

            System.out.println("socket client save file path: " + filePath);

            int bufferSize = 8192;
            byte[] buf = new byte[bufferSize];
            int passedlen = 0;
            long len=0;

            filePath += fileName;
            DataOutputStream fileOut = new DataOutputStream(
                    new BufferedOutputStream(new BufferedOutputStream(new FileOutputStream(filePath))));
            len = inputStream.readLong();

            System.out.println("file length: " + len);
            System.out.println("start to receive file!");

            while (true) {
                int read = 0;
                if (inputStream != null) {
                    read = inputStream.read(buf);
                }
                passedlen += read;
                if (read == -1) {
                    break;
                }
                //下面进度条本为图形界面的prograssBar做的，这里如果是打文件，可能会重复打印出一些相同的百分比
                System.out.println("the file has received" +  (passedlen * 100/ len) + "%");
                fileOut.write(buf, 0, read);
            }
            System.out.println("receive complete, the file save as " + filePath);

            fileOut.close();
        } catch (Exception e) {
            System.out.println("receive msg error");
            e.printStackTrace();
            return;
        }
    }

    public static void main(String arg[]) {
        new SocketClient();
    }
}
