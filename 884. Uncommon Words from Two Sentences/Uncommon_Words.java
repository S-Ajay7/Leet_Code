class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        ArrayList<String> al = new ArrayList<>();
        al.addAll(Arrays.asList(s1.split(" ")));
        al.addAll(Arrays.asList(s2.split(" ")));
        int start = 0;
        int end = start + 1;
        Collections.sort(al);
        int len = al.size();
        while (end < len) {
            if (al.get(start).equals(al.get(end))) {
                while (end < len && al.get(start).equals(al.get(end))) {
                    end++;
                }
                for (int i = end - 1; i >= start; i--) {
                    al.remove(i);
                }
                start = 0;
                end = start + 1;
                len = al.size();
            } else {
                start++;
                end = start + 1;
            }
        }
        String[] res = new String[al.size()];
        int k = 0;
        for (String data : al) {
            res[k++] = data;
        }
        return res;
    }
}