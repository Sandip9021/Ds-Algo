package dfsBackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesses {
	private char[] chars = { '(', ')' };
	private List<String> result = new ArrayList<>();
	private StringBuilder builder = new StringBuilder();
	private int max;

	public static void main(String[] args) {
		GenerateParenthesses gp = new GenerateParenthesses();
		List<String> li = gp.generateParenthesis(3);
		for (String s : li) {
			System.out.println(s);
		}
	}

	public List<String> generateParenthesis(int n) {
		max = n;
		backtracking(0, 0);
		return result;
	}

	private void backtracking(int open, int close) {
		if (isStringFormed())
			return;

		for (char c : chars) {
			if (isValid(c, open, close)) {
				builder.append(c);
				backtracking(c == '(' ? open + 1 : open, c == ')' ? close + 1 : close);
				builder.deleteCharAt(builder.length() - 1);
			}
		}
	}

	private boolean isStringFormed() {
		if (builder.length() == max * 2) {
			result.add(builder.toString());
			return true;
		}
		return false;
	}

	private boolean isValid(char c, int open, int close) {
		if (open == max && c == '(')
			return false;
		if (close == max && c == ')')
			return false;
		if (open == close && c == ')')
			return false;
		return true;
	}
}
