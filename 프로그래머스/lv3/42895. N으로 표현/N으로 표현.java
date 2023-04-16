import java.util.*;


// 풀이 출처: https://small-stap.tistory.com/65
class Solution {

    public int solution(int N, int number) {
        List<Set<Integer>> depthList = new ArrayList<>();
        
        for(int i = 0; i < 9; i++)
            depthList.add(new HashSet<>());
        
        depthList.get(1).add(N);
        
        
        for(int i = 2; i < 9; i++) {
            Set<Integer> curCases = depthList.get(i);   
            
            for(int j = 1; j <= i ; j++) {
                Set<Integer> preSet = depthList.get(j);
		        Set<Integer> postSet = depthList.get(i - j);
                
                for(int preCase : preSet)
                    for(int postCase : postSet) {
                        curCases.add(preCase + postCase);
                        curCases.add(preCase - postCase);
                        curCases.add(preCase * postCase);
                        
                        if(preCase != 0 && postCase != 0)
                            curCases.add(preCase / postCase);
                    }
            }
            
            curCases.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        for(Set<Integer> numCase : depthList)
            if(numCase.contains(number))
                return depthList.indexOf(numCase);
        
        return -1;
    }
    
}