package interview_bit.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * https://www.interviewbit.com/problems/merge-overlapping-intervals/
 * Given a collection of intervals, merge all overlapping intervals.

 For example:

 Given [1,3],[2,6],[8,10],[15,18],

 return [1,6],[8,10],[15,18].

 Make sure the returned intervals are sorted.
 */
public class MergeInterval2 {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Comparator<Interval> comparator = Comparator.comparingInt(o -> o.start);
        intervals.sort(comparator);

        ArrayList<Interval> newList = new ArrayList<>();


        newList.add(intervals.get(0));

        for(int i=1;i<intervals.size();i++)
        {
            Interval interval = intervals.get(i);
            Interval lastInterval = newList.get(newList.size()-1);

            if(lastInterval.end>interval.start)
            {
                if(interval.end > lastInterval.end)
                lastInterval.end = interval.end;
            }
            else {
                newList.add(interval);
            }

        }
        return newList;

}

    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(4, 7));
        list.add(new Interval(10, 13));
        list.add(new Interval(16, 19));
        list.add(new Interval(5, 29));
        list.add(new Interval(28, 31));
        ArrayList<Interval> newList = new MergeInterval2().merge(list);
        for (Interval intter : newList) {
            System.out.println(intter);
        }
    }
}
