import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class Mapper2 extends Mapper<LongWritable, Text, Text, DoubleWritable> {
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line.startsWith("order_id")) return; // skip header
        String[] fields = line.split(",");
        if (fields.length > 33) {
            try {
                String category = fields[23].trim();
                double totalPrice = Double.parseDouble(fields[33].trim());
                context.write(new Text(category), new DoubleWritable(totalPrice));
            } catch (NumberFormatException e) {
                // skip bad rows
            }
        }
    }
}