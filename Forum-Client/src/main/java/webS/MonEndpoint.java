package webS;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;



public class MonEndpoint extends Endpoint{
	private static final Logger LOGGER = Logger.getLogger(MonEndpoint.class.getName());
	@Override
    public void onOpen(Session session, EndpointConfig EndpointConfig) {
		 final RemoteEndpoint.Basic remote = session.getBasicRemote();
	        session.addMessageHandler(new MessageHandler.Whole<String>() {
	            @Override
	            public void onMessage(String text) {
	                try {
	                    remote.sendText(text);
	                } catch (IOException ioe) {
	                	  LOGGER.log(Level.SEVERE, "Erreur durant l'envoi",ioe);
	                }
	            }
	        });
	        session.addMessageHandler(new MessageHandler.Partial<String>() {
	            @Override
	            public void onMessage(String text, boolean last) {
	                try {
	                    remote.sendText(text);
	                } catch (IOException ioe) {
	                	  LOGGER.log(Level.SEVERE, "Erreur durant l'envoi",ioe);
	                }
	            }
	        });
    }

}
