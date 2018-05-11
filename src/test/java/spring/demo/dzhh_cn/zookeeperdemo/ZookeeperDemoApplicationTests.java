package spring.demo.dzhh_cn.zookeeperdemo;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Version;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZookeeperDemoApplicationTests {

	private static Logger logger = LoggerFactory.getLogger(ZookeeperDemoApplicationTests.class);

	@Autowired
	ZooKeeper zooKeeper;

	@Test
	public void contextLoads() throws KeeperException, InterruptedException, UnsupportedEncodingException {
		logger.info("\n\t**ZookeeperDemoApplicationTests.contextLoads zooKeeper children : {}", zooKeeper.getChildren("/com", false));

		byte[] cjd = "董智华".getBytes("UTF8");
		zooKeeper.setData("/com/jd/dong", cjd, Version.getRevision());

		byte[] data = zooKeeper.getData("/com/jd/dong", false, null);
		logger.info("\n\t**ZookeeperDemoApplicationTests.contextLoads zooKeeper : {}", new String(data));

	}

}
