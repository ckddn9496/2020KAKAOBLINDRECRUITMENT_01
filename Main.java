/* KAKAO 2020 신입 개발자 블라인드 채용
 * 1번
 * */
public class Main {

	public static void main(String[] args) {
		String s = "aabbaccc"; // return 7
//		String s = "ababcdcdababcdcd"; // return 9
//		String s = "abcabcdede"; // return 8
//		String s = "abcabcabcabcdededededede"; // return 14
//		String s = "xababcdcdababcdcd"; // return 17
		
		
		System.out.println(new Solution().solution(s));
	}
}

class Solution {
    public int solution(String s) {
    	int min = s.length();
        
        int len = s.length();
        
        for (int size = 1; size <= s.length()/2; size++) { // size 압축개수
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            int answer = 0;
            // s에대해 압축크기 size로 검사
//            System.out.println("size : " + size);
            while (idx + size - 1< len) {
                int count = 1;
            	String com = s.substring(idx, idx+size);
            	idx += size;
            	while (idx + size - 1< len && s.substring(idx, idx+size).equals(com)) {
            		idx += size;
            		count++;
            	}

            	if (count == 1) {
//            		System.out.println("string : " + com + "  count :" + count);
            		answer += size;
            	}
            	else {
//            		System.out.println("string : " + com + "  count :" + count);
            		answer += size + Integer.toString(count).length();
            	}
            }
//            System.out.println("after loop:" + answer);
//            System.out.println("len, idx : " + len + ", "  + idx);
            answer += (len - idx);
            if (min > answer)
            	min = answer;
//            System.out.println("min " + min);
//            System.out.println();
        }
        
        return min;
    }
}