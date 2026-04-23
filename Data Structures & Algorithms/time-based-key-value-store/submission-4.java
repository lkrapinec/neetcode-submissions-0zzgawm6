class TimeMap {
    private Map<String, List<List<String>>> timeMap;

    public TimeMap() {
        this.timeMap = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        List<String> timeValue = new ArrayList<>();
        timeValue.add("" + timestamp);
        timeValue.add(value);

        List<List<String>> values = timeMap.get(key);
        if(values == null){
            values = new ArrayList<>();
        }
        values.add(timeValue);


        timeMap.put(key, values);
    }
    
    public String get(String key, int timestamp) {
        List<List<String>> values = timeMap.get(key);

        if(values == null || values.isEmpty()){
            return "";
        }


        int left = 0;
        int right = values.size() - 1;

        String result = "";
        while(left <= right){
            int middle = left + (right - left) / 2;
            
            int currTimestamp = Integer.parseInt(values.get(middle).get(0));
            if(currTimestamp <= timestamp){
                result = values.get(middle).get(1);
                left = middle + 1;
            }else {
                right = middle -1;
            }
        }
        return result;
    }
}











