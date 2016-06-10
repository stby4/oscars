package ch.fhnw.oop.oscar.model;

/**
 * Calculate LevenshteinDistance
 */
public class LevenshteinDistance {

    /**
     * get Levensthein Distance between lhs and rhs
     *
     * @param lhs
     * @param rhs
     * @return levenshtein distance
     * @link https://en.wikibooks.org/wiki/Algorithm_Implementation/Strings/Levenshtein_distance#Java
     */
    public static int getDistance(CharSequence lhs, CharSequence rhs) {
        int len0 = lhs.length() + 1;
        int len1 = rhs.length() + 1;

        // the array of distances
        int[] cost = new int[len0];
        int[] newcost = new int[len0];

        // initial cost of skipping prefix in String s0
        for (int i = 0; i < len0; i++) cost[i] = i;

        // dynamically computing the array of distances

        // transformation cost for each letter in s1
        for (int j = 1; j < len1; j++) {
            // initial cost of skipping prefix in String s1
            newcost[0] = j;

            // transformation cost for each letter in s0
            for (int i = 1; i < len0; i++) {
                // matching current letters in both strings
                int match = (lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1;

                // computing cost for each transformation
                int cost_replace = cost[i - 1] + match;
                int cost_insert = cost[i] + 1;
                int cost_delete = newcost[i - 1] + 1;

                // keep minimum cost
                newcost[i] = Math.min(Math.min(cost_insert, cost_delete), cost_replace);
            }

            // swap cost/newcost arrays
            int[] swap = cost;
            cost = newcost;
            newcost = swap;
        }

        // the distance is the cost for transforming all letters in both strings
        return cost[len0 - 1];
    }

    /**
     * get match independent of string length
     * @link http://stackoverflow.com/questions/955110/similarity-string-comparison-in-java/16018452#16018452
     *
     * @param query
     * @param comperator
     * @return
     */
    public static double getSimilarity(CharSequence query, CharSequence comperator) {
        CharSequence comperatorShort = comperator.subSequence(0, Math.min(query.length(), comperator.length()));

        int longerLength = Math.max(comperatorShort.length(), query.length());
        if (longerLength == 0) {
            return 1.0; /* both strings are zero length */
        }
        return (longerLength - getDistance(query, comperatorShort)) / (double) longerLength;
    }
}
