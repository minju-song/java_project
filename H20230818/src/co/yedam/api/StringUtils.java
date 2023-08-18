package co.yedam.api;

public class StringUtils {
	static String checkGender(String ssn) {
//		ssn = ssn.replaceAll("-", "");
//		ssn = ssn.replaceAll(" ", "");
		ssn = ssn.replaceAll("[- ]", "");
		if(ssn.length()!=13) return "자리수 오류";
		int s = ssn.charAt(6)-'0';
		if(ssn.charAt(0)=='9') {
			if(s!=1 && s!=2) return "연도 오류";
		}
		else if(ssn.charAt(0)=='0') {
			if(s!=3 && s!=4) return "연도 오류";
		}
		
		String gender="";
		switch(s) {
		case 1:
		case 3:
			gender = "남자";
			break;
		case 2:
		case 4:
			gender = "여자";
			break;
		default:
			return "오류";
		}
		return gender;
	}
	
	static String getFileName(String file) {
		int idx = file.lastIndexOf('/');
		return file.substring(idx+1);
	}
}
