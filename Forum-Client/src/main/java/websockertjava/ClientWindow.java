package websockertjava;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientWindow extends JFrame {

   private final JLabel messageLabel =
      new JLabel("Client Message");
   private final JTextField messageField =
      new JTextField(10);
   private final JButton sendButton =
      new JButton("Send");
   private final JTextArea serverMessageText =
      new JTextArea("");
   private final TestWebsocketClient client;

   public ClientWindow() {
      setSize(400, 400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      getContentPane().setLayout(new BorderLayout(10, 10));

      JPanel p = new JPanel();
      p.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
      p.add(messageLabel);
      p.add(messageField);
      p.add(sendButton);

      add(p, BorderLayout.NORTH);
      JScrollPane scroll = new JScrollPane(
         JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
         JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scroll.setViewportView(serverMessageText);
      add(scroll, BorderLayout.CENTER);

      client = new TestWebsocketClient(this);

      sendButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            client.sendMessage(messageField.getText());
         }
      });
   }

   public void writeServerMessage(String message) {
      serverMessageText.setText(serverMessageText.getText()
         + "\n" + message);
   }

   public static void main(String[] args) {
      ClientWindow clientWindow = new ClientWindow();
   }
   
}