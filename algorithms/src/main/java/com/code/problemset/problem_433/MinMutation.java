package com.code.problemset.problem_433;

import java.util.*;

public class MinMutation {

    /**
     * bfs
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String poll = queue.poll();
                if (poll.equals(end)) {
                    return level;
                }
                char[] currArray = poll.toCharArray();
                for (int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for (char c : charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }


    int minCount = Integer.MAX_VALUE;

    /**
     * dfs
     */
    public int minMutationV2(String start, String end, String[] bank) {
        dfs(new HashSet<>(), 0, start, end, bank);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    private void dfs(Set<String> visited, int count, String start, String end, String[] bank) {
        if (start.equals(end)) {
            minCount = Math.min(minCount, count);
            return;
        }
        for (String str : bank) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++) {
                if (start.charAt(i) != str.charAt(i)) {
                    if (++diff > 1) {
                        break;
                    }
                }
            }
            if (diff == 1 && !visited.contains(str)) {
                visited.add(str);
                dfs(visited, count+  1, str, end, bank);
                visited.remove(str);
            }
        }
    }


    public static void main(String[] args) {
        MinMutation minMutation = new MinMutation();
        String start = "AACCGGTT";
        String end = "AACCGCTA";
        String[] bank = new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(minMutation.minMutation(start, end, bank));
    }
}