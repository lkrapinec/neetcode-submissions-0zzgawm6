/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        for(Interval interval : intervals){
            starts.add(interval.start);
            ends.add(interval.end);
        }

        Collections.sort(starts);
        Collections.sort(ends);

        int pointer1 = 0;
        int pointer2 = 0;

        int result = 0;
        int counter = 0;
        while(pointer1 < starts.size() ){
            if(starts.get(pointer1) < ends.get(pointer2)){
                counter++;
                pointer1++;
                result = Math.max(result, counter);
            }else{
                counter--;
                pointer2++;
            }
        }

        return result;
    }
}
