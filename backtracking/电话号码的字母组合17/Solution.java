package backtracking.电话号码的字母组合17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 电话号码的每一位数字都对应一组字母，本质是在多组字母中各选一个，枚举所有组合，适合用回溯。
     * - letterMap 直接用数字下标映射到对应字符串，index 表示当前处理到 digits 的第几位，path 保存当前组合。
     * - 当 index == digits.length() 时，说明每一位都已经选完，把 path 转成字符串加入结果。
     * - 注释掉的代码是我最初的解法，用 HashMap 记录每个数字的起始字母，再通过字符偏移生成后续字母；
     *   当前写法把完整字母表直接写在数组里，并用 StringBuilder 做增删，逻辑更清晰，也避免频繁创建新字符串。
     */
    private final String[] letterMap = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }

        StringBuilder path = new StringBuilder();
        backtracking(digits, 0, path, res);
        return res;
    }

    private void backtracking(String digits, int index, StringBuilder path, List<String> res) {
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = letterMap[digit];

        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));

            backtracking(digits, index + 1, path, res);

            path.deleteCharAt(path.length() - 1);
        }
    }
//    public List<String> letterCombinations(String digits) {
//        if (digits == null || digits.length() == 0) return new ArrayList<>();
//        List<String> list = new ArrayList<>();
//        String path = "";
//        HashMap<String, Character> map = new HashMap<>();
//        map.put("2",'a');
//        map.put("3",'d');
//        map.put("4",'g');
//        map.put("5",'j');
//        map.put("6",'m');
//        map.put("7",'p');
//        map.put("8",'t');
//        map.put("9",'w');
//        backtracking(list,digits,0,path,map);
//        return list;
//    }
//    public void backtracking(List<String> list, String digits,int start,String path,HashMap<String, Character> map) {
//        if (path.length() == digits.length()) {
//            list.add(path);
//            return;
//        }
//        char c = digits.charAt(start);
//        int n=3;
//        if(c=='9'||c=='7'){
//            n=4;
//        }
//        c = map.get(String.valueOf(c));
//        for (int i = 0; i < n; i++) {
//            char t= (char) (c+i);
//            path += t;
//            backtracking(list, digits, start + 1,path,map);
//            path = path.substring(0, path.length()-1);
//        }
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.letterCombinations("23");
        System.out.println(list);
    }
}
