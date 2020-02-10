package examples.ex2_readFromFile;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

public class simpleBolt extends BaseBasicBolt {

    public void cleanup() {}


    public void execute(Tuple input,BasicOutputCollector collector) {
        collector.emit(new Values(input.getString(0)+" After Bolt"));
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("word"));
    }
}