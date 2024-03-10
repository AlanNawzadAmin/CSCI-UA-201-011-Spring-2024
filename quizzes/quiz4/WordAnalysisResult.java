import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// The time complexity is O(N) where N is the length of `list`
// because we go through the list once and go through the
// unique words again (which is less than the length of `list`).
// Inside the for-loop, everything is O(1) (asymptotically).
public class WordAnalysisResult {
    private List<String> uniques;
    private List<Integer> counts, firstSeen;
    public WordAnalysisResult(List<String> list) {
        uniques = new List<>();
        counts = new List<>();
        firstSeen = new List<>();

        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<list.length(); i++) {
            String str = list.get(i);
            if (! map.containsKey(str)) {
                // first seen
                firstSeen.add(i);
                uniques.add(i);
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }

        for (String str : uniques) {
            counts.add(map.get(str));
        }
    }
}
