public class StringArray implements java.io.Serializable {
	public static final long serialVersionUID = 42L;

	public static final int DEFAULT_CAPACITY = 10;

	protected java.lang.String[] _strings = null;

	protected int _upperBound = 0;

	protected int _capacity = com.bwssystems.HABridge.util.StringArray.DEFAULT_CAPACITY;

	protected int _initialSize = _capacity;

	protected float _loadFactory = 1.5F;

	public StringArray() {
		this(com.bwssystems.HABridge.util.StringArray.DEFAULT_CAPACITY);
	}

	public StringArray(int size) {
		_capacity = size;
		_initialSize = size;
		_strings = new java.lang.String[size];
	}

	public synchronized void ensureCapacity(int capacity) {
		if (_capacity < capacity) {
			_capacity = ((_capacity * 3) / 2) + 1;
			if (_capacity < capacity) {
				_capacity = capacity;
			}
			java.lang.String[] oldData = _strings;
			_strings = new java.lang.String[_capacity];
			java.lang.System.arraycopy(oldData, 0, _strings, 0, _upperBound);
		}
	}

	public synchronized void add(java.lang.String s) {
		if (_upperBound == _capacity) {
			resize(((int) (_capacity * _loadFactory)));
		}
		_strings[_upperBound++] = s;
	}

	public synchronized void add(com.bwssystems.HABridge.util.StringArray sa) {
		for (int i = 0; i < sa.size(); i++) {
			add(sa.get(i));
		}
	}

	public synchronized java.lang.String get(int index) {
		return _strings[index];
	}

	public synchronized void set(int index, java.lang.String newVal) {
		_strings[index] = newVal;
	}

	public synchronized void add(java.lang.String[] strs) {
		for (int i = 0; i < strs.length; i++) {
			add(strs[i]);
		}
	}

	public synchronized void clear() {
		_capacity = _initialSize;
		_strings = new java.lang.String[_capacity];
		_upperBound = 0;
	}

	public synchronized java.lang.String remove(int index) {
		if (index >= _upperBound) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		java.lang.String s = _strings[index];
		for (int i = index; i < (_upperBound - 1); i++) {
			_strings[i] = _strings[i + 1];
		}
		_upperBound--;
		return s;
	}

	public synchronized java.lang.String remove(java.lang.String str) {
		for (int i = 0; i < _upperBound; i++) {
			if (_strings[i].equals(str)) {
				return remove(i);
			}
		}
		return null;
	}

	public synchronized int size() {
		return _upperBound;
	}

	public synchronized boolean isEmpty() {
		return _upperBound == 0;
	}

	public synchronized java.lang.String[] toArray() {
		java.lang.String[] ret = new java.lang.String[_upperBound];
		for (int i = 0; i < _upperBound; i++) {
			ret[i] = _strings[i];
		}
		return ret;
	}

	protected synchronized void resize(int newCapacity) {
		java.lang.String[] as = new java.lang.String[newCapacity];
		for (int i = 0; i < _strings.length; i++) {
			as[i] = _strings[i];
		}
		_strings = as;
		_capacity = newCapacity;
	}

	public java.lang.String toString() {
		java.lang.StringBuffer buf = new java.lang.StringBuffer();
		for (int i = 0; i < _upperBound; i++) {
			buf.append(_strings[i] + "\n");
		}
		return buf.toString();
	}

	public static void main(java.lang.String[] args) {
		com.bwssystems.HABridge.util.StringArray as = new com.bwssystems.HABridge.util.StringArray();
		java.lang.String[] ss = null;
		ss = as.toArray();
		for (int i = 0; i < 10; i++) {
			as.add("" + i);
		}
		ss = as.toArray();
		for (int i = 0; i < ss.length; i++) {
		}
		as.remove(5);
		ss = as.toArray();
		for (int i = 0; i < ss.length; i++) {
		}
	}
}