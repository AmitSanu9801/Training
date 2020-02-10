package examples.ex2_readFromFile;


import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;


public class TopologyMain {
    public static void main(String[] args) throws InterruptedException {

        //Topology definition
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("File-Reader-Spout", new fileReaderSpout());
        builder.setBolt("Simple-Bolt", new simpleBolt()).shuffleGrouping("File-Reader-Spout");

        //Configuration
        Config conf = new Config();
        conf.setDebug(true);
        conf.put("fileToRead", "/home/amrit/Desktop/f.txt");

        LocalCluster cluster = new LocalCluster();
        try{cluster.submitTopology("File-Reader-Topology", conf, builder.createTopology());
        Thread.sleep(1000);}
       finally{
        cluster.shutdown();}
    }
}
