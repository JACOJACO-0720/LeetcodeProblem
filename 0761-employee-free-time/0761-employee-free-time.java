

import static java.util.Collections.frequency;

/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res  = new ArrayList<>();
        List<Interval> flat = new ArrayList<>();
        for (int i = 0; i < schedule.size(); i++) {
            for (int j = 0; j < schedule.get(i).size(); j++) {
                flat.add(schedule.get(i).get(j));
            }
        }
        Collections.sort(flat,  (n1,n2) -> (n1.start - n2.start) );

        if(flat.isEmpty()){
            return null;
        }
        int curstart; int curend = flat.get(0).end;

        for (int i = 1; i < flat.size(); i++) {
            Interval tmpInterval = flat.get(i);
            if(tmpInterval.start>curend){
                res.add(new Interval(curend, tmpInterval.start));
                curstart = tmpInterval.start;
                curend = tmpInterval.end;
            }else{
                curend = Math.max(curend, tmpInterval.end);
            }
        }
        return res;

    }
}