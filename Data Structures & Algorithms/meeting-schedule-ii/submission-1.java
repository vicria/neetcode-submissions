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
        intervals = intervals.stream()
                .sorted((a,b) -> a.start - b.start)
                .collect(Collectors.toList());
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        for (var cur : intervals) {
            if (!ends.isEmpty() && ends.peek() <= cur.start) {
                ends.poll();
            }
            ends.offer(cur.end);
        }
        return ends.size();
    }
}
