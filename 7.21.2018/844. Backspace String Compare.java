class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (char s : S.toCharArray()) {
            if (s == '#') {
                if (!stackS.isEmpty()) {
                    stackS.pop();
                }
            }
            else {
                stackS.push(s);
            }
        }
        for (char t : T.toCharArray()) {
            if (t == '#') {
                if (!stackT.isEmpty()) {
                    stackT.pop();
                }
            }
            else {
                stackT.push(t);
            }
        }
        if (stackS.size() != stackT.size()) {
            return false;
        }
        while (!stackS.isEmpty()) {
            if (stackS.pop() != stackT.pop()) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) {
            return false;
        }
        String s = modifyString(S);
        String t = modifyString(T);
        return s.equals(t);
    }
    private String modifyString(String str) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) { // 倒序遍历，可以处理一开始就是#的情况
            char c = str.charAt(i);
            if (c == '#') {
                count++;
            }
            else {
                if (count > 0) {
                    count--;
                }
                else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}