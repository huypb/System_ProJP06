package jsoft.proj.ads.article.section;

import java.sql.*;
import java.util.*;

import jsoft.proj.*;
import jsoft.proj.objects.*;

public class SectionModel {

	private Section s;

	public SectionModel(ConnectionPool cp) {
		this.s = new SectionImpl(cp, "Section");
	}

	@Override
	protected void finalize() throws Throwable {
		this.s = null;
	}

	// chia se ket noi
	public ConnectionPool getConnectionPool() {
		return this.s.getConnectionPool();
	}

	// yeu cau tra lai ket noi
	public void releaseConnection() {
		this.s.releaseConnection();
	}

	// ************************************************************

	public boolean addSection(SectionItem item) {
		return this.s.addSection(item);
	}

	public boolean editSection(SectionItem item) {
		return this.s.editSection(item);
	}

	public boolean delSection(SectionItem item) {
		return this.s.delSection(item);
	}

	// **************************************************************

	public SectionItem getSectionItem(short id) {
		SectionItem item = null;
		ResultSet rs = this.s.getSection(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new SectionItem();
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));
					item.setSection_notes(rs.getString("section_notes"));
				}
				rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return item;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList getSectionItems(SectionItem similar, int page, byte total) {
		ArrayList items = new ArrayList();
		SectionItem item = new SectionItem();
		int at = (page - 1) * total;

		ResultSet rs = this.s.getSections(similar, at, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new SectionItem();
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));
					item.setSection_notes(rs.getString("section_notes"));

					items.add(item);
				}
				rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return items;
	}
}
