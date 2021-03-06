package websockertserver;
import java.io.IOException;
import java.util.Random;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/testserver")
public class TestWebsocketServer {
   private static int count=1;

   @OnMessage
   public void onMessage(Session session,
         String message) {
      if(message.trim().isEmpty())
         return;
      try {
         session.getBasicRemote().sendText
            ("Received message "+count+": " + message);
         session.getBasicRemote().sendText
            ("Lucky number! "+new Random().nextInt(99));
         session.getBasicRemote().sendText
            ("-----------------------------------");
      } catch (IOException ex) {

      }
      count++;
   }
}