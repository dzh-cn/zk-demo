package spring.demo.dzhh_cn.zookeeperdemo;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class ZookeeperDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZookeeperDemoApplication.class, args);
	}

	@Bean
	ZooKeeper getZookeeper() throws IOException {
		return new ZooKeeper("58.87.85.24:2181", 5000, new Watcher() {
			Logger logger = LoggerFactory.getLogger("ZookeeperDemoApplication-ZooKeeper-Watcher");
			@Override
			public void process(WatchedEvent watchedEvent) {
				logger.info("ZookeeperDemoApplication.process : {}", watchedEvent.getPath());
			}
		});
	}
}
