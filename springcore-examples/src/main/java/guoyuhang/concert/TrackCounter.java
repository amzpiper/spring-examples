package guoyuhang.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    @Pointcut("execution(* top.guoyuhang.soundsystem.CompactDisc.playTrack(int))"+
               "&& args(trackNumber)")
    public void trackPlayed(int trackNumber) {}

    /**
     * 在播放前为CompactDisc计数
     * @param trackNumber
     */
    @Before("trackPlayed()")
    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
    }


}
