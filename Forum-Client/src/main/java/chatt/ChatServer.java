package chatt;



import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ChatServer {
	public static void main(String[] args) throws InterruptedException {
		// Integer portNumber=19990;
		new ChatServer(8000).run();
	}

	private final Integer port;

	public ChatServer(Integer port) {
		this.port = port;
	}

	public void run() throws InterruptedException {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap bootstrap = new ServerBootstrap()
					.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new ChatServerInitializer());
			bootstrap.bind(port).sync().channel().closeFuture().sync();
			/*ChannelFuture f = bootstrap.bind().sync();
			System.out.println("ChannelFuture bind is a success");
			f.channel().closeFuture().sync();
			System.out.println("ChannelFuture has been closed");*/
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}

	}

	/*static {
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(Level.INFO);
		rootLogger.addAppender(new ConsoleAppender(new PatternLayout("%-6r [%p] %c - %m%n")));
	}*/
}
