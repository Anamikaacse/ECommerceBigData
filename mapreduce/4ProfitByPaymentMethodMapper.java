import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class Mapper4 extends Mapper<LongWritable, Text, Text, DoubleWritable> {
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line.startsWith("order_id")) return;
        String[] fields = line.split(",");
        if (fields.length > 38) {
            try {
                String paymentMethod = fields[38].trim();
                double profit = Double.parseDouble(fields[35].trim());
                context.write(new Text(paymentMethod), new DoubleWritable(profit));
            } catch (NumberFormatException e) {
                // skip bad rows
            }
        }
    }
}