package jsoft.proj.ads.article.section;

import java.util.*;

import jsoft.proj.*;
import jsoft.proj.objects.*;

public class SectionControl {
	private SectionModel sm;

	public SectionControl(ConnectionPool cp) {
		this.sm = new SectionModel(cp);
	}

	@Override
	protected void finalize() throws Throwable {
		this.sm = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.sm.getConnectionPool();
	}

	public void releaseConnection() {
		this.sm.releaseConnection();
	}

	// ******************************************

	public SectionItem getSectionItem(short id) {
		return this.sm.getSectionItem(id);
	}
	// ****************************************

	public boolean addSection(SectionItem item) {
		return this.sm.addSection(item);
	}

	public boolean editSection(SectionItem item) {
		return this.sm.editSection(item);
	}

	public boolean delSection(SectionItem item) {
		return this.sm.delSection(item);
	}

	// *****************************************
	@SuppressWarnings("rawtypes")
	public String viewSections(SectionItem similar, int at, byte total) {
		ArrayList items = this.sm.getSectionItems(similar, at, total);
		return SectionLibrary.viewSections(items);
	}

	public static void main(String[] args) {
		// bo quan ly ket noi
		ConnectionPool cp = new ConnectionPoolImpl();

		// doi truong thuc thi
		SectionControl sc = new SectionControl(cp);

		// lay ve du lieu
		String viewsSections = sc.viewSections(null, 1, (byte) 20);

		// hien thi
		System.out.print(viewsSections);
	}
}
