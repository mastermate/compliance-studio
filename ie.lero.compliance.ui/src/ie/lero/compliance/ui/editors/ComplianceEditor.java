package ie.lero.compliance.ui.editors;

import org.eclipse.ui.editors.text.TextEditor;

public class ComplianceEditor extends TextEditor {

	private ColorManager colorManager;

	public ComplianceEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		setDocumentProvider(new XMLDocumentProvider());
	}
	@Override
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
