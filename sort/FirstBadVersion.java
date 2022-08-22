package test.sort;
import java.util.*;

abstract class VersionControl{
    abstract boolean isBadVersion(int version);
}
public class FirstBadVersion extends VersionControl{
    public static void main(String[] args){
        FirstBadVersion obj = new FirstBadVersion();
        int res = obj.firstBadVersion(5);
        System.out.println(res);
    }
    public int firstBadVersion(int n) {
        int low = 0, high = n;        
        while(low <= high){
            int mid = low + (high - low) / 2;            
            if(isBadVersion(mid)){                
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public int firstBadVersionOld(int n) {
        for(int i = 0 ; i < n ; i++){
            if(isBadVersion(i) == true)
                return i;
        }
        return n;
    }
    public boolean isBadVersion(int version){
        if(version == 4) return true;
        else return false;
    }
}