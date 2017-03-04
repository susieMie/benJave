package test04;

public abstract class Tsun {

	protected Tsun() {
		this.skilmLevel = 0;
	}

	protected abstract Integer tsunId();

	private int skilmLevel;

	// PTOTECTED:同一package内と、そのクラスを継承したサブクラス内からアクセスできる
	protected String GetStr2() {
		return "protectedメソッド";
	}

	public abstract String getName();

	public String getSkilm() {
		return "Overrideして下さい。";
	}

	public final int getSkilmLevel() {
		return skilmLevel;
	}

	public final void setSkilmeLevel(int skilmLevel) {
		this.skilmLevel = skilmLevel;
	}

	public void printInfo() {
		java.lang.System.out.println(this.getName());
		java.lang.System.out.println(this.getSkilm());
	}

	@Override
	public boolean equals(final Object obj) {

		if (!(obj instanceof Tsun)) {
			return false;
		}
		final Tsun otherPerson = (Tsun) obj;

		if (this.tsunId() == otherPerson.tsunId()) {
			return true;
		} else {
			return false;
		}
	}
}
