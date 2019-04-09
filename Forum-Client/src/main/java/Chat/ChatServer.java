package Chat;



import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ChatServer {
	public static void main(String[]args) throws  InterruptedException{
		//Integer portNumber=19990;
		new ChatServer(port);
	}
	private static Integer port;

public ChatServer(Integer port) {
	super();
	this.setPort(port);
}

public Integer getPort() {
	return port;
}

public void setPort(Integer port) {
	this.port = port;
}
public void run() throws InterruptedException{
	EventLoopGroup bossGroup=new NioEventLoopGroup();
	EventLoopGroup markerGroup=new NioEventLoopGroup();
   try{
	   ServerBootstrap bootstrap= new ServerBootstrap()
	   .group(bossGroup,markerGroup)
	   .channel(NioServerSocketChannel.class)
	   .handler(new ChatServerInitializer());
   //bootstrap.bind(port).sync().channel().closeFuture().sync();
	   ChannelFuture f = bootstrap.bind().sync();
       System.out.println("ChannelFuture bind is a success");
       f.channel().closeFuture().sync();
       System.out.println("ChannelFuture has been closed");
   }
   finally{
	   bossGroup.shutdownGracefully();
	   markerGroup.shutdownGracefully();
   }
   
}

}
