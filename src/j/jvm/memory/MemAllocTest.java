package j.jvm.memory;

/**
 * Created by j on 2017/7/7.
 */
public class MemAllocTest {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM 参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     * -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     *
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = null;//new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        MemAllocTest.testAllocation();
    }
}
