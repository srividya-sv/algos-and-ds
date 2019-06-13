class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        
        Map<String, List<String>> hmap = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        
        for(String s: strings) {
            StringBuilder sb = new StringBuilder();
    
            char[] arr = s.toCharArray(); 
            int len = s.length();
            
            int offset = arr[0] - 'a'; 
            for(int i = 0; i < len; i++) {
                arr[i] -= offset;
                if(arr[i] < 'a') 
                    arr[i] += 26;
                
                if(arr[i] > 'z') 
                    arr[i] -= 26;
                
                sb.append(arr[i]);
            }
            String keyString = sb.toString(); 
            if (!hmap.containsKey(keyString)) {
                hmap.put(keyString, new ArrayList<String>());
            }
            hmap.get(keyString).add(s);
        }
        
        for(Map.Entry<String, List<String>> e: hmap.entrySet()) {
            res.add(e.getValue());
        }
        
        return res;
        
    }
}
