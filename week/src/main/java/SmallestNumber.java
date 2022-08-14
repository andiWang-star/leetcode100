public class SmallestNumber {
    // LeetCode 6150题 根据模式串构造最小数字 https://leetcode.cn/problems/construct-smallest-number-from-di-string/
    /**
     * 贪心策略：
     *
     * 把 pattern按照III⋯IDDD⋯D 分组，每组前一段是I ，后一段是 D。
     *
     * 遍历每一段，设当前段的长度为 x，我们应该把剩余最小的 x 个数字填到该段上（如果是第一段则填最小的 x+1 个数字），从而保证字典序最小。
     *
     * 举例说明，假如第一段为 IIIDDD，构造方案如下：
     *
     * 前 2 个 I 视作长度为 3 的上升段；
     * 剩余的 I 和 D 视作长度为 4 的下降段；
     * 最小的 3 个数给上升段，然后剩余最小的 4 个数给下降段；
     * 构造结果为 1237654。
     * 按照该方案分组模拟即可。
     * */

    public String smallestNumber(String pattern) {
        int i = 0, n = pattern.length();
        char cnt='1';
        char[] ans = new char[n+1];
        while (i < n) {
            if (i > 0 && pattern.charAt(i) == 'I') {
                i++;
            }
            while (i < n && pattern.charAt(i) == 'I'){
                ans[i] = cnt++;
                i++;
            }
            int io = i;
            while (i < n && pattern.charAt(i) == 'D') {
                i++;
            }
            for (int j = i; j >= io; j--){
                ans[j] = cnt++;
            }
        }

        return new String(ans);
    }
}
