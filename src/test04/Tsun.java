package test04;

public abstract class Tsun {

	protected Tsun() {
		this.skilmLevel = 0;
	}

	protected abstract Integer tsunId();

	private int skilmLevel;
	private int level;

	// PTOTECTED:同一package内と、そのクラスを継承したサブクラス内からアクセスできる
	protected String GetStr2() {
		return "protectedメソッド";
	}

	public abstract String getName();

	public String getSkilm() {
		return "Overrideして下さい。";
	}

	// skilmLevel
	public final int getSkilmLevel() {
		return this.skilmLevel;
	}

	public final void setSkilmeLevel(int skilmLevel) {
		this.skilmLevel = skilmLevel;
	}

	// level
	public final int getLevel() {
		return this.level;
	}

	public final void setLevel(int level) {
		this.level = level;
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

	public final org.w3c.dom.Element createElement(final org.w3c.dom.Document document) {
		final org.w3c.dom.Element element = document.createElement(this.getClass().getSimpleName());

		element.setAttribute("skilmLevel", Integer.toString(this.getSkilmLevel()));
		element.setAttribute("level", Integer.toString(this.getSkilmLevel()));
		element.appendChild(document.createTextNode("a123456789z"));

		return element;
	}

	/**
	 * メソッドの説明。
	 *
	 * @param node ここから読み込む
	 * @since 1.5
	 * @see "関連"
	 * @see <a href="http://www.example.com/">Example</a>
	 */
	public void loadNode(final org.w3c.dom.Node node) {
		final org.w3c.dom.NamedNodeMap namedNodeMap = node.getAttributes();
		if (node != null) {
			final org.w3c.dom.Node item = namedNodeMap.getNamedItem("skilmLevel");
			if (item != null) {
				this.setSkilmeLevel(Integer.parseInt(item.getNodeValue()));
			}
		}
	}

}
