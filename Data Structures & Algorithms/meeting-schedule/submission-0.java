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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()){
            return true;
        }
        intervals = intervals.stream()
                .sorted((a,b) -> a.start - b.start)
                .collect(Collectors.toList());
        int lastTime = intervals.get(0).end;
        for(int i=1; i<intervals.size(); i++){
            if (lastTime > intervals.get(i).start){
                return false;
            }
            lastTime = intervals.get(i).end;
        }
        return true;
    }
}
