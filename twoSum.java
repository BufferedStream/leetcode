package ninetyNineProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther zengbo on 2020/3/28
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

    示例:

    给定 nums = [2, 7, 11, 15], target = 9

    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
 */
public class twoSum {
    public int[] twoSum1(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }

        return arr;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }

        return arr;
    }

    public int[] twoSum3(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;

                    return arr;
                }
            }
        }

        return arr;
    }

    public int[] twoSum4(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    int[] arr = new int[]{i, j};
                    return arr;
                }
            }
        }

        return null;
    }

    //错了，负数也是整数
    public int[] twoSum5(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] <= target) {
                for(int j = i + 1; j < nums.length; j++) {
                    if(nums[i] + nums[j] == target) {
                        int[] arr = new int[]{i, j};
                        return arr;
                    }
                }
            }
        }

        return null;
    }

    public int[] twoSum6(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    //报错，contains方法只能处理对象，不能处理基本类型
    public int[] twoSum7(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++) {
            int temp = target - nums[i];

            if(Arrays.asList(nums).contains(temp)) {
                return new int[]{i, Arrays.binarySearch(nums, temp)};
            }

        }

        return null;
    }

    //出错，重复使用了数组元素
    public int[] twoSum8(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            map.put(new Integer(i), new Integer(nums[i]));
        }

        for(int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(map.containsValue(temp)) {
                for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if(entry.getValue() == temp) {
                        return new int[]{i, entry.getKey()};
                    }
                }
            }
        }

        return null;
    }

    //报错，数组有重复元素结果时出错，[3,3] 6
    public int[] twoSum9(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            map.put(new Integer(i), new Integer(nums[i]));
        }

        for(int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(map.containsValue(temp)) {
                for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if(entry.getValue() == temp && entry.getValue() != nums[i]) {
                        return new int[]{i, entry.getKey()};
                    }
                }
            }
        }

        return null;
    }

    //运行时间爆炸多
    public int[] twoSum10(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            map.put(new Integer(i), new Integer(nums[i]));
        }

        for(int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(map.containsValue(temp)) {
                for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if(entry.getValue() == temp && i != entry.getKey()) {
                        return new int[]{i, entry.getKey()};
                    }
                }
            }
        }

        return null;
    }

    public int[] twoSum11(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp) && i != map.get(temp)) {
                return new int[]{i, map.get(temp)};
            }
        }

        return null;
    }

    //报错，[3,3] 6 报 null
    public int[] twoSum12(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            int temp = target - nums[i];
            if(map.containsKey(temp) && i != map.get(temp)) {
                return new int[]{i, map.get(temp)};
            }
        }

        return null;
    }

    public int[] twoSum13(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    public int[] twoSum14(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int length = nums.length;

        for(int i = 0; i < length; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    public int[] twoSum15(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return null;
    }

    //耗时增加了，leetcode的编译程序不稳定，应该是能减少耗时的
    public int[] twoSum16(int[] nums, int target) {
        int length = nums.length;
        for(int i = 0; i < length - 1; i++) {
            for(int j = i + 1; j < length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 4};
        int target = 6;


        int[] result = new twoSum().twoSum8(nums, target);

        System.out.println(result);

        Map map = new HashMap();

        map.put(1, 2);
        map.put(1, 3);

        System.out.println(map.get(1));
    }
}
