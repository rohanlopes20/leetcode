package com.leetcode;

public class MeetingConflict {
    public static void main(String[] args) {
        System.out.println(new MeetingConflict().haveConflict(new String[] {"01:15","02:00"}, new String[] {"02:00","03:00"}));
        System.out.println(new MeetingConflict().haveConflict(new String[] {"01:00","02:00"}, new String[] {"01:20","03:00"}));
        System.out.println(new MeetingConflict().haveConflict(new String[] {"10:00","11:00"}, new String[] {"14:00","15:00"}));
        System.out.println(new MeetingConflict().haveConflict(new String[] {"10:00","11:00"}, new String[] {"10:00","11:00"}));
    }

    public boolean haveConflict(String[] event1, String[] event2) {

        int event1StartMins = timeToMins(event1[0]);
        int event1EndMins = timeToMins(event1[1]);

        int event2StartMins = timeToMins(event2[0]);
        int event2EndMins = timeToMins(event2[1]);

        if(event1StartMins <= event2StartMins) {
            return  (event1EndMins >= event2StartMins);
        }

        if(event1StartMins >= event2StartMins) {
            return  (event2EndMins >= event1StartMins);
        }

        return false;
    }

    private int timeToMins(String time) {
        int ans = 0 ;

        String hr = time.split(":")[0];
        String min = time.split(":")[1];

        ans = Integer.parseInt(hr) * 60 + Integer.parseInt(min);

        return ans;
    }
}
