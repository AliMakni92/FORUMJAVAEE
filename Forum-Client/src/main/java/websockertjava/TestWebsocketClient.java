package websockertjava;
import java.io.IOException;
import java.net.URI;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public class TestWebsocketClient {
   private final String uri="ws://localhost:8080/WebsocketTest/testserver";
   private Session session;
   private ClientWindow clientWindow;

   public TestWebsocketClient(ClientWindow cw){
      clientWindow=cw;
      try{
         WebSocketContainer container=ContainerProvider.
            getWebSocketContainer();
         container.connectToServer(this, new URI(uri));

      }catch(Exception ex){

      }
   }

   @OnOpen
   public void onOpen(Session session){
      this.session=session;
   }

   @OnMessage
   public void onMessage(String message, Session session){
      clientWindow.writeServerMessage(message);
   }

   public void sendMessage(String message){
      try {
         session.getBasicRemote().sendText(message);
      } catch (IOException ex) {

      }
   }
}