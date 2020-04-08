import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    //耗时增加了，在for循环内部使用 + 来拼接string会额外消耗性能
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

    //比上一个性能有改善，但不如使用hashmap
    public int lengthOfLongestSubstring6(String s) {
        int length = 0;
        StringBuilder temp = new StringBuilder();
        if(s.equals(" ")) {
            return 1;
        }

        for(int i = 0; i < s.length(); i++) {
            if(temp.indexOf(String.valueOf(s.charAt(i))) > -1) {
                if(temp.length() > length) {
                    length = temp.length();
                }

                i = s.lastIndexOf(String.valueOf(temp), i - 1) + 1;
                temp = new StringBuilder();
                temp.append(s.charAt(i));

            } else {
                temp.append(s.charAt(i));
                if(i == s.length() - 1 && temp.length() > length) {
                    length = temp.length();
                }
            }
        }

        return length;
    }

    //Math.max没有优化效果
    public int lengthOfLongestSubstring7(String s) {
        int length = 0;
        Map map = new HashMap();
        if(s.equals(" ")) {
            return 1;
        }

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                length = Math.max(length, map.size());

                i = (int) map.get(s.charAt(i)) + 1;
                map = new HashMap();
                map.put(s.charAt(i), i);

            } else {
                map.put(s.charAt(i), i);
                if(i == s.length() - 1) {
                    length = Math.max(length, map.size());
                }
            }
        }

        return length;
    }

    //运用滑动窗口的概念，针对了前面所使用方法需要重复创建map的缺点进行了优化
    //并不需要重复创建map来临时记录子串的大小，只需要保存两个指针的位置
    public int lengthOfLongestSubstring8(String s) {
        int ans = 0;
        Map map = new HashMap();

        for(int i = 0, j = 0; i < s.length() && j < s.length(); ) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i++), i);
                ans = Math.max(ans, map.size());
            } else {
                map.remove(s.charAt(j++));
            }
        }

        return ans;
    }

    //改成while形式
    public int lengthOfLongestSubstring9(String s) {
        int ans = 0, i = 0, j = 0;
        int length = s.length();
        Map map = new HashMap();

        while(i < length && j < length) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i++), i);
                ans = Math.max(ans, map.size());
            } else {
                map.remove(s.charAt(j++));
            }
        }

        return ans;
    }

    //使用hashset
    public int lengthOfLongestSubstring10(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //优化滑动窗口的跳跃
    public int lengthOfLongestSubstring11(String s) {
        int ans = 0;
        int length = s.length();
        Map<Character, Integer> map = new HashMap();

        for(int i = 0, j = 0; j < length; j++ ) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return ans;
    }

    //用泛型优化，没什么用
    public int lengthOfLongestSubstring12(String s) {
        int length = 0;
        Map<Character, Integer> map = new HashMap();
        if(s.equals(" ")) {
            return 1;
        }

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.size() > length) {
                    length = map.size();
                }

                i = map.get(s.charAt(i)) + 1;
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

    public int lengthOfLongestSubstring13(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
