package ie.lero.compliance.ui.views;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class EnvironmentView extends ViewPart {

	public static final String ID = "ie.lero.compliance.ui.environmentView";

	private TableViewer viewer;

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
//		GridLayout layout = new GridLayout(2, false);
//		parent.setLayout(layout);
//		Label searchLabel = new Label(parent, SWT.NONE);
//		searchLabel.setText("Search: ");
//		final Text searchText = new Text(parent, SWT.BORDER | SWT.SEARCH);
//		searchText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		createColumns(parent);
	}

	private void createColumns(Composite parent) {
		String[] titles = { "Element", "Value" };
		int[] bounds = { 100, 100 };

		TableViewerColumn col;
		for (int i = 0; i < titles.length; i++) {
			col = createTableViewerColumn(titles[i], bounds[i], i);
			// XXX trying to add the columns
			//viewer.add(col);
		}

	}

	private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

}
