//Parallel Processing
import java.io.*;
import java.util.*;

public class ParallelProcessing {

    public static long minTime(List<Integer> files, int numCores, int limit) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        
        for (int f : files) {
            if (f % numCores == 0) {
                x.add(f);
            } else {
                y.add(f);
            }
        }
        
        Collections.sort(x, Collections.reverseOrder());
        long sumX = 0;
        for (int i = 0; i < Math.min(limit, x.size()); i++) {
            sumX += x.get(i);
        }
        
        long result = (sumX / numCores);
        for (int i = limit; i < x.size(); i++) {
            result += x.get(i);
        }
        
        for (int f : y) {
            result += f;
        }
        
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int filesCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> files = new ArrayList<>();

        for (int i = 0; i < filesCount; i++) {
            int filesItem = Integer.parseInt(bufferedReader.readLine().trim());
            files.add(filesItem);
        }

        int numCores = Integer.parseInt(bufferedReader.readLine().trim());
        int limit = Integer.parseInt(bufferedReader.readLine().trim());

        long result = minTime(files, numCores, limit);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
