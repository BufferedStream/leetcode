import java.util.HashMap;
import java.util.Map;

/**
 * @auther zengbo on 2020/4/5
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring1(String s) {
        int length = 0;
        Map map = new HashMap();

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.size() > length) {
                    length = map.size();
                }

                map = new HashMap();
                map.put(s.charAt(i), i);

            } else {
                if(i == s.length() - 1 && map.size() > length) {
                    length = map.size();
                }
                map.put(s.charAt(i), i);
            }
        }

        return length;
    }

    //统计空字符串，" " 1
    public int lengthOfLongestSubstring2(String s) {
        int length = 0;
        Map map = new HashMap();

        if(s.equals(" ")) {
            return 1;
        }

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.size() > length) {
                    length = map.size();
                }

                map = new HashMap();
                map.put(s.charAt(i), i);

            } else {
                map.put(s.charAt(i), i);
                if(i == s.length() - 1 && map.size() > length) {
                    length = map.size();
                }
            }
        }

        return length;
    }

    //输入:"dvdf" 输出:2 预期结果:3
    public int lengthOfLongestSubstring3(String s) {
        int length = 0;
        Map map = new HashMap();
        if(s.equals(" ")) {
            return 1;
        }

        for(int i = 0; i < s.length(); i++) {

            if(map.containsKey(s.charAt(i))) {
                if(map.size() > length) {
                    length = map.size();
                }

                map = new HashMap();
                map.put(s.charAt(i), i);

            } else {
                map.put(s.charAt(i), i);
                if(i == s.length() - 1 && map.size() > length) {
                    length = map.size();
                }
            }
        }

        return length;
    }

    //用时和内存消耗过大
    public int lengthOfLongestSubstring4(String s) {
        int length = 0;
        Map map = new HashMap();
        if(s.equals(" ")) {
            return 1;
        }

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.size() > length) {
                    length = map.size();
                }

                i = (int) map.get(s.charAt(i)) + 1;
                map = new HashMap();
                map.put(s.charAt(i), i);

            } else {
                map.put(s.charAt(i), i);
                if(i == s.length() - 1 && map.size() > length) {
                    length = map.size();
                }
            }
        }

        return length;
    }

    //耗时增加了。。。
    public int lengthOfLongestSubstring5(String s) {
        int length = 0;
        String temp = "";
        if(s.equals(" ")) {
            return 1;
        }

        for(int i = 0; i < s.length(); i++) {
            if(temp.indexOf(s.charAt(i)) > -1) {
                if(temp.length() > length) {
                    length = temp.length();
                }

                i = s.lastIndexOf(temp, i - 1) + 1;
                temp = "";
                temp += s.charAt(i);

            } else {
                temp += s.charAt(i);
                if(i == s.length() - 1 && temp.length() > length) {
                    length = temp.length();
                }
            }
        }

        return length;
    }
}
