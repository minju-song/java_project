package co.yedam.sang;

public class Dictionary extends PairMap{
	int idx = 0;
	
	public Dictionary(int n) {
		super.keyArray = new String[n];
		super.valueArray = new String[n];
	}

	@Override
	String get(String key) {
		for(int i=0; i<idx; i++) {
			if(key.equals(super.keyArray[i])) {
				return super.valueArray[i];
			}
		}
		return null;
	}

	@Override
	void put(String key, String value) {
		boolean ck = false;
		for(int i=0; i<idx; i++) {
			if(key.equals(super.keyArray[i])) {
				super.valueArray[i] = value;
				ck = true;
			}
		}
		if(ck == false) {			
			super.keyArray[idx] = key;
			super.valueArray[idx] = value;
			idx++;
		}
	}

	@Override
	String delete(String key) {
		for(int i=0; i<idx; i++) {
			if(key.equals(super.keyArray[i])) {
				String result = super.valueArray[i];
				super.valueArray[i] = null; 
				return result;
			}
		}
		return null;
	}

	@Override
	int length() {
		return idx;
	}

}
