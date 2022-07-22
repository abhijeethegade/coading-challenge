import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistOfChar {

	public static void main(String[] args) {

		final String input = "abcdxyd";
		char specificChar = 'd';

		int[] result = new int[input.length()];

		solution(result, input, specificChar);

		System.out.print("result ");
		for (int i = 0; i < result.length; i++) {
			System.out.print(" " + result[i]);
		}

	}

	public static void solution(int[] result, String input, char specificChar) {

		List<Integer> occuranceList = new ArrayList<>();

		//find the specific character indexes in string
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == specificChar) {
				occuranceList.add(i);
			}
		}
		//no occurrence of given character in string, fill output with -1 for all places
        if (occuranceList.size() == 0) {
            Arrays.fill(result, -1);
            return;
        }
		int occuranceCounter = 0;
		int prevNearestOccurance = occuranceList.get(occuranceCounter);
		int nextNearestOccurance = occuranceList.get(occuranceCounter);
		//Calculate distance and check if prev occurrence is nearer or next
		for (int i = 0; i < input.length(); i++) {

			int distFromPrevOccurance = Math.abs(prevNearestOccurance - i);
			int distFromNextOccurance = Math.abs(nextNearestOccurance - i);
			if (distFromPrevOccurance < distFromNextOccurance) {
				result[i] = distFromPrevOccurance;
			} else {
				result[i] = distFromNextOccurance;
				prevNearestOccurance = nextNearestOccurance;
				if (++occuranceCounter < occuranceList.size()) {

					nextNearestOccurance = occuranceList.get(occuranceCounter);
				}
			}

		}
	}

}
