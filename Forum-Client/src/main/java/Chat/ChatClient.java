package Chat;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


import antlr.debug.Event;
import io.*;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.ScheduledFuture;
public class ChatClient {
	public static void main(String[]args) throws Exception, IOException{
		new ChatClient("localhost", 18080).run();
	}
private final String host;
private final Integer port;
public ChatClient(String host, Integer port) {
	super();
	this.host = host;
	this.port = port;
}
public void run() throws InterruptedException, IOException{
	EventLoopGroup group=new NioEventLoopGroup();
	try{
		Bootstrap bootstrap= new Bootstrap()
				.group(group).channel(NioSocketChannel.class)
				.handler(new ChatClientInitializer());
	Channel channel=bootstrap.connect(host,port).sync().channel();
	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	while(true){
		channel.write(in.readLine()+"\r\n" );
	}
	}
	finally{
		group.shutdownGracefully();
	}
}}
