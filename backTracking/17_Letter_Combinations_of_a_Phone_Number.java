class Solution {
    Map<String, String> phone = new HashMap<String, String>() 
    {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) { return new ArrayList<>(); }
        List<String> result = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        letterCombinationsHelper(digits, result, str, 0);
        return result;
    }
    private void letterCombinationsHelper(String digits, List<String> result, StringBuilder str, int pos) {
        if (str.length() == digits.length()) {
            result.add(str.toString());
        } else {
            for (int i = pos; i < digits.length(); i++) {
                for(int j = 0; j < phone.get(String.valueOf(digits.charAt(i))).length(); j++) {
                    str.append(phone.get(String.valueOf(digits.charAt(i))).charAt(j));
                    letterCombinationsHelper(digits, result, str, i + 1);
                    str.delete(str.length() - 1, str.length());
                }
            }
        }
    }
}
