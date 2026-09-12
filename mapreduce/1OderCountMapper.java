import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Mapper1 extends Mapper<LongWritable, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text totalKey = new Text("Total_Orders");

    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();

        // Skip header row
        if (line.startsWith("order_id") || key.get() == 0) {
            return;
        }

        // Skip empty lines
        if (line.trim().isEmpty()) {
            return;
        }

        context.write(totalKey, one);
    }
}