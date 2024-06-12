public class Base62 {
	private static final int STANDARD_BASE = 256;

	private static final int TARGET_BASE = 62;

	private final byte[] alphabet;

	private byte[] lookup;

	private Base62(final byte[] alphabet) {
		this.alphabet = alphabet;
		createLookupTable();
	}

	public static Base.Other.Base62 createInstance() {
		return Base.Other.Base62.createInstanceWithGmpCharacterSet();
	}

	public static Base.Other.Base62 createInstanceWithGmpCharacterSet() {
		return new Base.Other.Base62(Base.Other.Base62.CharacterSets.GMP);
	}

	public static Base.Other.Base62 createInstanceWithInvertedCharacterSet() {
		return new Base.Other.Base62(Base.Other.Base62.CharacterSets.INVERTED);
	}

	public byte[] encode(final byte[] message) {
		final byte[] indices = convert(message, Base.Other.Base62.STANDARD_BASE, Base.Other.Base62.TARGET_BASE);
		return translate(indices, alphabet);
	}

	public byte[] decode(final byte[] encoded) {
		if (!isBase62Encoding(encoded)) {
			throw new java.lang.IllegalArgumentException("Input is not encoded correctly");
		}
		final byte[] prepared = translate(encoded, lookup);
		return convert(prepared, Base.Other.Base62.TARGET_BASE, Base.Other.Base62.STANDARD_BASE);
	}

	public boolean isBase62Encoding(final byte[] bytes) {
		if (bytes == null) {
			return false;
		}
		for (final byte e : bytes) {
			if (('0' > e) || ('9' < e)) {
				if (('a' > e) || ('z' < e)) {
					if (('A' > e) || ('Z' < e)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private byte[] translate(final byte[] indices, final byte[] dictionary) {
		final byte[] translation = new byte[indices.length];
		for (int i = 0; i < indices.length; i++) {
			translation[i] = dictionary[indices[i]];
		}
		return translation;
	}

	private byte[] convert(final byte[] message, final int sourceBase, final int targetBase) {
		final int estimatedLength = estimateOutputLength(message.length, sourceBase, targetBase);
		final java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream(estimatedLength);
		byte[] source = message;
		while (source.length > 0) {
			final java.io.ByteArrayOutputStream quotient = new java.io.ByteArrayOutputStream(source.length);
			int remainder = 0;
			for (int i = 0; i < source.length; i++) {
				final int accumulator = (source[i] & 0xff) + (remainder * sourceBase);
				final int digit = (accumulator - (accumulator % targetBase)) / targetBase;
				remainder = accumulator % targetBase;
				if ((quotient.size() > 0) || (digit > 0)) {
					quotient.write(digit);
				}
			}
			out.write(remainder);
			source = quotient.toByteArray();
		} 
		for (int i = 0; (i < (message.length - 1)) && (message[i] == 0); i++) {
			out.write(0);
		}
		return reverse(out.toByteArray());
	}

	private int estimateOutputLength(int inputLength, int sourceBase, int targetBase) {
		return ((int) (java.lang.Math.ceil((java.lang.Math.log(sourceBase) / java.lang.Math.log(targetBase)) * inputLength)));
	}

	private byte[] reverse(final byte[] arr) {
		final int length = arr.length;
		final byte[] reversed = new byte[length];
		for (int i = 0; i < length; i++) {
			reversed[(length - i) - 1] = arr[i];
		}
		return reversed;
	}

	private void createLookupTable() {
		lookup = new byte[256];
		for (int i = 0; i < alphabet.length; i++) {
			lookup[alphabet[i]] = ((byte) (i & 0xff));
		}
	}

	private static class CharacterSets {
		private static final byte[] GMP = new byte[]{ ((byte) ('0')), ((byte) ('1')), ((byte) ('2')), ((byte) ('3')), ((byte) ('4')), ((byte) ('5')), ((byte) ('6')), ((byte) ('7')), ((byte) ('8')), ((byte) ('9')), ((byte) ('A')), ((byte) ('B')), ((byte) ('C')), ((byte) ('D')), ((byte) ('E')), ((byte) ('F')), ((byte) ('G')), ((byte) ('H')), ((byte) ('I')), ((byte) ('J')), ((byte) ('K')), ((byte) ('L')), ((byte) ('M')), ((byte) ('N')), ((byte) ('O')), ((byte) ('P')), ((byte) ('Q')), ((byte) ('R')), ((byte) ('S')), ((byte) ('T')), ((byte) ('U')), ((byte) ('V')), ((byte) ('W')), ((byte) ('X')), ((byte) ('Y')), ((byte) ('Z')), ((byte) ('a')), ((byte) ('b')), ((byte) ('c')), ((byte) ('d')), ((byte) ('e')), ((byte) ('f')), ((byte) ('g')), ((byte) ('h')), ((byte) ('i')), ((byte) ('j')), ((byte) ('k')), ((byte) ('l')), ((byte) ('m')), ((byte) ('n')), ((byte) ('o')), ((byte) ('p')), ((byte) ('q')), ((byte) ('r')), ((byte) ('s')), ((byte) ('t')), ((byte) ('u')), ((byte) ('v')), ((byte) ('w')), ((byte) ('x')), ((byte) ('y')), ((byte) ('z')) };

		private static final byte[] INVERTED = new byte[]{ ((byte) ('0')), ((byte) ('1')), ((byte) ('2')), ((byte) ('3')), ((byte) ('4')), ((byte) ('5')), ((byte) ('6')), ((byte) ('7')), ((byte) ('8')), ((byte) ('9')), ((byte) ('a')), ((byte) ('b')), ((byte) ('c')), ((byte) ('d')), ((byte) ('e')), ((byte) ('f')), ((byte) ('g')), ((byte) ('h')), ((byte) ('i')), ((byte) ('j')), ((byte) ('k')), ((byte) ('l')), ((byte) ('m')), ((byte) ('n')), ((byte) ('o')), ((byte) ('p')), ((byte) ('q')), ((byte) ('r')), ((byte) ('s')), ((byte) ('t')), ((byte) ('u')), ((byte) ('v')), ((byte) ('w')), ((byte) ('x')), ((byte) ('y')), ((byte) ('z')), ((byte) ('A')), ((byte) ('B')), ((byte) ('C')), ((byte) ('D')), ((byte) ('E')), ((byte) ('F')), ((byte) ('G')), ((byte) ('H')), ((byte) ('I')), ((byte) ('J')), ((byte) ('K')), ((byte) ('L')), ((byte) ('M')), ((byte) ('N')), ((byte) ('O')), ((byte) ('P')), ((byte) ('Q')), ((byte) ('R')), ((byte) ('S')), ((byte) ('T')), ((byte) ('U')), ((byte) ('V')), ((byte) ('W')), ((byte) ('X')), ((byte) ('Y')), ((byte) ('Z')) };
	}

	public static void main(java.lang.String[] args) {
		Base.Other.Base62 base62 = Base.Other.Base62.createInstance();
		java.lang.System.out.println(new java.lang.String(base62.encode("hello".getBytes(java.nio.charset.StandardCharsets.UTF_8))));
	}
}