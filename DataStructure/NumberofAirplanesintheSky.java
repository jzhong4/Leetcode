/*
 Author:     Junjie
 Date:       Aug 19, 2017
 Problem:    Number of Airplanes in the Sky
 Difficulty: Medium
 Source:     http://www.lintcode.com/en/problem/number-of-airplanes-in-the-sky/
 Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?
 Notice
 If landing and flying happens at the same time, we consider landing should happen at first.
 Example
 For interval list
 [
 [1,10],
 [2,3],
 [5,8],
 [4,7]
 ]
 Return 3 
 Solution: sweeping line, 扫描线，拆分数组。 定义一个点类，记时间和起飞/下降状态，用int(0/1）表示状态，容易比较。（注意相等情况下，降落时间在前）
*/
class Point{
    int time;
    int flag;
    
    public Point(int time, int flag){
        this.time = time;
        this.flag = flag;
        
    }
}

class PointComparator implements Comparator<Point>{
    public int compare(Point p1, Point p2){
        if(p1.time == p2.time){
            return p1.flag - p2.flag;
        }else{
            return p1.time - p2.time;
        }
    }
}
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        List<Point> list = new ArrayList<Point>(airplanes.size() * 2);
        for(Interval i : airplanes){
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }
        
        Collections.sort(list, new PointComparator());
        int maxNum = 0, count = 0;
        for(Point p : list){
            if(p.flag == 1) count++;
            else count--;
            maxNum = Math.max(maxNum, count);
        }
        return maxNum;
    }
}