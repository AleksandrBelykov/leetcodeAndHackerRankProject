package firstBadVersion;

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */
public class Solution {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(firstBadVersion(6));
        System.out.println(firstBadVersion2(6));

    }

    //returns -1 if there is no any bad version found
    public static int firstBadVersion(int n) {
        return binarySearch(1, n);
    }

    private static int binarySearch(int from, int to){
        int mid = (from+to)/2;

        if (mid == 1){
            return isBadVersionDummy(mid) ? 1 : (isBadVersionDummy(2) ? 2 : -1);
        }
        if (from == to) {
            return isBadVersionDummy(mid) ? mid : -1;
        }
        if (isBadVersionDummy(mid)){
            return binarySearch(from, mid);
        }
        if (!isBadVersionDummy(mid)){
            return binarySearch(mid+1, to);
        }

        return -1;
    }


    //------------------------------------------------------------------------------------------------

    //returns the last version (actually, returns n) if there is no any bad version found
    public static int firstBadVersion2(int n) {
        int left = 1;
        int right = n;
        while (left < right){
            int mid = left + (right - left)/ 2;
            if (isBadVersionDummy(mid))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    //------------------------------------------------------------------------------------------------



    private static boolean isBadVersionDummy(int version){
        boolean result;
        switch (version){
            case 1: result = false;
                break;
            case 2: result = false;
                break;
            case 3: result = false;
                break;
            case 4: result = false;
                break;
            case 5: result = false;
                break;
            case 6: result = false;
                break;
            case 7: result = true;
                break;
            case 8: result = true;
                break;
            case 9: result = true;
                break;
            case 10: result = true;
                break;
            case 11: result = true;
                break;
            case 12: result = true;
                break;
            default: result = true;
                break;
        }
        return result;
    }
}
