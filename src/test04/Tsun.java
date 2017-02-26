package test04;

public abstract class Tsun {

	protected abstract Integer tsunId();

	// PTOTECTED:同一package内と、そのクラスを継承したサブクラス内からアクセスできる
	protected String GetStr2() {
		return "protectedメソッド";
	}

	public abstract String getName();

	public String getSkill() {
		return "Overrideして下さい。";
	}

	public abstract int getLevel();

	public void printInfo() {
		java.lang.System.out.println(this.getName());
		java.lang.System.out.println(this.getSkill());
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
