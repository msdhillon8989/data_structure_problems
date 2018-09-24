package interview_bit.Array;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/merge-intervals/
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 * <p>
 * Example 2:
 * <p>
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * Make sure the returned intervals are also sorted.
 */
public class MergeInterval {
    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(4, 7));
        list.add(new Interval(10, 13));
        list.add(new Interval(16, 19));
        list.add(new Interval(22, 25));
        list.add(new Interval(28, 31));
        ArrayList<Interval> newList = new MergeInterval().insert1(list, new Interval(2, 22));

        for (Interval intter : newList) {
            System.out.println(intter);
        }

    }

    public ArrayList<Interval> insert1(ArrayList<Interval> intervals, Interval newInterval) {


        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();

        boolean startInserted = false;
        boolean endInserted = false;

        for (Interval entry : intervals) {
            if (!startInserted) {
                if (newInterval.start <= entry.start) {
                    start.add(newInterval.start);
                    startInserted = true;
                }
            }
            start.add(entry.start);

            if (!endInserted) {
                if (newInterval.end <= entry.end) {
                    end.add(newInterval.end);
                    endInserted = true;
                }
            }
            end.add(entry.end);
        }

        if(!startInserted)
        {
            start.add(newInterval.start);
        }
        if(!endInserted)
        {
            end.add(newInterval.end);
        }


        intervals.clear();

        intervals.add(new Interval(start.get(0),end.get(0)));

        for(int i=1;i<start.size();i++)
        {

            if(intervals.get(intervals.size()-1).end>=start.get(i))
            {
                intervals.get(intervals.size()-1).end = end.get(i);
            }
            else {
                intervals.add(new Interval(start.get(i),end.get(i)));
            }
        }


        return intervals;

    }


    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        int minIndex = getIndex(intervals, newInterval.start);
        int maxIndex = getIndex(intervals, newInterval.end);

        if (minIndex == -1 && maxIndex == -1) {
            insertWithoutMerge(intervals, newInterval);
        } else if (minIndex == -1) {
            intervals.get(maxIndex).start = newInterval.start;
            int previousIndex = getPreviousInterval(intervals, newInterval);
            intervals.set(previousIndex + 1, intervals.get(maxIndex));
            deleteItems(intervals, previousIndex + 1, maxIndex);


        } else if (maxIndex == -1) {
            intervals.get(minIndex).end = newInterval.end;

            int endIndex = getPreviousInterval(intervals, newInterval);
            deleteItems(intervals, minIndex, endIndex + 1);
        } else {
            intervals.get(minIndex).end = intervals.get(maxIndex).end;

            deleteItems(intervals, minIndex, maxIndex);


        }

        return intervals;
    }

    private void deleteItems(ArrayList<Interval> intervals, int startIndex, int endIndex) {
        int itemsToDelete = endIndex - startIndex;

        int deleteIndex = startIndex + 1;

        while (itemsToDelete-- > 0) {
            intervals.remove(deleteIndex);
        }
    }


    private void insertWithoutMerge(ArrayList<Interval> intervals, Interval i) {
        int indexToInsert = getPreviousInterval(intervals, i);
        if (indexToInsert == -1) {
            indexToInsert = 0;
        }
        intervals.add(indexToInsert, i);
    }

    int getPreviousInterval(ArrayList<Interval> intervals, Interval i) {
        int start = 0;
        int end = intervals.size() - 1;
        boolean startChanged = true;
        while (end >= start) {
            int mid = start + ((end - start) / 2);
            Interval interval = intervals.get(mid);
            if (interval.start > i.end) {
                end = mid - 1;
                startChanged = false;
            } else if (interval.end < i.start) {
                start = mid + 1;
                startChanged = true;
            }
        }

        int previousInterval = 0;
        if (startChanged) {
            previousInterval = start;
        } else {
            previousInterval = end;
        }

        return previousInterval;
    }


    int getIndex(ArrayList<Interval> intervals, int i) {
        int start = 0;
        int end = intervals.size() - 1;
        while (end >= start) {
            int mid = start + end - start / 2;
            Interval interval = intervals.get(mid);
            if (interval.start <= i && interval.end >= i) {
                return mid;
            } else if (interval.start > i) {
                end = mid - 1;
            } else if (interval.end < i) {
                start = mid + 1;
            }
        }
        return -1;

    }


}


class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return start + " " + end;
    }
}
