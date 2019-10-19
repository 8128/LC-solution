import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

class Asset implements Comparable<Asset> {
    String name;
    String type;
    int share;  // assume positive integer, can change to BigInt to address potential overflow

    public Asset() {}

    public Asset(String name, String type, int share) {
        this.name = name;
        this.type = type;
        this.share = share;
    }

    void setName(String name) {
        this.name = name;
    }

    void setType(String type) {
        this.type = type;
    }

    void setShare(int share) {
        this.share = share;
    }

    String getName() {
        return name;
    }

    String getType() {
        return type;
    }

    int getShare() {
        return share;
    }


    @Override
    public String toString() {
        return "name:" + name + " type:" + type + " share:" + share;
    }


    /**
     * compare the name of the asset
     */
    @Override
    public int compareTo(Asset other) {
        return this.getName().compareTo(other.getName());
    }
}


public class Problem4 {
    static ArrayList<Asset> portStock = new ArrayList<>(); // stock in the portfolio
    static ArrayList<Asset> portBond = new ArrayList<>(); // bond in the portfolio
    static ArrayList<Asset> benchStock = new ArrayList<>(); // stock in the benchmark
    static ArrayList<Asset> benchBond = new ArrayList<>(); // bond in the benchmark
    static ArrayList<String> sellList = new ArrayList<>();
    static ArrayList<String> buyList = new ArrayList<>();

    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            Problem4.matchBenchmark(line);
            updateList();
        }
    }

    public static void updateList() {
        sellList = new ArrayList<>();
        buyList = new ArrayList<>();
        portStock = new ArrayList<>();
        portBond = new ArrayList<>();
        benchStock = new ArrayList<>();
        benchBond = new ArrayList<>();
    }

    /**
     * Check if the asset belongs to bond or stock
     *
     * @param source
     * @param bond
     * @param stock
     */
    public static void checkAsset(String[] source, ArrayList<Asset> bond, ArrayList<Asset> stock) {
        for (String s : source) {
            String[] tmp = s.split(",");
            int share = Integer.parseInt(tmp[2].trim());
            Asset asset = new Asset(tmp[0].trim(), tmp[1].trim(), share);
            if (isBond(tmp[1])) {
                bond.add(asset);
            } else if (isStock(tmp[1])) {
                stock.add(asset);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * split the input String into portfolio and benchmark part
     *
     * @param input
     */
    public static void splitPortBench(String input) {
        String[] portAndBench = input.split(":");
        String[] portfolio;
        String[] bench;
        if (!input.contains(":")) { // invalid input
            return;

        }
        // normal case where both portfolio and benchmark have assets
        else if (portAndBench.length == 2 && input.substring(0, input.indexOf(":")).contains(",")) {
            portfolio = portAndBench[0].split("\\|");
            bench = portAndBench[1].split("\\|");
        } else if (input.substring(0, input.indexOf(":")).contains(",")) { // no assets in benchmark
            portfolio = portAndBench[0].split("\\|");
            bench = new String[0];
        } else { // no assets in portfolio
            portfolio = new String[0];
            bench = portAndBench[1].split("\\|");
        }

        checkAsset(portfolio, portBond, portStock);
        checkAsset(bench, benchBond, benchStock);
    }

    /**
     * Compare assets in the portfolio and benchmark to help decide if we should buy more or sell
     *
     * @param port
     * @param bench
     */
    public static void comparePortBench(ArrayList<Asset> port, ArrayList<Asset> bench) {
        int portIndex = 0;
        int benchIndex = 0;
        // compare assets in portfolio and benchmark
        while (portIndex < port.size() || benchIndex < bench.size()) {
            if (portIndex >= port.size()) { // remaining assets in benchmark not in portfolio
                for (int i = benchIndex; i < bench.size(); i++) {
                    Asset tmp = bench.get(i);
                    buyList.add("BUY," + tmp.getName() + "," + tmp.getType() + ","
                            + tmp.getShare());
                }
                break;
            }
            if (benchIndex >= bench.size()) { // remaining assets in portfolio not in benchmark
                for (int i = portIndex; i < port.size(); i++) {
                    Asset tmp = port.get(i);
                    sellList.add("SELL," + tmp.getName() + "," + tmp.getType() + ","
                            + tmp.getShare());
                }
                break;
            }
            Asset portAsset = port.get(portIndex);
            Asset benchAsset = bench.get(benchIndex);
            // compare the number of share of assets in both portfolio and benchmark
            if (portAsset.getName().compareTo(benchAsset.getName()) == 0) {
                if (portAsset.getShare() < benchAsset.getShare()) { // less than expected
                    buyList.add("BUY," + portAsset.getName() + "," + portAsset.getType() + ","
                            + (benchAsset.getShare() - portAsset.getShare()));
                } else if (portAsset.getShare() > benchAsset.getShare()) { // more than expected
                    sellList.add("SELL," + portAsset.getName() + "," + portAsset.getType() + ","
                            + (portAsset.getShare() - benchAsset.getShare()));
                }
                portIndex++;
                benchIndex++;
            }
            // this asset is in portfolio, but not in benchmark
            else if (portAsset.getName().compareTo(benchAsset.getName()) < 0) {
                sellList.add("SELL," + portAsset.getName() + "," + portAsset.getType() + ","
                        + portAsset.getShare());
                portIndex++;
            }
            // the asset in benchmark is not in portfolio
            else if (portAsset.getName().compareTo(benchAsset.getName()) > 0) {
                buyList.add("BUY," + benchAsset.getName() + "," + benchAsset.getType() + ","
                        + benchAsset.getShare());
                benchIndex++;
            }
        }
    }

    public static void matchBenchmark(String input) {
        splitPortBench(input);
        Collections.sort(portBond);
        Collections.sort(portStock);
        Collections.sort(benchBond);
        Collections.sort(benchStock);
        comparePortBench(portBond, benchBond);
        comparePortBench(portStock, benchStock);
        if (sellList.size() > 0) {
            for (int j = 0; j < sellList.size(); j++)
                System.out.println(sellList.get(j));
        }
        if (buyList.size() > 0) {
            for (int j = 0; j < buyList.size(); j++)
                System.out.println(buyList.get(j));
        }
    }

    /**
     * check if this asset is a stock
     *
     * @param input
     * @return
     */
    public static boolean isStock(String input) {
        if (input.toLowerCase().contains("stock"))
            return true;
        return false;
    }

    /**
     * check if this asset is a bond
     *
     * @param input
     * @return
     */
    public static boolean isBond(String input) {
        if (input.toLowerCase().contains("bond"))
            return true;
        return false;
    }
}